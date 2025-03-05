package com.wision.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.mapper.CompoMapper;
import com.wision.service.CompoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompoServiceImpl implements CompoService {
    @Resource
    CompoMapper compoMapper;

    @Override
    public PageInfo<CompoListVo> compoList(CompoListForm params) {
        Integer page = 0;
        if(params.getPage() != null){
            page = params.getPage();
        }
        PageHelper.startPage(page, 10);
        List<CompoListVo> compoList = compoMapper.compoList(params);
        return PageInfo.of(compoList);
    }
//
//    @Override
//    public List<UnitDetVo> toolDet(String params) {
//        List<UnitDetVo> toolDet = null;
//        if (!params.equals("add")) {
//            toolDet = toolStoMapper.toolDet(Long.valueOf(params));
//        }
//        return toolDet;
//    }
//
//    @Override
//    public void toolSave(UnitDetForm params) {
//        if (params.getAction().equals("add")) {
//            toolStoMapper.insertTool(params);
//        } else if (params.getAction().equals("del")) {
//            toolStoMapper.deleteTool(params.getToolId());
//        } else {
//            toolStoMapper.updateTool(params);
//        }
//    }
//
//    @Override
//    public BasicSourVo basicSour(Long relatId) {
//        BasicSourVo basicSour = new BasicSourVo();
//        basicSour.setRelatName(toolStoMapper.getRelatName(relatId));
//        basicSour.setLayoutType(toolStoMapper.getLayoutType(relatId));
//        basicSour.setBasicSourTblVo(toolStoMapper.basicSourTbl(relatId));
//        return basicSour;
//    }
//
//    @Override
//    public List<BasicCondVo> basicCond(Long relatId) {
//        List<BasicCondVo> basicCond=toolStoMapper.basicCond(relatId);
//        return basicCond;
//    }
//
//    @Override
//    public void basicCondEdit(BasicCondForm1 params) {
//        toolStoMapper.updateBasicCond(params);
//    }
//
//    @Override
//    public void basicCondAdd(BasicCondForm2 params) {
//        String toolCode = toolStoMapper.getBasicCodeByName(params.getRelatId(),params.getKeyName());
//        toolStoMapper.insertBasicCond(params,toolCode);
//    }
//
//    @Override
//    public List<BasicCol> basicView(Long relatId) {
//        List<BasicCol> basicView = toolStoMapper.getBasicCol(relatId);
//        return basicView;
//    }
//
//    @Override
//    public void basicCondDel(Long extId) {
//        toolStoMapper.deleteBasicCond(extId);
//    }
//
//    @Override
//    public FlowCondMainVo flowCondMain(Long relatId) {
//        FlowCondMainVo flowCondMain = new FlowCondMainVo();
//        flowCondMain.setFlowCondVo(toolStoMapper.flowCond(relatId));
//        flowCondMain.setMainColVo(toolStoMapper.getMainCol(relatId));
//        flowCondMain.setRelatColVo(toolStoMapper.getRelatCol(relatId));
//        return flowCondMain;
//    }
//
//    @Override
//    public void flowCondEdit(FlowCondForm params) {
//        toolStoMapper.updateFlowCond(params);
//    }
//
//    @Override
//    public List<FlowViewVo> flowView(Long relatId) {
//        List<FlowViewVo> flowView=toolStoMapper.flowView(relatId);
//        return flowView;
//    }
//
//    @Override
//    public void flowAdd(Long relatId) {
//        toolStoMapper.insertFlow(relatId);
//    }
//
//    @Override
//    public void flowDel(Long extId) {
//        toolStoMapper.deleteFlow(extId);
//    }
//
//    @Override
//    public void flowEdit(FlowListForm params) {
//        toolStoMapper.updateFlow(params.getExtId(),method(params.getField()),params.getValue());
//    }
//
////    @Override
////    public RuleDictVo ruleDict(Long relatId) {
////        RuleDictVo ruleDict = new RuleDictVo();
////        List<RuleDictExtVo> mainCode = toolMapper.getMainCode(relatId);
//////        List<RuleDictExtVo> selfCode = toolMapper.getSelfCode(relatId);
//////        List<RuleDictExtVo> selfName = toolMapper.getSelfName(relatId);
////        ruleDict.setMainCode(mainCode);
//////        ruleDict.get(0).setSelfCode(selfCode);
//////        ruleDict.get(0).setSelfName(selfName);
////        return ruleDict;
////    }
////
////    @Override
////    public void ruleAdd(RuleListForm params) {
////        toolMapper.insertRule(params);
////    }
////
////    @Override
////    public SourDetVo sourDet(Long relatId) {
////        SourDetVo sourDet=toolMapper.sourDet(relatId);
////        return sourDet;
////    }
////
////    @Override
////    public void layoutEdit(RelatForm params) {
////        toolMapper.layoutEdit(params);
////    }
////
////    @Override
////    public void sourEdit(RelatForm params) {
////        toolMapper.sourEdit(params);
////    }
//
//
//    ////    @Resource
//////    QRCodeGenerator qrCodeGenerator;
//////    @Resource
//////    KafkaConsumer kafkaConsumer;
////    @Resource
//////    WechatPay wechatPay;
////
//////    @Override
//////    public void qrcode() {
//////        qrCodeGenerator.simple();
//////    }
////
////    @Override
//////    public void payByWx(){
//////        // 参数配置
//////        String appId = "wx8790234sau98232ehb2"; // 应用号
//////        String mchId = "1571814339"; // 商户号
//////        String privateKey = ""; // 私钥字符串，此处省略
//////        String mchSerialNo = "25FS78SGSGFGG7879SGS987GS675AT6"; // 商户证书序列号
//////        String apiV3Key = "CZBK12Y675AHIGA97987987957AD"; // V3密钥
//////        String description = "Image形象店-深圳腾大-QQ公仔"; // 商品描述
//////        String outTradeNo = "1217752501201407033233368018"; // 订单号
//////        String notifyUrl = "https://www.weixin.qq.com/wxpay/pay.php"; // 支付成功回调通知地址
//////        Amount amount; // 订单金额信息
//////        Integer total=0; // 金额，单位为分
//////
//////        // 定义请求body参数（后面要修改，其包含应用ID、商户号、订单金额等信息）
//////        String reqdata = "{"
//////                + "\"time_expire\":\"2024-11-08T10:34:56+08:00\","
//////                + "\"amount\": {"
//////                + "\"total\":" + total + ","
//////                + "\"currency\":\"CNY\""
//////                + "},"
//////                + "\"mchid\":"+ mchId +","
//////                + "\"description\":" + description + ","
//////                + "\"notify_url\":" + notifyUrl + ","
//////                + "\"out_trade_no\":" + outTradeNo + ","
//////                + "\"goods_tag\":\"WXG\","
//////                + "\"appid\":" + appId + ","
//////                + "\"attach\":\"自定义数据说明\","
//////                + "\"detail\": {"
//////                + "\"invoice_id\":\"wx123\","
//////                + "\"goods_detail\": ["
//////                + "{"
//////                + "\"goods_name\":\"iPhoneX 256G\","
//////                + "\"wechatpay_goods_id\":\"1001\","
//////                + "\"quantity\":1,"
//////                + "\"merchant_goods_id\":\"商品编码\","
//////                + "\"unit_price\":828800"
//////                + "},"
//////                + "{"
//////                + "\"goods_name\":\"iPhoneX 256G\","
//////                + "\"wechatpay_goods_id\":\"1001\","
//////                + "\"quantity\":1,"
//////                + "\"merchant_goods_id\":\"商品编码\","
//////                + "\"unit_price\":828800"
//////                + "}"
//////                + "],"
//////                + "\"cost_price\":608800"
//////                + "},"
//////                + "\"scene_info\": {"
//////                + "\"store_info\": {"
//////                + "\"address\":\"广东省深圳市南山区科技中一道10000号\","
//////                + "\"area_code\":\"440305\","
//////                + "\"name\":\"腾讯大厦分店\","
//////                + "\"id\":\"0001\""
//////                + "},"
//////                + "\"device_id\":\"013467007045764\","
//////                + "\"payer_client_ip\":\"14.23.150.211\""
//////                + "}"
//////                + "}";
//////
//////        try {
////////            wechatPay.CreateOrder(reqdata);
//////        } catch (Exception e) {
//////            throw new RuntimeException(e);
//////        }
//////    }
////
////    @Override
////    public void kafka() {
//////        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//////        Runnable consumerTask = () -> {
//////            // 此处调用Kafka消费函数
//////            KafkaConsumer.main(null);
//////        };
//////        // 每10秒执行一次
//////        scheduler.scheduleAtFixedRate(consumerTask, 0, 10, TimeUnit.SECONDS);
////    }
////
//
//
//    public static String method (String str){
//        String pos="";
//        if(str!=null && str!=""){
//            for (int i = 0; i < str.length(); i++) {
//                char c=str.charAt(i); //把字符串转为字符
//                if(c >= 'A' && c <= 'Z'){
//                    pos=pos+'_'+(char)(c+32);
//                }
//                else{
//                    pos=pos+c;
//                }
//            }
//        }else{
//            pos="";
//        }
//        return pos;
//    }
}
