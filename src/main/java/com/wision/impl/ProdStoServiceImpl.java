package com.wision.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.mapper.ProdStoMapper;
import com.wision.service.ProdStoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdStoServiceImpl implements ProdStoService {
    @Resource
    ProdStoMapper prodStoMapper;

    @Override
    public PageInfo<ProdListVo> prodList(ProdListForm params) {
        Integer page = 0;
        if(params.getPage() != null){
            page = params.getPage();
        }
        PageHelper.startPage(page, 10);
        List<ProdListVo> prodList = prodStoMapper.prodList(params);
        return PageInfo.of(prodList);
    }

    @Override
    public List<ProdDetVo> prodDet(Long prodId) {
        List<ProdDetVo> prodDet=prodStoMapper.prodDet(prodId);
        return prodDet;
    }

    @Override
    public void offLine(Long prodId) {
        prodStoMapper.offLine(prodId);
    }

    @Override
    public String getChildName(Long prodId) {
        String childName = prodStoMapper.getChildName(prodId);
        return childName;
    }

    @Override
    public ChildMainVo getChildMain(Long prodId) {
        ChildMainVo childMain = new ChildMainVo();
        childMain.setProdName(prodStoMapper.getChildName(prodId));
        List<ChildMenuVo> childMenuVo = prodStoMapper.getChildMenu(prodId);
        childMain.setChildMenuVo(childMenuVo);
        return childMain;
    }

    @Override
    public List<MainSelVo> mainSel(Long menuId) {
        List<ChildTblCol> childTblCol=new ArrayList<>();
        //增加选择框
        ChildTblCol childTblMenu1=new ChildTblCol();
        childTblMenu1.setType("checkbox");
        childTblCol.add(childTblMenu1);
        //获取查询结果列名
        List<ChildTblCol> childTblCol1=prodStoMapper.getTblSel(menuId,"1",null);
        for(int i=0;i<childTblCol1.size();i++){
            childTblCol.add(childTblCol1.get(i));
        }
        //增加操作菜单
        ChildTblCol childTblMenu2=new ChildTblCol();
        childTblMenu2.setTitle("操作");
        childTblMenu2.setToolbar("#test-table-toolbar-barDemo");
        childTblCol.add(childTblMenu2);
        //设置平均列间距
//        String width=String.valueOf(100/childTblCol.size())+'%';
        String width="8%";
        for(int i=0;i<childTblCol.size();i++){
            childTblCol.get(i).setWidth(width);
        }
        //获取查询条件
        List<ChildTblCol> basicSel=prodStoMapper.getTblSel(menuId,null,"1");
        //将获取的列名插入ChildTblSel中
        MainSelVo mainSelVo = new MainSelVo();
        mainSelVo.setChildTblCol(childTblCol);
        mainSelVo.setChildTblSel(basicSel);
        //将获取的列名插入ChildTblSelVo中
        List<MainSelVo> mainSelList = new ArrayList<>();
        mainSelList.add(mainSelVo);
        return mainSelList;
    }

    @Override
    public PageInfo<MainContVo> mainCont(Long menuId, ChildTblForm params) {
        //获取表名
        String tblName=prodStoMapper.getTblNameByMenuId(menuId);//tblName=t_imp_40_xmzb
        //获取导入表的内容
        PageHelper.startPage(params.getPage(), 10);
//        String search=params.getSearch()+",";
//        String val=params.getVal();
//        ChildTblCont params1 = new ChildTblCont();
//        params1.setTblName(tblName);
//        if(val!=null){
//            while (search.indexOf(",")>0){
//                String key=search.substring(0,search.indexOf(","));
//                String value=val.substring(0,val.indexOf(","));
//                if(key.equals("col1")){
//                    params1.setCol1(value);
//                }else if(key.equals("col2")){
//                    params1.setCol2(value);
//                }else if(key.equals("col3")){
//                    params1.setCol3(value);
//                }else if(key.equals("col4")){
//                    params1.setCol4(value);
//                }else if(key.equals("col5")){
//                    params1.setCol5(value);
//                }else if(key.equals("col6")){
//                    params1.setCol6(value);
//                }else if(key.equals("col7")){
//                    params1.setCol7(value);
//                }else if(key.equals("col8")){
//                    params1.setCol8(value);
//                }else if(key.equals("col9")){
//                    params1.setCol9(value);
//                }else if(key.equals("col10")){
//                    params1.setCol10(value);
//                }else if(key.equals("col11")){
//                    params1.setCol11(value);
//                }else if(key.equals("col12")){
//                    params1.setCol12(value);
//                }else if(key.equals("col13")){
//                    params1.setCol13(value);
//                }else if(key.equals("col14")){
//                    params1.setCol14(value);
//                }else if(key.equals("col15")){
//                    params1.setCol15(value);
//                }else if(key.equals("col16")){
//                    params1.setCol16(value);
//                }else if(key.equals("col17")){
//                    params1.setCol17(value);
//                }else if(key.equals("col18")){
//                    params1.setCol18(value);
//                }else if(key.equals("col19")){
//                    params1.setCol19(value);
//                }else if(key.equals("col20")){
//                    params1.setCol20(value);
//                }else{
//                    params1.setStep(value);
////                    if(projStepcode==null){
////                        projStepcode="step0"; }
////                    projStepcode=projStepcode.substring(4,projStepcode.length());
//                }
//                search=search.substring(search.indexOf(",")+1,search.length());
//                val=val.substring(val.indexOf(",")+1,val.length());
//            }
////            String jsonString = JSONObject.toJSONString(params1);
////            System.out.println("jsonString = " + jsonString);
//        }
        String realPage = prodStoMapper.getRealPageByMenu(menuId);
        tblName = "t_ext_" + realPage.replace("list.html","");
        List<MainContVo> mainCont=prodStoMapper.getMainCont(tblName);
        return PageInfo.of(mainCont);
    }

    @Override
    public void generate(Long prodId) {
//        1、创建代码目录  createDir;
//        2、配置文件备份  copyConf;
//        3、控制类代码生成  contr;
//        4、接口类代码生成  service;
//        5、实现类代码生成  impl;
//        6、映射类代码生成  mapper;
//        7、数据库脚本生成  dataMapper;
//        8、授权信息设置  authorize;
//        9、打包生成jar文件  package;
//        10、执行文件脚本生成  run;
//        11、数据库备份  dataBaseBak;
//        12、说明文档生成  readMe;
//        13、打包成压缩包（返回下载路径） compress;

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
        String prodNikName=prodStoMapper.getProdNikName(prodId);
        String toolPage=prodStoMapper.getToolPage(prodId);  //??
        String realPage=prodStoMapper.getRealPage(prodId);  //??
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
