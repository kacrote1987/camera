package com.wision.util.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaiDuTest {
    /** 百度搜索基本url 后面可以接的参数有 pn rn ie 等 */
    public final static String baseUrl = "http://app.huzhou.gov.cn/hzgov/front/datacall/search/search.do";
    /** 连接超时时间 */
    public static int timeout = 30 * 1000;
    /** 连接重试次数 */
    public static int times = 10;
    /** UA */
    public static String UserAgent[] = {
            "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50",
            "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50",
            "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; .NET4.0C; .NET4.0E; .NET CLR 2.0.50727; .NET CLR 3.0.30729; .NET CLR 3.5.30729; InfoPath.3; rv:11.0) like Gecko",
            "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E)",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36 OPR/37.0.2178.32",
            "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 UBrowser/5.6.12150.8 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.87 Safari/537.36 OPR/37.0.2178.32" };

    /** 获取随机UA */
    public static String getRandomUA() {
        return UserAgent[(int) (Math.random() * (UserAgent.length))];
    }

    /** 在这里进行连接 如果失败会继续重试 */
    public static Document getDocument(String url) {
        Document doc = null;
        for (int i = 0; i < times; i++) {
            try {
                doc = Jsoup.connect(url).header("User-Agent", getRandomUA()).timeout(timeout).get();
                if (doc != null)
                    break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return doc;
    }

    /**
     * 爬取百度指定关键字和页码的数据，只存id(排名号)，title，url(百度会把url缩写) 亲测虽然
     * 加了&rn=50可以明显增加效率，但结果和用户实际看到的有所出入，并不准确，故用默认rn，与用户实际看到保持一致
     *
     * @param keyword 关键字
     * @param page    页码
     */
    public static List<Map<String, String>> spider(String keyword, int page) {
        List<Map<String, String>> result = new ArrayList<>();
        try {
            Document document = getDocument(baseUrl + "&wd=" + keyword + "&pn=" + (page * 10));
            Elements els = document.getElementsByClass("result");
            for (Element el : els) {
                Map<String, String> map = new HashMap<>();
                try {
                    map.put("id", el.attr("id"));
                    map.put("title", el.getElementsByTag("a").get(0).text());
                    map.put("url", el.getElementsByClass("f13").get(0).getElementsByTag("a").text());
                    result.add(map);
                } catch (Exception e) {
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 分析在指定关键字在百度的排名
     *
     * @param keyword 关键字
     * @param url     要找的目标包含的url
     * @param maxPage 最多找几页，防止死循环
     * @return 找得到返回map 超过最大页码还找不到返回null
     */
    public static Map<String, String> BaiduRanking(String keyword, String url, int maxPage) {
        System.out.println("开始查找百度中关键字为 \"" + keyword + "\" 且url包含 \""
                + url + "\" 的相关数据排名 最多查询 " + maxPage + "页");
        for (int i = 0; i < maxPage; i++) {
            // 输出当前页码和个数，不需要输出可以去掉
            System.out.println("正在查询第" + i + "页中的第" + (i * 10 + 1) + " ~ " + ((i + 1) * 10) + "个");
            List<Map<String, String>> list = spider(keyword, i);
            for (Map<String, String> map : list) {
                if (map.get("url").contains(url)) {
                    return map;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        /*
         * 例如 找关键字 极简壁纸 主要的网址特征 bz.zzzmh.cn 最多找20页 (相当于找1~200个中有无匹配)
         * 若有匹配返回 id title url
         * 若无匹配返回 Null
         */
        System.out.println(BaiduRanking("垃圾分类", "", 20));
    }
}