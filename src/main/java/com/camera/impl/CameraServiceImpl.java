package com.camera.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.camera.entity.*;
import com.camera.mapper.CameraMapper;
import com.camera.service.CameraService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CameraServiceImpl implements CameraService {
    @Resource
    CameraMapper cameraMapper;

    @Override
    public PageInfo<ApplyList> applyList(ApplyList params) {
        PageHelper.startPage(params.getPage(), 15);
        List<ApplyList> applyList = cameraMapper.applyList(params);
        return PageInfo.of(applyList);
    }

    @Override
    public List<ApplyDet> applyDet(Long applyId) {
        List<ApplyDet> applyDet = cameraMapper.applyDet(applyId);
        return applyDet;
    }

    @Override
    public List<ApplyPoint> applyPoint(Long applyId) {
        List<ApplyPoint> applyPoint = cameraMapper.applyPoint(applyId);
        return applyPoint;
    }

    @Override
    public PageInfo<CameraList> cameraList(CameraList params) {
        PageHelper.startPage(params.getPage(), 15);
        List<CameraList> cameraList = cameraMapper.cameraList(params);
        return PageInfo.of(cameraList);
    }

    @Override
    public List<CameraDet> cameraDet(String cameraId) {
        List<CameraDet> cameraDet = null;
        if (!cameraId.equals("add")) {
            cameraDet = cameraMapper.cameraDet(Long.valueOf(cameraId));
        }
        return cameraDet;
    }

    @Override
    public void cameraSave(CameraDet params) {
        cameraMapper.cameraSave(params);
    }

    @Override
    public ArrayList<JSONObject> lngLat() {
        // 获取经纬度的值,要实现[{ lnglat: [120.089872,30.856878] },{ lnglat: [120.090007,30.857244] },{ lnglat: [120.093914,30.854382] }]
        List<LnglatDet> lngLat=cameraMapper.lngLat();
        ArrayList<JSONObject> myArray = new ArrayList<>();
        for(int i=0;i<lngLat.size();i++) {
            String str = "{ \"lnglat\": [" + lngLat.get(i).getCameraLng() + "," + lngLat.get(i).getCameraLat() + "] }";
            JSONObject jsonObject = JSONObject.parseObject(str);
            myArray.add(jsonObject);
        }
        return myArray;
    }

    @Override
    public List<CameraDet> lnglatDet(String lngLat) {
        String aa = lngLat;
        String cameraLng = lngLat.substring(0, lngLat.indexOf(","));
        String cameraLat = lngLat.substring(lngLat.indexOf(",")+1, lngLat.length());
        List<CameraDet> cameraDet = cameraMapper.lnglatDet(cameraLng,cameraLat);
        return cameraDet;
    }

    @Override
    public List<LnglatDet> lnglatDraw() {
        List<LnglatDet> lnglatDraw = cameraMapper.lnglatDraw();
        return lnglatDraw;
    }

    @Override
    public List<JSONArray> areaDraw() {
        // 获取经纬度的值,要实现[[120.089872,30.856878],[120.090007,30.857244],[120.093914,30.854382]]
        List<JSONArray> myList = new ArrayList<>();
        List<AreaDraw> areaDraw = cameraMapper.areaDraw();
        for(int i=0;i<areaDraw.size();i++){
            JSONArray jsonArray = new JSONArray();
            String str = areaDraw.get(i).getAreaCode();
            while(str.indexOf(";")>0) {
                double[] myArray = new double[2];
                String temp = str.substring(0,str.indexOf(";"));  //120.104785,30.859936;120.119891,30.860046;120.110064,30.850357;
                myArray[0] = Double.parseDouble(temp.substring(0,temp.indexOf(",")));
                myArray[1] = Double.parseDouble(temp.substring(temp.indexOf(",")+1,temp.length()));
                jsonArray.add(myArray);
                str = str.substring(str.indexOf(";")+1,str.length());
            }
            myList.add(jsonArray);
        }
        return myList;
    }

    @Override
    public void areaSave(String params) {
        cameraMapper.insertArea(params.substring(1,params.length()-1) + ';');
    }

    @Override
    public void areaDel(String params) {

    }

    @Override
    public PageInfo<TagList> tagList(TagList params) {
        PageHelper.startPage(params.getPage(), 15);
        List<TagList> tagList = cameraMapper.tagList(params);
        return PageInfo.of(tagList);
    }

    @Override
    public List<TagDetVo> tagDet(Long tagId) {
        List<TagDetVo> tagDet = cameraMapper.tagDet(tagId);
        return tagDet;
    }

    @Override
    public void tagSave(TagDetForm params) {
        if (params.getAction().equals("add")) {
            cameraMapper.insertTag(params);
        } else if (params.getAction().equals("del")) {
            cameraMapper.deleteTag(params.getTagId());
        } else {
            cameraMapper.updateTag(params);
        }
    }

    @Override
    public String tagGather() {
//        List<TagListVo> tagListVo = camMapper.tagGather();
//        String tagGather = "";
//        for (int i = 0; i < tagListVo.size(); i++) {
//            tagGather = tagGather + tagListVo.get(i).getTagGather() + ",";
//        }
//        tagGather = tagGather + tagListVo.size();
        return null;
    }

    @Override
    public void preSave(CameraList params) {
        cameraMapper.updatePre(params);
    }

    @Override
    public List<TagDetVo> reqOrder() {
        List<TagDetVo> reqOrder = cameraMapper.reqOrder();
        return reqOrder;
    }

    @Override
    public void orderSave(GanttDet params) {
//        String field = cameraMapper.updateOrder1(params.getDictValue()).get(0).getDictCode();
//        cameraMapper.updateOrder2(params.getDictValue(), field, params.getValue());
        cameraMapper.updateOrder3(params.getDictValue(), method(params.getField()), params.getValue());
    }

    @Override
    public List<TagDetVo> reqList(Long posId) {
        List<TagDetVo> reqTag = cameraMapper.reqTag(posId);
//        String tags = reqTag.get(0).getTagName() + ",";   //交通治理,垃圾分类,污水治理,
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < tags.length(); i++) {
//            if (tags.indexOf(',') > 0) {
//                list.add(tags.substring(0, tags.indexOf(',')));
//                tags = tags.substring(tags.indexOf(',') + 1, tags.length());
//            }
//        }
//        List<TagDetVo> reqList = cameraMapper.reqList(list);
        List<TagDetVo> reqList =null;
        return reqList;
    }

    @Override
    public PageInfo<ParamList> paramList(ParamList params) {
        PageHelper.startPage(params.getPage(), 15);
        List<ParamList> typeList = cameraMapper.paramList(params);
        return PageInfo.of(typeList);
    }

    @Override
    public List<ParamList> paramDet(Long paramId) {
        List<ParamList> paramDet = cameraMapper.paramDet(paramId);
        return paramDet;
    }

    @Override
    public void paramEdit(ParamList params) {
        cameraMapper.updateParam(params);
    }

    @Override
    public void typeSel(String params) {

    }

    @Override
    public PageInfo<RuleList> ruleList(RuleList params) {
        PageHelper.startPage(params.getPage(), 15);
        List<RuleList> ruleList = cameraMapper.ruleList(params);
        return PageInfo.of(ruleList);
    }

    @Override
    public List<RuleList> ruleDet(Long ruleId) {
        List<RuleList> ruleDet = cameraMapper.ruleDet(ruleId);
        return ruleDet;
    }

    @Override
    public void ruleEdit(RuleList params) {
        cameraMapper.updateRule(params);
    }

//    @Override
//    public List<TypeListVo> typeSelected(String params) {
//        String posId = params.substring(0, params.indexOf(","));
//        String typeSel = params.substring(params.indexOf(",") + 1, params.length());
//        List<TypeListVo> typeSeled = null;
//        if (!typeSel.equals("")) {
//            List<PosDetVo> posDet = cameraMapper.posDet(Long.valueOf(posId));
//            Long camNum;
//            String type = "";
//            if (typeSel.equals("double")) {
//                type = "双舱";
//                camNum = posDet.get(0).getDoublePrenum();
//            } else if (typeSel.equals("half")) {
//                type = "半球";
//                camNum = posDet.get(0).getHalfPrenum();
//            } else {
//                type = "卡口";
//                camNum = posDet.get(0).getChkpointPrenum();
//            }
//            String posIds = posId + ',';
//            typeSeled = cameraMapper.typeSeled(posIds, type);
//            if (typeSeled.size() == 0) {
//                TypeListVo typeList=new TypeListVo();
//                typeSeled.add(typeList);
//            }else{
//                Long camTotal = typeSeled.get(0).getCamPrice().longValue() * camNum;
//                typeSeled.get(0).setCamTotal(camTotal);
//            }
//            typeSeled.get(0).setCamNum(camNum);
//        }
//        return typeSeled;
//    }

//    @Override
//    public void typeSel(String params) {
//        String posIds = params.substring(1, params.indexOf(",") + 1);
//        Long camId = Long.valueOf(params.substring(params.indexOf(",") + 1, params.length() - 1));
//        System.out.println("posIds="+posIds+";camId="+camId);
//        List<TypeListVo> typeChksel = cameraMapper.typeChksel(posIds, camId);
//        if (typeChksel.size() == 0) {
//            cameraMapper.typeSel(posIds, camId);
//        }
//    }

    public static String method(String str) {
        String pos = "";
        if (str != null && str != "") {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i); //把字符串转为字符
                if (c >= 'A' && c <= 'Z') {
                    pos = pos + '_' + (char) (c + 32);
                } else {
                    pos = pos + c;
                }
            }
        } else {
            pos = "";
        }
        return pos;
    }
}
