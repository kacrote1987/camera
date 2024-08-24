package com.wision.util.Jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.text.ParseException;

public class JsoupMain {
    public static void main(String[] args) throws ParseException {
        try {
            String url="https://zfcg.czt.zj.gov.cn/site/category?parentId=600007&childrenCode=ZcyAnnouncement&utm=web-websitegroup-front.4d3d4f8c.959-pc-websitegroup-navBar-front.3.5fcce8f0ab7211eeac6347ca3e02372d";
            //解析Url获取Document对象
            Connection conn = Jsoup.connect(url).timeout(5000);
            conn.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            conn.header("Accept-Encoding", "gzip, deflate, sdch");
            conn.header("Accept-Language", "zh-CN,zh;q=0.8");
            conn.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
            Document document = Jsoup.connect(url).get();
            //获取网页源码文本内容
            System.out.println(document.toString());
            //获取指定class的内容指定tag的元素
//            Elements liElements = document.getElementsByTag("iid");
//            Elements liElements1 = document.getElementsByClass("iid");
//            Elements liElements2 = document.getElementsByClass("jslj");
//            for (int i = 1; i < liElements1.size(); i++) {
//                System.out.println(i + "、" + liElements1.get(i).text() + '：' + liElements2.get(i).text());
//            }
        } catch (IOException e) {
            System.out.println("解析出错！");
            e.printStackTrace();
        }
    }
}