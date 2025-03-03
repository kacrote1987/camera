//package com.wision.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
//import com.wechat.pay.contrib.apache.httpclient.auth.AutoUpdateCertificatesVerifier;
//import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
//import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
//import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
//import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
//import com.wechat.pay.java.core.RSAAutoCertificateConfig;
//import com.wechat.pay.java.service.lovefeast.model.Amount;
//import com.wision.service.ToolStoService;
//import com.wision.util.KafkaConsumer;
//import com.wision.util.MinioUtil;
////import com.wision.util.QRCodeGenerator;
////import com.wision.util.WechatPay;
//import org.junit.After;
//import org.junit.Before;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.security.PrivateKey;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//@Service
//public class ToolStoServiceImpl implements ToolStoService {
////    @Resource
////    QRCodeGenerator qrCodeGenerator;
////    @Resource
////    KafkaConsumer kafkaConsumer;
//    @Resource
////    WechatPay wechatPay;
//
////    @Override
////    public void qrcode() {
////        qrCodeGenerator.simple();
////    }
//
//    @Override
////    public void payByWx(){
////        // 参数配置
////        String appId = "wx8790234sau98232ehb2"; // 应用号
////        String mchId = "1571814339"; // 商户号
////        String privateKey = ""; // 私钥字符串，此处省略
////        String mchSerialNo = "25FS78SGSGFGG7879SGS987GS675AT6"; // 商户证书序列号
////        String apiV3Key = "CZBK12Y675AHIGA97987987957AD"; // V3密钥
////        String description = "Image形象店-深圳腾大-QQ公仔"; // 商品描述
////        String outTradeNo = "1217752501201407033233368018"; // 订单号
////        String notifyUrl = "https://www.weixin.qq.com/wxpay/pay.php"; // 支付成功回调通知地址
////        Amount amount; // 订单金额信息
////        Integer total=0; // 金额，单位为分
////
////        // 定义请求body参数（后面要修改，其包含应用ID、商户号、订单金额等信息）
////        String reqdata = "{"
////                + "\"time_expire\":\"2024-11-08T10:34:56+08:00\","
////                + "\"amount\": {"
////                + "\"total\":" + total + ","
////                + "\"currency\":\"CNY\""
////                + "},"
////                + "\"mchid\":"+ mchId +","
////                + "\"description\":" + description + ","
////                + "\"notify_url\":" + notifyUrl + ","
////                + "\"out_trade_no\":" + outTradeNo + ","
////                + "\"goods_tag\":\"WXG\","
////                + "\"appid\":" + appId + ","
////                + "\"attach\":\"自定义数据说明\","
////                + "\"detail\": {"
////                + "\"invoice_id\":\"wx123\","
////                + "\"goods_detail\": ["
////                + "{"
////                + "\"goods_name\":\"iPhoneX 256G\","
////                + "\"wechatpay_goods_id\":\"1001\","
////                + "\"quantity\":1,"
////                + "\"merchant_goods_id\":\"商品编码\","
////                + "\"unit_price\":828800"
////                + "},"
////                + "{"
////                + "\"goods_name\":\"iPhoneX 256G\","
////                + "\"wechatpay_goods_id\":\"1001\","
////                + "\"quantity\":1,"
////                + "\"merchant_goods_id\":\"商品编码\","
////                + "\"unit_price\":828800"
////                + "}"
////                + "],"
////                + "\"cost_price\":608800"
////                + "},"
////                + "\"scene_info\": {"
////                + "\"store_info\": {"
////                + "\"address\":\"广东省深圳市南山区科技中一道10000号\","
////                + "\"area_code\":\"440305\","
////                + "\"name\":\"腾讯大厦分店\","
////                + "\"id\":\"0001\""
////                + "},"
////                + "\"device_id\":\"013467007045764\","
////                + "\"payer_client_ip\":\"14.23.150.211\""
////                + "}"
////                + "}";
////
////        try {
//////            wechatPay.CreateOrder(reqdata);
////        } catch (Exception e) {
////            throw new RuntimeException(e);
////        }
////    }
//
//    @Override
//    public void kafka() {
////        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
////        Runnable consumerTask = () -> {
////            // 此处调用Kafka消费函数
////            KafkaConsumer.main(null);
////        };
////        // 每10秒执行一次
////        scheduler.scheduleAtFixedRate(consumerTask, 0, 10, TimeUnit.SECONDS);
//    }
//
//}
