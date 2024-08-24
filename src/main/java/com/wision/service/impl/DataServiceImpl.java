package com.wision.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.SourListForm;
import com.wision.entity.SourListVo;
import com.wision.mapper.DataMapper;
import com.wision.service.DataService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;

import static com.wision.util.Md5Utils.md5;

@Service
public class DataServiceImpl implements DataService {
    @Resource
    DataMapper dataMapper;

    @Override
    public PageInfo<SourListVo> sourList(SourListForm params) {
        PageHelper.startPage(params.getPage(), 10);
        List<SourListVo> sourList = dataMapper.sourList(params);
        return PageInfo.of(sourList);
    }

    @Override
    public void send() {
        String urlparam1 = "http://api.hztjzx.cn:9095/api_lift?action=token";
        String appKey="wV2UkhnaL1xn9zwQhGMdpDCycLV9lC";
        String appSecret="176aca180c6d520473f79bb4727b1993";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HHmmss");
        String timestamp = sdf1.format(new java.util.Date())+"T"+sdf2.format(new java.util.Date());
        String sign=md5(appKey+appSecret+timestamp);
        String urlstr1=urlparam1+"&appKey="+appKey+"&appSecret="+appSecret+"&timestamp="+timestamp+"&sign="+sign;
//        System.out.println("url="+urlstr1);
        HttpURLConnection connection = null;
        try{
            URL url = new URL(urlstr1);
            connection = (HttpURLConnection) url.openConnection();// 根据URL生成HttpURLConnection
            connection.setRequestMethod("GET");// 默认GET请求
            connection.connect();// 建立TCP连接
            StringBuilder result=null;
            String appToken="";
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));// 发送http请求
                result= new StringBuilder();
                // 循环读取流
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line).append(System.getProperty("line.separator"));// "\n"
                }
            }
//           先申请到appToken=1BC4A9DA63A04B6692EAFE382B15DBB3
            appToken=result.substring(result.indexOf("app_token")+12,result.indexOf("token_valid_time")-3);
            System.out.println("appToken="+appToken);


            //业务流
            String urlstr2="http://api.dc.hztjzx.cn:9095/api_dc?action=get_device_num";
            JSONObject req1=new JSONObject();
            req1.put("version","1.0");
            req1.put("timestamp",timestamp);
            String signature=md5("&action=get_device_num&timestamp="+timestamp+"&token="+appToken+"&");
            req1.put("signature",signature);
            JSONObject req2=new JSONObject();
            req2.put("device_num","ET210660");
            req2.put("device_type","3");
            JSONObject req=new JSONObject();
            req.put("req_context",req1);
            req.put("req_info",req2);

//            StringEntity params =new StringEntity("details={\"name\":\"myname\",\"age\":\"20\"} ");
//            request.setEntity(params);

//            try{
//                URL url2 = new URL(urlstr2);
//                connection = (HttpURLConnection) url2.openConnection();// 根据URL生成HttpURLConnection
//                connection.setRequestMethod("POST");// 默认GET请求
//                connection.connect();// 建立TCP连接
//                StringBuilder result2=null;
//                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));// 发送http请求
//                    result2= new StringBuilder();
//                    // 循环读取流
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        result2.append(line).append(System.getProperty("line.separator"));// "\n"
//                    }
//                }
//                System.out.println("result2="+result2);
//            }catch(Exception e){
//                e.printStackTrace();
//            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
