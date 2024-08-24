package com.wision.controller.test;

import java.io.InputStream;

import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class shengchen {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            String sCurrentLine = "";
            String sTotalString = "";
            InputStream l_urlStream;
            URL l_url;
            l_url = new URL("http://www.swimoutlet.com/Google_SiteMap_Products.xml");
            HttpURLConnection l_connection = (HttpURLConnection) l_url.openConnection();
            l_connection.connect();
            l_urlStream = l_connection.getInputStream();
            BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
            while ((sCurrentLine = l_reader.readLine()) != null) {
                sTotalString += sCurrentLine;
            }
            //out.println(sTotalString);
            String over = new String(sTotalString.getBytes("UTF-8"), "gb2312");
            String url = "D:/test/index.xml";
            FileOutputStream fileoutputstream = new FileOutputStream(url);
            byte tag_bytes[] = sTotalString.getBytes();
            fileoutputstream.write(tag_bytes);
            fileoutputstream.close();
            System.out.println("生成成功！");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
