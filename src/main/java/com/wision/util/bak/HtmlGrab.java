package com.wision.util.Jsoup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlGrab {
    /**
     * 发起http get请求获取网页源代码
     * @param requestUrl     String    请求地址
     * @return                 String    该地址返回的html字符串
     */
    private static String httpRequest(String requestUrl) {

        StringBuffer buffer = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        InputStream inputStream = null;
        HttpURLConnection httpUrlConn = null;

        try {
            // 建立get请求
            URL url = new URL(requestUrl);
            httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");

            // 获取输入流
            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);

            // 从输入流读取结果
            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            // 释放资源
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpUrlConn != null){
                httpUrlConn.disconnect();
            }
        }
        return buffer.toString();
    }


    public static void main(String[] args) {
        // 调用第一个方法，获取html字符串
        String html = httpRequest("http://app.huzhou.gov.cn/hzgov/front/datacall/search/search.do?iid=72&indexids=18&siteid=127&sorttype=0&wd=%E5%9E%83%E5%9C%BE%E5%88%86%E7%B1%BB");
        System.out.println("html页面---"+html);
        // 需要取出有用数据的标签范围
        Pattern p = Pattern.compile("(.*)(<div data-index=\"1\" class=\"condition-contents condition-common-contents\" data-v-e5828188>)(.*?)(</div>)(.*)");
        Matcher m = p.matcher(html);

        if (m.matches()) {
            String str = m.group(3);
            System.out.println(str);

            StringBuffer buffer = new StringBuffer();
            String[] strs=str.split("<span title=\"\" class=\"condition-item\" data-v-e5828188>");
            for(int i=0,len=strs.length;i<len;i++){
                buffer.append(strs[i].toString());
            }
            String[] strs1=buffer.toString().split("</span>");
            for(int i=0,len=strs.length;i<len;i++){
                System.out.println(strs1[i].toString());;
            }
        }
    }
}