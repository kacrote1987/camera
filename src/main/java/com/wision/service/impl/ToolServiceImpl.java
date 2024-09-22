package com.wision.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.mapper.ToolMapper;
import com.wision.service.ToolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToolServiceImpl implements ToolService {
    @Resource
    ToolMapper toolMapper;

    @Override
    public PageInfo<ToolListVo> toolList(ToolListForm params) {
        Integer page = 0;
        if(params.getPage() != null){
            page = params.getPage();
        }
        PageHelper.startPage(page, 10);
        List<ToolListVo> toolList = toolMapper.toolList(params);
        return PageInfo.of(toolList);
    }

    @Override
    public List<ToolDetVo> toolDet(String params) {
        List<ToolDetVo> toolDet = null;
        if (!params.equals("add")) {
            toolDet = toolMapper.toolDet(Long.valueOf(params));
        }
        return toolDet;
    }

    @Override
    public void toolSave(ToolDetForm params) {
        if (params.getAction().equals("add")) {
            toolMapper.insertTool(params);
        } else if (params.getAction().equals("del")) {
            toolMapper.deleteTool(params.getToolId());
        } else {
            toolMapper.updateTool(params);
        }
    }

    @Override
    public void createPage(Long relatId) {
        //1-创建文件夹（有问题）
//        String folderPath = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\resources\\static\\wision\\prods";
//        Path path = Paths.get(folderPath);
//        try {
//            Files.createDirectories(path);
//            System.out.println("文件夹创建成功");
//        } catch (IOException e) {
//            System.out.println("文件夹创建失败");
//            e.printStackTrace();
//        }
        //2-获取文件(包含页面、java类文件、mapper文件)
        List<String> sourceFilePath = new ArrayList<>();
        List<String> destinationFilePath = new ArrayList<>();
        //2.1-获取页面文件路径
        String prodNikName=toolMapper.getProdNikName(relatId);
        String toolPage=toolMapper.getToolPage(relatId);
        String realPage=toolMapper.getRealPage(relatId);
        String sourceFilePath1 = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\resources\\static\\wision\\tools\\" + toolPage;
        String destinationFilePath1 = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\resources\\static\\wision\\prods\\" + prodNikName + "\\" + realPage;
        sourceFilePath.add(sourceFilePath1);
        destinationFilePath.add(destinationFilePath1);
        //2.2-获取controller文件路径
        String sourceFilePath2 = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\java\\com\\wision\\controller\\ChildController.java";
        String destinationFilePath2 = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\java\\com\\wision\\controller\\prods\\xmgl\\ChildController.java";
        sourceFilePath.add(sourceFilePath2);
        destinationFilePath.add(destinationFilePath2);
        //2.3-获取service文件路径
        String sourceFilePath3 = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\java\\com\\wision\\service\\ChildService.java";
        String destinationFilePath3 = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\java\\com\\wision\\controller\\prods\\xmgl\\ChildService.java";
        sourceFilePath.add(sourceFilePath3);
        destinationFilePath.add(destinationFilePath3);
        //2.4-获取impl文件路径
        String sourceFilePath4 = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\java\\com\\wision\\service\\impl\\ChildServiceImpl.java";
        String destinationFilePath4 = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\java\\com\\wision\\controller\\prods\\xmgl\\ChildServiceImpl.java";
        sourceFilePath.add(sourceFilePath4);
        destinationFilePath.add(destinationFilePath4);
        //2.5-获取类mapper文件路径
        String sourceFilePath5 = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\java\\com\\wision\\mapper\\ChildMapper.java";
        String destinationFilePath5 = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\java\\com\\wision\\controller\\prods\\xmgl\\ChildMapper.java";
        sourceFilePath.add(sourceFilePath5);
        destinationFilePath.add(destinationFilePath5);
        //2.6-获取xml文件路径
        String sourceFilePath6 = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\resources\\mapper\\ChildMapper.xml";
        String destinationFilePath6 = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\java\\com\\wision\\controller\\prods\\xmgl\\ChildMapper.xml";
        sourceFilePath.add(sourceFilePath6);
        destinationFilePath.add(destinationFilePath6);
        //3-循环复制
        for(int i=0;i<sourceFilePath.size();i++){
            try (FileInputStream fis = new FileInputStream(sourceFilePath.get(i));
                 FileOutputStream fos = new FileOutputStream(destinationFilePath.get(i))) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("文件复制成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public BasicSourVo basicSour(Long relatId) {
        BasicSourVo basicSour = new BasicSourVo();
        basicSour.setRelatName(toolMapper.getRelatName(relatId));
        basicSour.setLayoutType(toolMapper.getLayoutType(relatId));
        basicSour.setBasicSourTblVo(toolMapper.basicSourTbl(relatId));
        return basicSour;
    }

    @Override
    public List<BasicCondVo> basicCond(Long relatId) {
        List<BasicCondVo> basicCond=toolMapper.basicCond(relatId);
        return basicCond;
    }

    @Override
    public void basicCondEdit(BasicCondForm1 params) {
        toolMapper.updateBasicCond(params);
    }

    @Override
    public void basicCondAdd(BasicCondForm2 params) {
        String toolCode = toolMapper.getBasicCodeByName(params.getRelatId(),params.getKeyName());
        toolMapper.insertBasicCond(params,toolCode);
    }

    @Override
    public List<BasicCol> basicView(Long relatId) {
        List<BasicCol> basicView = toolMapper.getBasicCol(relatId);
        return basicView;
    }

    @Override
    public void basicCondDel(Long ruleId) {
        toolMapper.deleteBasicCond(ruleId);
    }

    @Override
    public FlowCondVo flowCond(Long relatId) {
        FlowCondVo flowCond = toolMapper.flowCond(relatId);
        return flowCond;
    }

    @Override
    public void flowCondEdit(FlowCondForm params) {
        toolMapper.updateFlowCond(params);
    }

    @Override
    public List<FlowViewVo> flowView(Long relatId) {
        List<FlowViewVo> flowView=toolMapper.flowView(relatId);
        return flowView;
    }

    @Override
    public void flowAdd(Long relatId) {
        toolMapper.insertFlow(relatId);
    }

    @Override
    public void flowDel(Long extId) {
        toolMapper.deleteFlow(extId);
    }

    @Override
    public void flowEdit(FlowListForm params) {
        toolMapper.updateFlow(params.getExtId(),method(params.getField()),params.getValue());
    }

//    @Override
//    public RuleDictVo ruleDict(Long relatId) {
//        RuleDictVo ruleDict = new RuleDictVo();
//        List<RuleDictExtVo> mainCode = toolMapper.getMainCode(relatId);
////        List<RuleDictExtVo> selfCode = toolMapper.getSelfCode(relatId);
////        List<RuleDictExtVo> selfName = toolMapper.getSelfName(relatId);
//        ruleDict.setMainCode(mainCode);
////        ruleDict.get(0).setSelfCode(selfCode);
////        ruleDict.get(0).setSelfName(selfName);
//        return ruleDict;
//    }
//
//    @Override
//    public void ruleAdd(RuleListForm params) {
//        toolMapper.insertRule(params);
//    }
//
//    @Override
//    public SourDetVo sourDet(Long relatId) {
//        SourDetVo sourDet=toolMapper.sourDet(relatId);
//        return sourDet;
//    }
//
//    @Override
//    public void layoutEdit(RelatForm params) {
//        toolMapper.layoutEdit(params);
//    }
//
//    @Override
//    public void sourEdit(RelatForm params) {
//        toolMapper.sourEdit(params);
//    }

    public static String method (String str){
        String pos="";
        if(str!=null && str!=""){
            for (int i = 0; i < str.length(); i++) {
                char c=str.charAt(i); //把字符串转为字符
                if(c >= 'A' && c <= 'Z'){
                    pos=pos+'_'+(char)(c+32);
                }
                else{
                    pos=pos+c;
                }
            }
        }else{
            pos="";
        }
        return pos;
    }
}
