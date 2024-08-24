package com.wision.controller.prod.ass;

import com.github.pagehelper.PageInfo;
import com.wision.entity.NetListForm;
import com.wision.service.NetService;
import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Api(description = "网络管理")
@RestController
@RequestMapping("/net")
public class NetController {
    @Resource
    NetService netService;

    @ApiOperation("网络列表")
    @PostMapping("/netlist")
    public Result netList(NetListForm params){
        PageInfo<NetListForm> netList= netService.netList(params);
        return Result.success(netList);
    }

//    @ApiOperation("网络详细")
//    @PostMapping("/netdet")
//    public Result netDet(@RequestBody String posId){
//        List<PosDetVo> netDet= netService.netDet(posId);
//        return Result.success(netDet);
//    }

//    @ApiOperation("网络保存")
//    @PostMapping("/netsave")
//    public Result netSave(@RequestBody PosListForm params){
//        netService.netSave(params);
//        return Result.success();
//    }

    @ApiOperation("网络导入")
    @PostMapping("/netimp")
    public Result netImp(@RequestParam MultipartFile file) throws Exception {
        netService.netImp(file);
        return Result.success();
    }
}
