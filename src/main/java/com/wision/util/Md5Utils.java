package com.wision.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Md5Utils {
    public static String md5(String str){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("utf-8"));
            byte[] digest = md5.digest();
            String s = new BigInteger(1,digest).toString(16).toUpperCase();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}