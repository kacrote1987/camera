package com.wision.controller.supp.oa;

import com.github.pagehelper.PageInfo;
import com.wision.entity.DocListForm;
import com.wision.entity.DocDetVo;
import com.wision.entity.DocListVo;
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
@RequestMapping("/flow")
public class FlowController {
    @Resource
    DocService docService;

    @ApiOperation("流程信息列表")
    @PostMapping("/flowlist")
    public Result flowList(DocListForm params){
        PageInfo<DocListVo> docList= docService.docList(params);
        return Result.success(docList);
    }

    @ApiOperation("流程信息详细")
    @PostMapping("/flowdet")
    public Result flowDet(DocListForm params){
        List<DocDetVo> docDet=docService.docDet(params);
        return Result.success(docDet);
    }
}
