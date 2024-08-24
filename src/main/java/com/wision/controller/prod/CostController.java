package com.wision.controller.prod.cost;

import com.wision.entity.*;
import com.wision.service.CostService;
import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "费用管理")
@RestController
@RequestMapping("/cost")
public class CostController {
    @Resource
    CostService costService;

    @ApiOperation("发票列表")
    @PostMapping("/involist")
    public Result invoList(InvoForm params){
        List<InvoVos> invoList= costService.invoList(params);
        return Result.suctotal(invoList.get(0).getInvoTotal(),invoList.get(0).getInvoVo());
    }

    @ApiOperation("发票详细")
    @PostMapping("/invodet")
    public Result invoDet(@RequestBody String invoId){
        List<InvoDetVo> invoDet= costService.invoDet(invoId);
        return Result.success(invoDet);
    }

    @ApiOperation("发票操作")
    @PostMapping("/invodo")
    public Result invoDo(@RequestBody InvoForm params){
        costService.invoDo(params);
        return Result.success();
    }

    @ApiOperation("发票项目明细")
    @PostMapping("/invomemb")
    public Result invoMemb(@RequestBody String params){
        List<InvoMembVo> invoMemb=costService.invoMemb(params);
        return Result.suclayer(invoMemb);
    }

    @ApiOperation("发票项目操作")
    @PostMapping("/invomembdo")
    public Result invoMembdo(@RequestBody InvoMembForm params){
        costService.invoMembdo(params);
        return Result.success();
    }
}
