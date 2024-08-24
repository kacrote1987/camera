package com.wision.mapper;

import com.wision.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjMapper {
    List<ProjListForm> selProjList(String projStepcode, @Param("params") ProjListForm params);
    List<ProjDetForm> selProjDet(String projId);
    boolean insertProj(@Param("params") ProjDetForm params);
    boolean deleteProj(Long projId);
    boolean updateProj(@Param("params") ProjDetForm params);
    boolean projStep(Long projId,Integer stepVal);
    boolean updateProjunit(Long projId,String type,Long unitId);
    List<ConseqList> conseqList(String projId);
    List<ConseqDet> selConseqDet(Long conseqId);
    boolean insertConseq(@Param("params") ConseqDet params);
    boolean deleteConseq(Long conseqId);
    boolean updateConseqState(Long conseqId);
    boolean updateConseq(@Param("params") ConseqDet params);
    String getAssTbl(Long projId);
    List<AssProj> assProj(Long projId);
    List<ProjCostForm> projCost(Long projId);
    List<MeetListForm> meetList(@Param("params") MeetListForm params);
    List<GanttDetForm> selGanttDet(Long projId);
    boolean insertGantt(Long projId);
    boolean deleteGantt(Long ganttId);
    boolean updateGantt(Long ganttId,String field,String value);
    List<GanttDispForm> selGanttDisp(Long projId);
}
