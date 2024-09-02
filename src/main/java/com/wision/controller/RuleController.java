package com.wision.controller;

import com.github.pagehelper.PageInfo;
import com.wision.config.Result;
import com.wision.entity.RuleDetVo;
import com.wision.entity.RuleListForm;
import com.wision.entity.RuleListVo;
import com.wision.service.RuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(description = "规则管理")
@RestController
@RequestMapping("/rule")
public class RuleController {
    @Resource
    RuleService ruleService;

    @ApiOperation("规则列表")
    @PostMapping("/ruleList")
    public Result ruleList(RuleListForm params){
        PageInfo<RuleListVo> ruleList= ruleService.ruleList(params);
        return Result.success(ruleList);
    }

    @ApiOperation("规则详细")
    @PostMapping("/ruleDet")
    public Result ruleDet(@RequestBody Long ruleId){
        RuleDetVo ruleDet= ruleService.ruleDet(ruleId);
        return Result.success(ruleDet);
    }
}
