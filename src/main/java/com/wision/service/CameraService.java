package com.wision.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.wision.entity.*;

import java.util.ArrayList;
import java.util.List;

public interface CameraService {
    /**
     * 申请记录
     * @return
     */
    PageInfo<ApplyList> applyList(ApplyList params);
    /**
     * 申请记录详细
     * @return
     */
    List<ApplyDet> applyDet(ApplyDet params);
    /**
     * 点位列表
     * @return
     */
    PageInfo<CameraList> cameraList(CameraList params);
    /**
     * 监控详细
     * @return
     */
    List<CameraDet> cameraDet(String cameraId);
    /**
     * 点位保存
     * @return
     */
    void cameraSave(CameraDet params);
    /**
     * 经纬度展示
     * @return
     */
    ArrayList<JSONObject> lngLat();
    /**
     * 根据经纬度查点位详细
     * @return
     */
    List<CameraDet> lnglatDet(String lngLat);
    /**
     * 可视域展示
     * @return
     */
    List<LnglatDetVo> lnglatDraw();
    /**
     * 可视域展示
     * @return
     */
    List<JSONArray> areaDraw();
    /**
     * 需求区域保存
     * @return
     */
    void areaSave(String params);
    /**
     * 需求区域删除
     * @return
     */
    void areaDel(String params);
    /**
     * 标签列表
     * @return
     */
    PageInfo<TagListVo> tagList(TagListForm params);
    /**
     * 标签详细
     * @return
     */
    List<TagDetVo> tagDet(Long tagId);
    /**
     * 标签保存
     * @return
     */
    void tagSave(TagDetForm params);
    /**
     * 标签集合
     * @return
     */
    String tagGather();
    /**
     * 待建数量
     * @return
     */
    void preSave(CameraList params);
    /**
     * 参数优先级
     * @return
     */
    List<TagDetVo> reqOrder();
    /**
     * 优先级保存
     * @return
     */
    void orderSave(GanttDetForm params);
    /**
     * 参数要求
     * @return
     */
    List<TagDetVo> reqList(Long posId);
    /**
     * 设备选型库列表
     * @return
     */
    PageInfo<ParamListForm> paramList(ParamListForm params);
    /**
     * 设备选型详细
     * @return
     */
    List<ParamListForm> paramDet(Long paramId);
//    /**
//     * 已选型号
//     * @return
//     */
//    List<TypeListVo> typeSelected(String params);
    /**
     * 型号选择
     * @return
     */
    void typeSel(String params);
    /**
     * 型号选择
     * @return
     */
    PageInfo<RuleListForm> ruleList(RuleListForm params);
}
