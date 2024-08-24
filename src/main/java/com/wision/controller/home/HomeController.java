package com.wision.controller.home;

import com.github.pagehelper.PageInfo;
import com.wision.entity.DiaryForm;
import com.wision.entity.MenuListForm;
import com.wision.entity.*;
import com.wision.service.HomeService;
import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "主页管理")
@RestController
@RequestMapping("/home")
public class HomeController {
    @Resource
    HomeService homeService;

    @ApiOperation("主页展示")
    @PostMapping("/homedisply")
    public Result homeDisplay(@RequestBody String params){
        List<DocListVo> homeDisplay= homeService.homeDisplay(params);
        return Result.success(homeDisplay);
    }

    @ApiOperation("考核统计展示")
    @PostMapping("/statsdisply")
    public Result statsDisply(){
        List<StatsListVo> statsDisply= homeService.statsDisply();
        return Result.success(statsDisply);
    }

    @ApiOperation("个人日志详细")
    @PostMapping("/logdet")
    public Result logDet(@RequestBody String params){
        List<LogVo> logDet= homeService.logDet(params);
        return Result.suclayer(logDet);
    }

    @ApiOperation("个人日志保存")
    @PostMapping("/logsave")
    public Result logSave(@RequestBody DiaryForm params){
        homeService.logSave(params);
        return Result.success();
    }

    @ApiOperation("个人日志导出")
    @PostMapping("/logexport")
    public Result logExport(){
        List<LogVo> logExport= homeService.logExport();
        return Result.suclayer(logExport);
    }
}
