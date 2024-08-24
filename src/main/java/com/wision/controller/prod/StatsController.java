package com.wision.controller.prod.map;

import com.wision.entity.ScoreForm;
import com.wision.entity.StatsDetForm;
import com.wision.entity.StatsListForm;
import com.wision.entity.*;
import com.wision.service.StatsService;
import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "统计报表")
@RestController
@RequestMapping("/stats")
public class StatsController {
    @Resource
    StatsService statsService;

    @ApiOperation("统计报表列表")
    @PostMapping("/statslist")
    public Result statsList(StatsListForm params){
        List<StatsListVos> statsList= statsService.statsList(params);
        return Result.suctotal(statsList.get(0).getStatsTotal(),statsList.get(0).getStatsListVo());
    }

    @ApiOperation("统计报表详细")
    @PostMapping("/statsdet")
    public Result statsDet(@RequestBody String statsId){
        List<StatsDetVo> statsDet= statsService.statsDet(statsId);
        return Result.success(statsDet);
    }

    @ApiOperation("统计报表增改")
    @PostMapping("/statssave")
    public Result statsSave(@RequestBody StatsDetForm params){
        statsService.statsSave(params);
        return Result.success();
    }

    @ApiOperation("统计报表删除")
    @PostMapping("/statsdel")
    public Result statsDel(@RequestBody String params){
        statsService.statsDel(params);
        return Result.success();
    }

    @ApiOperation("工时统计导入")
    @PostMapping("/scoreimp")
    public Result scoreImp(@RequestParam MultipartFile file,@RequestParam Long statsId) throws Exception {
        statsService.scoreImp(file,statsId);
        return Result.success();
    }

    @ApiOperation("工时增删改")
    @PostMapping("/scoresave")
    public Result scoreSave(@RequestBody ScoreForm params){
        statsService.scoreSave(params);
        return Result.success();
    }

    @ApiOperation("工时统计运算")
    @PostMapping("/scorerun")
    public Result scoreRun(@RequestBody String params){
        statsService.scoreRun(params);
        return Result.success();
    }

    @ApiOperation("工时统计详细")
    @PostMapping("/scoredet")
    public Result scoreDet(@RequestBody String params){
        List<ScoreDetVo> scoreDet= statsService.scoreDet(params);
        return Result.success(scoreDet);
    }
}
