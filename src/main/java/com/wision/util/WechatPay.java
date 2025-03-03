//package com.wision.util;
//
//import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
//import com.wechat.pay.contrib.apache.httpclient.auth.AutoUpdateCertificatesVerifier;
//import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
//import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
//import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
//import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.util.EntityUtils;
//import org.junit.After;
//import org.junit.Before;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.security.PrivateKey;
//
//public class WechatPay {
//	//	调用统一下单API
//	// 定义httpClient对象
//	CloseableHttpClient httpClient;
//	@Before
//	public void setup(String privateKey,String mchId,String mchSerialNo,String apiV3Key) throws IOException {
//		// 加载商户私钥（privateKey：私钥字符串）
//		PrivateKey merchantPrivateKey = PemUtil
//				.loadPrivateKey(new ByteArrayInputStream(privateKey.getBytes("utf-8")));
//
//		// 加载平台证书（mchId：商户号,mchSerialNo：商户证书序列号,apiV3Key：V3密钥）
//		AutoUpdateCertificatesVerifier verifier = new AutoUpdateCertificatesVerifier(
//				new WechatPay2Credentials(mchId, new PrivateKeySigner(mchSerialNo,merchantPrivateKey)),apiV3Key.getBytes("utf-8"));
//
//		// 初始化httpClient
//		httpClient = WechatPayHttpClientBuilder.create()
//				.withMerchant(mchId, mchSerialNo, merchantPrivateKey)
//				.withValidator(new WechatPay2Validator(verifier)).build();
//	}
//
//	@After
//	public void after() throws IOException {
//		httpClient.close();
//	}
//
//	public void CreateOrder(String reqdata) throws Exception{
//		// 定义Post类型的http请求（参数是请求的地址，固定不变的，因为请求的是微信支付系统的地址）
//		HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/v3/pay/transactions/native");
//
//		StringEntity entity = new StringEntity(reqdata,"utf-8");
//		entity.setContentType("application/json");
//		httpPost.setEntity(entity);
//		httpPost.setHeader("Accept", "application/json");
//
//		//完成签名并执行请求（调用下单API）
//		CloseableHttpResponse response = httpClient.execute(httpPost);
//
//		try {
//			int statusCode = response.getStatusLine().getStatusCode();
//			if (statusCode == 200) { //处理成功
//				System.out.println("success,return body = " + EntityUtils.toString(response.getEntity()));
//				// 将上面的返回结果code_url返回(return)给前端，前端根据这个code_url生成二维码图片
//			} else if (statusCode == 204) { //处理成功，无返回Body
//				System.out.println("success");
//			} else {
//				System.out.println("failed,resp code = " + statusCode+ ",return body = " + EntityUtils.toString(response.getEntity()));
//				throw new IOException("request failed");
//			}
//		} finally {
//			response.close();
//		}
//	}
//
//}
