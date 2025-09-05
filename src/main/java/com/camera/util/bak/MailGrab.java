package com.wision.util.Jsoup;

import java.io.*;
import java.util.regex.*;
import java.net.*;

public class MailGrab {
    public static void main(String[] args) throws Exception{
        getMailAddr();
    }

    public static void getMailAddr()throws Exception{
        URL url=new URL("http://app.huzhou.gov.cn/hzgov/front/datacall/search/search.do");
        URLConnection con=url.openConnection();

        BufferedReader bufIn=new BufferedReader(new InputStreamReader(con.getInputStream()));
        BufferedWriter bufw=new BufferedWriter(new FileWriter(new File("D:\\mailaddress2.txt")));
        String str=null;
        String regex="[a-zA-Z0-9_]{6,12}@[a-zA-Z0-9]+(.[a-zA-Z]+)+";

        Pattern p=Pattern.compile(regex);
        System.out.println("start");
        while((str=bufIn.readLine())!=null) {
            Matcher m=p.matcher(str);
            while(m.find()){
                String ss=m.group();
                bufw.write(ss,0,ss.length());
                bufw.newLine();
                bufw.flush();
            }
        }
        System.out.println("end");
    }
}