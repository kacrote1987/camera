package com.wision.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.ApiDet;
import com.wision.entity.ApiList;
import com.wision.entity.InsureForm;
import com.wision.mapper.ApiMapper;
import com.wision.service.ApiService;
//import com.wision.util.ExcelUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

@Service
public class ApiServiceImpl implements ApiService {
    @Resource
    ApiMapper apiMapper;

    @Override
    public PageInfo<ApiList> apiList(ApiList params) {
        PageHelper.startPage(params.getPage(), 10);
        List<ApiList> apiList = apiMapper.apiList(params);
        return PageInfo.of(apiList);
    }

    @Override
    public List<ApiDet> apiDet(String apiId) {
        List<ApiDet> apiDet = null;
        if (!apiId.equals("add")) {
            apiDet = apiMapper.apiDet(Long.valueOf(apiId));
        }
        return apiDet;
    }

    @Override
    public void apiSave(ApiDet params) {
        if (params.getAction().equals("add")) {
            apiMapper.insertApi(params);
        } else if (params.getAction().equals("del")) {
            apiMapper.deleteApi(params.getApiId());
        } else {
            apiMapper.updateApi(params);
        }
    }

    @Override
    public void excelImport(MultipartFile file, String table) throws Exception {
//        String[] keys = {"recipient_name", "id_card","lz","dy","fh","cb","jy"};
//        List<Map<String, Object>> list= ExcelUtils.importExcel(file,keys);
//        for(Map<String,Object> map:list){
//            apiMapper.insertExcel("t_supp_api_insure",map.get("recipient_name").toString(),map.get("id_card").toString(),map.get("lz").toString()
//                    ,map.get("dy").toString(),map.get("fh").toString(),map.get("cb").toString(),map.get("jy").toString());
//        }
    }

    @Override
    public void getRequestTime(Long apiId) {
        String requestTime = String.valueOf(System.currentTimeMillis());
        apiMapper.updateRequestTime(requestTime,apiId);
    }

    @Override
    public void getSign2(ApiDet params) {
        String sign1 = DigestUtils.md5Hex(params.getAppKey() + params.getAppSecret() + params.getRequestTime());
        String httpUrl1 = "https://interface.huzhou.gov.cn/gateway/app/refreshTokenByKey.htm";
        String httpArg1 = "appKey=" + params.getAppKey();
               httpArg1 = httpArg1 + "&requestTime=" + params.getAppKey();
               httpArg1 = httpArg1 + "&sign=" + sign1;
        String method1 = "GET";
        String str = reuqest(httpUrl1,httpArg1,method1);
        System.out.println("str="+str);
//        String sign2 = DigestUtils.md5Hex(appKey + "c0d5ee93f0dc445f8d3ec0b6710cf952" + requestTime);
    }

    @Override
    public void insureRequest() {
//		1、身份认证
        String appKey = "A330000331387202105000947";
        String appSecret = "n8Xgbf4b7zch4wb6";
        String requestTime = "1688555992127";
        String sign = DigestUtils.md5Hex(appKey + appSecret + requestTime);

//		2、批量取值查接口
        List<InsureForm> insureList = apiMapper.selectInsureAll();
        for(int i=0;i<insureList.size();i++){
            String sign2 = DigestUtils.md5Hex(appKey + "c0d5ee93f0dc445f8d3ec0b6710cf952" + requestTime);
            String aac002 = insureList.get(i).getIdCard();
            String aac003 = null;
            try {
                aac003 = URLEncoder.encode(insureList.get(i).getRecipientName(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String httpUrl1 = "https://interface.huzhou.gov.cn/gateway/api/001008005007011/dataSharing/P81BsE1al614Me0d.htm";
            String method1 = "POST";
            String httpArg1 = "appKey=" + appKey;
            httpArg1 = httpArg1 + "&requestTime=" + requestTime;
            httpArg1 = httpArg1 + "&sign=" + sign2;
            httpArg1 = httpArg1 + "&aac002=" + aac002;
            httpArg1 = httpArg1 + "&aac003=" + aac003;

//			对取到的值进行处理，返回list格式
            String str = reuqest(httpUrl1,httpArg1,method1);
            List<Map<String, Object>> result = new ArrayList<>() ;
            while (str.contains("{")){
                str = str.substring(str.indexOf("{")+1,str.lastIndexOf("}")-1);
            }
            str = str.replace("\\n\\t\\t\\t\\","");
            str = str.replace("\\n\\t\\","");
            str = str.replace("\\","");
            if(str.length()>32){
                List<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
                Map<String, Object> map = new HashMap<>() ;
                for (int j = 0; j < list.size(); j++) {
                    map.put(list.get(j).substring(1,list.get(j).indexOf(":")-1), list.get(j).substring(list.get(j).indexOf(":")+2,list.get(j).length()-1)) ;
                }
                result.add(map);
            }
            if(result.get(0).get("aac002")!=null){
                apiMapper.updateInsure(result.get(0).get("aac002").toString(),result.get(0).get("aae140").toString(),result.get(0).get("bj").toString());
            }
        }
    }

    @Override
    public List<InsureForm> insureList(InsureForm params){
        List<InsureForm> insureList = apiMapper.selectInsure(params);
        return insureList;
    }

    public static String reuqest(String httpUrl, String httpArg, String method) {
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sbf.toString();
    }
}
