package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.entity.DocListForm;
import com.project.entity.*;

import java.util.List;

public interface DocService {
    /**
     * 文件信息列表
     * @return
     */
    PageInfo<DocListVo> docList(DocListForm params);
    /**
     * 文件信息详细
     * @return
     */
    List<DocDetVo> docDet(DocListForm params);
    /**
     * 主页文件信息
     * @return
     */
    List<DocListVo> docListHome(DocListForm params);
}
