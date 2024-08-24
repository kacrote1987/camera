package com.wision.mapper;

import com.wision.entity.StatsListForm;
import com.wision.entity.ScoreDetVo;
import com.wision.entity.StatsDetVo;
import com.wision.entity.StatsListVo;
import com.wision.entity.StatsListVos;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface StatsMapper {
    List<StatsListVos> statsTotal(String statsType,@Param("params") StatsListForm params);
    List<StatsListVo> statsList(Long page,String statsType,@Param("params") StatsListForm params);
    List<StatsDetVo> selDet(Long statsId);
    boolean insertStats(String statsType,String statsName,String statsYear,String statsMonth);
    boolean updateStats(Long statsId,String statsType,String statsName,String statsYear,String statsMonth);
    boolean deleteScore(Long statsId);
    boolean deleteStats(Long statsId);
    boolean insertScore(Long statsId,String dept,String name,String score,String dwsl,String bgsh,String jsl,String hgl);
    boolean initScore(Long statsId);
    boolean updateScore(Long scoreId,String field,String value);
    List<StatsDetVo> getYM(Long statsId);
    boolean runStep1(Long statsId);
    boolean runStep2(Long statsId);
    boolean runStep3a(Long statsId,Long workdayYear,Long workdayMonth);
    boolean runStep3b(Long statsId,Long workdayYear,Long workdayMonth);
    boolean runStep4(Long statsId);
    boolean runStep5(Long statsId);
    boolean runStep6a(Long statsId);
    boolean runStep6b(Long statsId);
    boolean runStep6c(Long statsId);
    boolean runStep6d(Long statsId);
    boolean runStep6e(Long statsId);
    boolean runStep7(Long statsId);
    boolean runStep8(Long statsId);
    List<ScoreDetVo> selScoreDet(Long statsId);
}
