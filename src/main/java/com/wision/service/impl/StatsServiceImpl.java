package com.wision.service.impl;

import com.wision.entity.ScoreForm;
import com.wision.entity.StatsDetForm;
import com.wision.entity.StatsListForm;
import com.wision.entity.ScoreDetVo;
import com.wision.entity.StatsDetVo;
import com.wision.entity.StatsListVos;
import com.wision.mapper.StatsMapper;
import com.wision.service.StatsService;
import com.wision.util.ExcelUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class StatsServiceImpl implements StatsService {
    @Resource
    StatsMapper statsMapper;

    @Override
    public List<StatsListVos> statsList(StatsListForm params) {
        Long page=(Long.valueOf(params.getPage())-1)*10;
        String statsType;
        if(params.getStatsType()==null || params.getStatsType()==""){
            statsType="统计类别";
        }else {
            statsType=params.getStatsType();
        }
        List<StatsListVos> statsList=statsMapper.statsTotal(statsType,params);
        statsList.get(0).setStatsListVo(statsMapper.statsList(page,statsType,params));
        return statsList;
    }

    @Override
    public List<StatsDetVo> statsDet(String statsId) {
        List<StatsDetVo> statsDet=null;
        if(!statsId.equals("add")){
            statsDet=statsMapper.selDet(Long.valueOf(statsId));
        }
        return statsDet;
    }

    @Override
    public void statsSave(StatsDetForm params) {
        if(params.getStatsId()==null){
            statsMapper.insertStats(params.getStatsType(),params.getStatsName(),params.getStatsYear(),params.getStatsMonth());
        }else{
            statsMapper.updateStats(params.getStatsId(),params.getStatsType(),params.getStatsName(),params.getStatsYear(),params.getStatsMonth());
        }
    }

    @Override
    public void statsDel(String params) {
        statsMapper.deleteScore(Long.valueOf(params));
        statsMapper.deleteStats(Long.valueOf(params));
    }

    @Override
    public void scoreImp(MultipartFile file,Long statsId) throws Exception {
        statsMapper.deleteScore(statsId);
        String[] keys = {"dept", "name","score","dwsl","bgsh","jsl","hgl"};
        List<Map<String, Object>> list= ExcelUtils.importExcel(file,keys);
        for(Map<String,Object> map:list){
            statsMapper.insertScore(statsId,map.get("dept").toString(),map.get("name").toString(),map.get("score").toString()
            ,map.get("dwsl").toString(),map.get("bgsh").toString(),map.get("jsl").toString(),map.get("hgl").toString());
        }
        statsMapper.initScore(statsId);
//        以下为上传文件代码，导入Excel时不需要此步。
//        String fileName = file.getOriginalFilename();
//        String filePath = "D:/upload/";
//        File dest = new File(filePath + fileName);
//        try {
//            file.transferTo(dest);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void scoreSave(ScoreForm params) {
        statsMapper.updateScore(params.getScoreId(),method(params.getField()),params.getValue());
    }

    @Override
    public void scoreRun(String params) {
        Long statsId=Long.valueOf(params);
//        获取年月
        List<StatsDetVo> workdayYM=statsMapper.getYM(statsId);
//        算①：scoreS3规则：当scoreS2<=40时，scoreS3=scoreS2；当scoreS2>40时，scoreS3=scoreS2+每多1个单位+0.5分。
        statsMapper.runStep1(statsId);
//        算②：scoreS14=scoreS1+scoreS3+scoreS4+scoreS5+scoreS6+scoreS7+scoreS12+scoreS13
        statsMapper.runStep2(statsId);
//        算③：scoreS9=scoreS14的部门求和/部门人数/工作日*scoreS8*系数1；
        statsMapper.runStep3a(statsId,Long.valueOf(workdayYM.get(0).getStatsYear()),Long.valueOf(workdayYM.get(0).getStatsMonth()));
////           scoreS11=scoreS15的部门求和/部门人数/工作日*scoreS10*系数0.7
        statsMapper.runStep3b(statsId,Long.valueOf(workdayYM.get(0).getStatsYear()),Long.valueOf(workdayYM.get(0).getStatsMonth()));
//        算④：scoreS15=scoreS14+scoreS9+scoreS11
        statsMapper.runStep4(statsId);
//        算⑤：scoreS16=scoreS15/(scoreS15的部门求和/部门人数)*70
        statsMapper.runStep5(statsId);
//        算⑥：分别计算scoreS18、scoreS20、scoreS22、scoreS24、scoreS25的结果
        statsMapper.runStep6a(statsId);
        statsMapper.runStep6b(statsId);
        statsMapper.runStep6c(statsId);
        statsMapper.runStep6d(statsId);
        statsMapper.runStep6e(statsId);
//        算⑦：个人总计scoreTotal=scoreS16+scoreS25+scoreS26
        statsMapper.runStep7(statsId);
//        算⑧：部门总计scoreTotalDept=个人总计的部门求和
        statsMapper.runStep8(statsId);
    }

    @Override
    public List<ScoreDetVo> scoreDet(String params) {
        Long statsId=Long.valueOf(params.substring(0,params.indexOf("=")));
        List<ScoreDetVo> scoreDet=statsMapper.selScoreDet(statsId);
        return scoreDet;
    }

    public static String method (String str){
        String pos1;
        String pos2=null;
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i); //把字符串转为字符
            if(c >= 'A' && c <= 'Z'){
                pos1=str.replace(c,(char)(c+32));
                pos2=pos1.substring(0,i)+'_'+pos1.substring(i,pos1.length());
            }
        }
        return pos2;
    }
}
