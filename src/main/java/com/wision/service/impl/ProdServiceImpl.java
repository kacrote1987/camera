package com.wision.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.mapper.ProdMapper;
import com.wision.service.ProdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProdServiceImpl implements ProdService {
    @Resource
    ProdMapper prodMapper;

    @Override
    public PageInfo<ProdListVo> prodList(ProdListForm params) {
        Integer page = 0;
        if(params.getPage() != null){
            page = params.getPage();
        }
        PageHelper.startPage(page, 10);
        List<ProdListVo> prodList = prodMapper.prodList(params);
        return PageInfo.of(prodList);
    }

    @Override
    public List<ProdDetVo> prodDet(Long prodId) {
        List<ProdDetVo> prodDet=prodMapper.prodDet(prodId);
        return prodDet;
    }

    @Override
    public void changeState(ProdStateForm params) {
        prodMapper.changeState(params.getProdId(),params.getState());
    }

    @Override
    public PageInfo<ProdDesignVo> prodDesign(ProdDesignForm params) {
        Integer page = 0;
        if(params.getPage() != null){
            page = params.getPage();
        }
        PageHelper.startPage(page, 10);
        List<ProdDesignVo> prodDesign = prodMapper.prodDesign(params);
        return PageInfo.of(prodDesign);
    }

    @Override
    public void prodAdd(ProdDetForm params) {
        prodMapper.insertProd(params);
        //创建java文件夹
//        String dirStr = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\resources\\static\\wision\\dist\\views\\supp\\prodlist\\mytest";
//        File directory = new File(dirStr);
//        directory.mkdir();
        //创建html文件夹
        //...
    }

    @Override
    public void prodDel(Long prodId) {
        prodMapper.deleteProd(prodId);
    }

    @Override
    public void prodEdit(ProdDetForm params) {
        prodMapper.updateProd(params);
    }

    @Override
    public List<BasicSourVo> tblList(Long prodId) {
        List<BasicSourVo> tblList = prodMapper.tblList(prodId);
        return tblList;
    }

    @Override
    public List<MenuListVo> menuList(Long prodId) {
        List<MenuListVo> menuList=prodMapper.menuList(prodId);
        for(int i=0;i<menuList.size();i++){
            List<RelatDetVo> toolList=prodMapper.getToolIdsByMenuId(menuList.get(i).getMenuId());
            String toolIds="";
            if(toolList.size()>0){
                for(int j=0;j<toolList.size();j++){
                    toolIds = toolIds + toolList.get(j).getToolId() + ",";
                }
                toolIds=toolIds.substring(0,toolIds.length()-1);
            }
            menuList.get(i).setToolIds(toolIds);
        }
        return menuList;
    }

    @Override
    public void menuAdd(Long prodId) {
        prodMapper.insertMenu(prodId);
    }

    @Override
    public void menuDel(Long menuId) {
//      先删除对应关系,再删除菜单
        prodMapper.deleteRelatExt(menuId);
        prodMapper.deleteRelatMain(menuId);
        prodMapper.deleteMenuMain(menuId);
    }


    @Override
    public void menuEdit(MenuEditForm params) {
        if(Objects.equals(params.getField(), "toolIds")){
//          在t_supp_relat_main表中新增菜单
            String toolIdsTemp = params.getValue()+',';
            while(toolIdsTemp.indexOf(',')>0){
                String toolId=toolIdsTemp.substring(0,toolIdsTemp.indexOf(','));
                Long checkRelat=prodMapper.checkRelat(params.getMenuId(),Long.valueOf(toolId));
                if(checkRelat==null){
                    prodMapper.insertRelat(params.getMenuId(),Long.valueOf(toolId));
                }
                toolIdsTemp=toolIdsTemp.substring(toolIdsTemp.indexOf(',')+1,toolIdsTemp.length());
            }
//          清除多余数据
            prodMapper.cleanExt(params.getMenuId(),params.getValue());
            prodMapper.cleanRelat(params.getMenuId(),params.getValue());
        }else {
//          更新其余信息时，仅更新菜单
            prodMapper.updateMenu(params.getMenuId(), method(params.getField()), params.getValue());
        }
    }

    @Override
    public List<MenuTreeVo> menuTree(Long prodId) {
        List<MenuTreeVo> MenuTreeVo=prodMapper.menuFather(prodId);
        for(int i=0;i<MenuTreeVo.size();i++){
            List<children> menuChild=prodMapper.menuChild(MenuTreeVo.get(i).getId());
            if(menuChild.size()!=0){
                MenuTreeVo.get(i).setChildren(menuChild);
            }else {
                i++;
            }
        }
        return MenuTreeVo;
    }

    @Override
    public PageInfo<ToolSelVo> toolSel(String prodId,ToolListForm params) {
        Integer page = 0;
        if(params.getPage() != null){
            page = params.getPage();
        }
        PageHelper.startPage(page, 10);
        String menuId;
        List<ToolSelVo> toolSel = new ArrayList<>();
        if(prodId.indexOf("menuId")>-1){
            menuId = prodId.substring(prodId.indexOf("menuId=")+7,prodId.length());
            toolSel = prodMapper.toolSel(Long.valueOf(menuId),params);
        }
        return PageInfo.of(toolSel);
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
    }

//    @Override
//    public List<ProdViewVo> prodView(String params) {
//        List<ProdViewVo> prodView=prodMapper.prodView(Long.valueOf(params));
//        prodView.get(0).setMenuList(prodMapper.menuList(Long.valueOf(params)));
//        return prodView;
//    }
//
//    @Override
//    public void tblSave(BasicTblList params) {
//        if(params.getAction().equals("del")){//删除
//            String tblName=prodMapper.checkTblExists(params.getTblCode());
//            if(tblName!=null){
//                prodMapper.dropTbl(params.getTblCode());
//            }
//            prodMapper.deleteTblById(params.getTblId());
//        }else{//新增
//            prodMapper.insertTblByName(params.getProdId(),params.getTblName());
//            Long tblId=prodMapper.getTblIdByName(params.getProdId(),params.getTblName());
//            String tblCode="t_imp_"+tblId+"_"+getPinYinHeadChar(params.getTblName());
//            prodMapper.updateTblByCode(tblId,tblCode);
//        }
//    }
//
////    @Override
////    public List<TblImpForm> tblList(String params) {
////        Long tblId=Long.valueOf(params.substring(0,params.indexOf("=")));
////        List<TblImpForm> tblList = prodMapper.tblList(tblId);
////        return tblList;
////    }
////
////    @Override
////    public List<TblImpForm> tblDet(String params) {
////        List<TblImpForm> tblDet = prodMapper.tblDet(Long.valueOf(params));
////        return tblDet;
////    }
//
//    @Override
//    public void relatSave(RelatForm params) {
//        //先判断组件类型，再判断是否主表
//        String toolType=prodMapper.getToolType(params.getRelatId());
//        if(toolType.equals("basic")){ //basic
//            String layoutType=prodMapper.getLayoutType(params.getRelatId());
//            String basicTbl;
//            if(layoutType!=null){//主表，更新映射，更新用户表名称
//                basicTbl="t_imp_"+params.getRelatId()+"_"+getPinYinHeadChar(params.getRelatName());
//                prodMapper.updateRelatBasic(params,basicTbl);
//            }else{ //非主表（字典表）
//                prodMapper.updateRelatBasic(params,null);
//            }
//        }else{ //flow
//            prodMapper.updateRelatFlow(params);
//            String check=prodMapper.checkStepCol(params.getMainTbl());
//            if(check==null){
//                prodMapper.addStepCol(params.getMainTbl());
//                prodMapper.iniStepCol(params.getMainTbl());
//                String stepCode=prodMapper.chkExtCol(prodMapper.getmainRelatId(params.getRelatId()));
//                if(stepCode==null){
//                    prodMapper.addExtCol(prodMapper.getmainRelatId(params.getRelatId()));
//                }
//            }
//        }
//    }
//
//    public static String getPinYinHeadChar(String str) {
//        if (isNull(str)) {
//            return "";
//        }
//        String convert = "";
//        for (int j = 0; j < str.length(); j++) {
//            char word = str.charAt(j);
//            // 提取汉字的首字母
//            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
//            if (pinyinArray != null) {
//                convert += pinyinArray[0].charAt(0);
//            }
//            else {
//                convert += word;
//            }
//        }
////        return convert.toUpperCase();
//        return convert;
//    }
//
//    @Override
//    public void basicImp(MultipartFile file,Long tblId,String tblCode) throws Exception {
////        tblId=159;tblCode=t_imp_159_ahdlsm
////        创建表并初始化
//        String[] keys = {"col1","col2","col3","col4","col5","col6","col7","col8","col9","col10"};
//        String keysName="'" + Arrays.toString(keys).substring(1,Arrays.toString(keys).length()-1).replace(",","','") + "'";
////        判断表是否存在
//        String tblName=prodMapper.checkTblExists(tblCode);
//        if(tblName!=null){
//            prodMapper.dropTbl(tblCode);
//        }
//        prodMapper.createTbl(tblCode,keysName);
//        prodMapper.cleanTbl(tblCode);
//        for(int k=0;k<keys.length;k++){
//            prodMapper.alterTbl(tblCode,keys[k]);
//        }
////        导入，读取excel中列的信息
//        List<Map<String, Object>> list= ExcelUtils.importExcel(file,keys);
//        for(Map<String,Object> map:list){
//            String col="";
//            for(int i=1;i<=map.size();i++){
//                col += "'"+map.get("col"+i).toString()+"',";
//            }
//            col=col.substring(0,col.length()-1);
//            prodMapper.insertTbl(tblCode,col);
//        }
////        先清除t_supp_relat_ext中已有表头
//        prodMapper.cleanHeader(tblId);
////        再重新新增t_supp_relat_ext表中的表头
//        String cols=Arrays.toString(keys).substring(1,Arrays.toString(keys).length()-1);
//        String[] array1 = cols.split(",");
//        cols=cols.replace(",",",',',");
//        String header=prodMapper.getHeader(tblCode,cols);
//        String[] array2 = header.split(",");
//        for(int i=0;i<array1.length;i++){
//            prodMapper.insertHeader(tblId,array1[i],array2[i]);
//        }
////        清除列中的空格
//        prodMapper.cleanBasicBlank();
////        从表中删除t_imp_X_X表中第一行表头
//        prodMapper.deleteHeader(tblCode);
//    }

//    @Override
//    public List<BasicCol> basicCol(Long id) {
//        List<BasicCol> basicCol=prodMapper.getColName(id);
//        return basicCol;
//    }
//
//    @Override
//    public void colSave(BasicCol params) {
//        prodMapper.updateCol(params.getExtId(),method(params.getField()),params.getValue());
//    }
//
//    @Override
//    public ChildTblDetForm childTblDet(String params) {
//        Long id = Long.valueOf(params.substring(0,params.indexOf("&")));
//        Long menuId = Long.valueOf(params.substring(params.indexOf("&")+1,params.length()));
//        ChildTblDetForm childTblDet = new ChildTblDetForm();
////        //获取字段名
//        List<BasicCol> childTblHeadDet = prodMapper.childTblHeadDet(menuId);
////        //获取字段值
//        String tblName = prodMapper.getBasicChildTbl(menuId);
//        ChildTblForm childTblContDet = prodMapper.childTblContDet(tblName,id);
////        //放入表格中
//        childTblDet.setId(id);
//        childTblDet.setMenuId(menuId);
//        childTblDet.setChildTblHeadDet(childTblHeadDet);
//        childTblDet.setChildTblContDet(childTblContDet);
//        return childTblDet;
//    }

//    @Override
//    public List<MainTblVo> mainTbl(String params) {
//        Long menuId=Long.valueOf(params.substring(params.indexOf("_")+1,params.length()));
//        List<MainTblVo> mainTbl=prodMapper.getMainTbl(menuId);
//        return mainTbl;
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
