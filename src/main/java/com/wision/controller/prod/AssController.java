package com.wision.controller.prod.ass;

import com.github.pagehelper.PageInfo;
import com.wision.entity.AssDet;
import com.wision.entity.AssList;
import com.wision.service.AssService;
import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "资产管理")
@RestController
@RequestMapping("/ass")
public class AssController {
    @Resource
    AssService assService;

    @ApiOperation("资产列表")
    @PostMapping("/asslist")
    public Result assList(AssList params){
        PageInfo<AssList> assList= assService.assList(params);
        return Result.success(assList);
    }

    @ApiOperation("资产详细")
    @PostMapping("/assdet")
    public Result assDet(@RequestBody String assId){
        List<AssDet> assDet=assService.assDet(assId);
        return Result.success(assDet);
    }

    @ApiOperation("资产保存")
    @PostMapping("/asssave")
    public Result assSave(@RequestBody AssDet params){
        assService.assSave(params);
        return Result.success();
    }

    @ApiOperation("资产类别")
    @PostMapping("/asstype")
    public Result assType(@RequestBody String type){
        List<AssList> assType=assService.assType(type);
        return Result.success(assType);
    }

    @ApiOperation("资产导入")
    @PostMapping("/assimp")
    public Result assImp(@RequestParam MultipartFile file) throws Exception {
        assService.assImp(file);
        return Result.success();
    }
}
