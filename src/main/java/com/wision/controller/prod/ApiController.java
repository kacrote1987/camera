package com.wision.controller.prod.api;

import com.github.pagehelper.PageInfo;
import com.wision.entity.ApiDet;
import com.wision.entity.ApiList;
import com.wision.entity.InsureForm;
import com.wision.service.ApiService;
import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "外部接口管理")
@RestController
@RequestMapping("/api")
public class ApiController {
    @Resource
    ApiService apiService;

    @ApiOperation("接口列表")
    @PostMapping("/apilist")
    public Result apiList(ApiList params){
        PageInfo<ApiList> apiList= apiService.apiList(params);
        return Result.success(apiList);
    }

    @ApiOperation("接口详细")
    @PostMapping("/apidet")
    public Result apiDet(@RequestBody String apiId){
        List<ApiDet> apiDet= apiService.apiDet(apiId);
        return Result.success(apiDet);
    }

    @ApiOperation("接口保存")
    @PostMapping("/apisave")
    public Result apiSave(@RequestBody ApiDet params){
        apiService.apiSave(params);
        return Result.success();
    }

    @ApiOperation("导入Excel")
    @PostMapping("/excelimport")
    public Result excelImport(@RequestParam MultipartFile file, @RequestParam String table) throws Exception {
        apiService.excelImport(file,table);
        return Result.success();
    }

    @ApiOperation("获取时间戳")
    @PostMapping("/getrequesttime")
    public Result getRequestTime(@RequestBody Long apiId){
        apiService.getRequestTime(apiId);
        return Result.success();
    }

//    @ApiOperation("校验网络")
//    @PostMapping("/netcheck")
//    public Result netCheck(){
//        apiService.netCheck();
//        return Result.success();
//    }

    @ApiOperation("获取请求密钥")
    @PostMapping("/getappkey")
    public Result getSign2(@RequestBody ApiDet params){
        apiService.getSign2(params);
        return Result.success();
    }

    @ApiOperation("社保接口请求数据")
    @PostMapping("/insurerequest")
    public Result insureRequest(){
        apiService.insureRequest();
        return Result.success();
    }

    @ApiOperation("社保接口列表")
    @PostMapping("/insurelist")
    public Result insureList(InsureForm params){
        List<InsureForm> insureList= apiService.insureList(params);
        return Result.success(insureList);
    }
}
