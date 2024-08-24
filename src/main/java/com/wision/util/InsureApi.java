package com.wision.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

public class InsureApi {
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
			String str = sbf.toString();
			while (str.contains("{")){
				str = str.substring(str.indexOf("{")+1,str.lastIndexOf("}")-1);
			}

			str = str.replace("\\n\\t\\t\\t\\","");
			str = str.replace("\\n\\t\\","");
			str = str.replace("\\","");
			List<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
			Map<String, Object> map = new HashMap<>() ;
			for (int i = 0; i < list.size(); i++) {
				map.put(list.get(i).substring(1,list.get(i).indexOf(":")-1), list.get(i).substring(list.get(i).indexOf(":")+2,list.get(i).length()-1)) ;
			}
			result.add(map);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) throws JSONException, UnsupportedEncodingException {
//		1、身份认证
		String appKey = "A330000331387202105000947";
		String appSecret = "n8Xgbf4b7zch4wb6";
		String requestTime = "1688555992127";
//		System.out.println("requestTime="+String.valueOf(System.currentTimeMillis()));
		String sign = DigestUtils.md5Hex(appKey + appSecret + requestTime);
		System.out.println("sign=" + sign);

//		String httpUrl = "https://interface.huzhou.gov.cn/gateway/app/refreshTokenByKey.htm";
//		String method = "GET";
//		String httpArg = "appKey=" + appKey;
//		       httpArg = httpArg + "&sign=" + sign;
//		       httpArg = httpArg + "&requestTime=" + requestTime;
//		List<Map<String, Object>> result = reuqest(httpUrl,httpArg,method);
//		String requestSecret=result.get(0).get("requestSecret").toString();
//		System.out.println("requestSecret=" + requestSecret);

//		2、请求业务数据
//		String sign2 = DigestUtils.md5Hex(appKey + requestSecret + requestTime);
		String sign2 = DigestUtils.md5Hex(appKey + "c0d5ee93f0dc445f8d3ec0b6710cf952" + requestTime);
//		System.out.println("sign2=" + sign2);


		String aac002 = "330501198710191611";
		String aac003 = URLEncoder.encode("叶健", "UTF-8");
		String httpUrl1 = "https://interface.huzhou.gov.cn/gateway/api/001008005007011/dataSharing/P81BsE1al614Me0d.htm";
		String method1 = "POST";
		String httpArg1 = "appKey=" + appKey;
		       httpArg1 = httpArg1 + "&requestTime=" + requestTime;
		       httpArg1 = httpArg1 + "&sign=" + sign2;
		       httpArg1 = httpArg1 + "&aac002=" + aac002;
		       httpArg1 = httpArg1 + "&aac003=" + aac003;
		List<Map<String, Object>> result1 = reuqest(httpUrl1,httpArg1,method1);
		System.out.println("aac002="+result1.get(0).get("aac002")+";aae140="+result1.get(0).get("aae140")+";bj="+result1.get(0).get("bj"));

	}
}