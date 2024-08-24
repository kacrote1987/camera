package com.wision.controller.supp.oa;

import com.github.pagehelper.PageInfo;
import com.wision.entity.DocListForm;
import com.wision.entity.*;
import com.wision.service.DocService;
import com.wision.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "文件管理")
@RestController
@RequestMapping("/doc")
public class DocController {
    @Resource
    DocService docService;

    @ApiOperation("文件信息列表")
    @PostMapping("/doclist")
    public Result docList(DocListForm params){
        PageInfo<DocListVo> docList= docService.docList(params);
        return Result.success(docList);
    }

    @ApiOperation("文件信息详细")
    @PostMapping("/docdet")
    public Result docDet(DocListForm params){
        List<DocDetVo> docDet=docService.docDet(params);
        return Result.success(docDet);
    }

    @ApiOperation("主页文件信息")
    @PostMapping("/doclisthome")
    public Result docListHome(DocListForm params){
        List<DocListVo> docListHome= docService.docListHome(params);
        return Result.success(docListHome);
    }
}
