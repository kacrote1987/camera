package com.wision.controller.prods.xmgl;

import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "项目管理")
@RestController
@RequestMapping("/xmgl")
public class XmglController {
    @Resource
    XmglService xmglService;

    @ApiOperation("项目列表")
    @PostMapping("/xmglList")
    public Result xmglList(){
        List<XmglListVo> xmglList= xmglService.xmglList();
        return Result.success(xmglList);
    }
}
