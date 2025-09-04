package com.project.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class ApiDemo {
	public static List<Map<String, Object>> reuqest(String httpUrl, String httpArg, String method) {
		List<Map<String, Object>> result = new ArrayList<>() ;
		httpUrl = httpUrl + "?" + httpArg;
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			InputStream is = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead;
			StringBuffer sbf = new StringBuffer();
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
//			对取到的值进行处理，返回list格式
			List<String> list = new ArrayList<>(Arrays.asList(sbf.toString().substring(1,sbf.length()-1).split(",")));
			Map<String, Object> map = new HashMap<>() ;
			for (int i = 0; i < list.size(); i++) {
			    map.put(list.get(i).substring(1,list.get(i).indexOf(":")-1), list.get(i).substring(list.get(i).indexOf(":")+2,list.get(i).length()-2)) ;
			}
			result.add(map);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) throws JSONException {
//		接口参数MD5加密
		String appKey = "A330000331387202105000947";
		String appSecret = "n8Xgbf4b7zch4wb6";
		String requestTime = String.valueOf(System.currentTimeMillis());
		String sign = DigestUtils.md5Hex(appKey + appSecret + requestTime);

//		身份认证
		String httpUrl = "https://interface.huzhou.gov.cn/gateway/app/refreshTokenByKey.htm";
		String method = "GET";
		String httpArg = "appKey=" + appKey;
		       httpArg = httpArg + "&sign=" + sign;
		       httpArg = httpArg + "&requestTime=" + requestTime;
		List<Map<String, Object>> result = reuqest(httpUrl,httpArg,method);
//		解析数据
		for(int i=0;i<result.size();i++){
			System.out.println("requestSecret=" + result.get(i).get("requestSecret").toString());
		}
	}
}