package com.wision.service;

import com.wision.entity.ScoreForm;
import com.wision.entity.StatsDetForm;
import com.wision.entity.StatsListForm;
import com.wision.entity.ScoreDetVo;
import com.wision.entity.StatsDetVo;
import com.wision.entity.StatsListVos;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StatsService {
    /**
     * 考核统计列表
     * @return
     */
    List<StatsListVos> statsList(StatsListForm params);
    /**
     * 考核统计详细
     * @return
     */
    List<StatsDetVo> statsDet(String statsId);
    /**
     * 考核统计增改
     * @return
     */
    void statsSave(StatsDetForm params);
    /**
     * 考核统计删除
     * @return
     */
    void statsDel(String params);
    /**
     * 工时统计导入
     * @return
     */
    void scoreImp(MultipartFile file,Long statsId) throws Exception;
    /**
     * 工时保存
     * @return
     */
    void scoreSave(ScoreForm params);
    /**
     * 考核统计运算
     * @return
     */
    void scoreRun(String params);
    /**
     * 工时统计详细
     * @return
     */
    List<ScoreDetVo> scoreDet(String params);
}
