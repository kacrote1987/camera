package com.wision.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.mapper.ProdDesMapper;
import com.wision.service.ProdDesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ProdDesServiceImpl implements ProdDesService {
    @Resource
    ProdDesMapper prodDesMapper;

    @Override
    public void onLine(Long prodId) {
        prodDesMapper.onLine(prodId);
    }

    @Override
    public PageInfo<ProdDesignVo> prodDesign(ProdDesignForm params) {
        Integer page = 0;
        if(params.getPage() != null){
            page = params.getPage();
        }
        PageHelper.startPage(page, 10);
        List<ProdDesignVo> prodDesign = prodDesMapper.prodDesign(params);
        return PageInfo.of(prodDesign);
    }

    @Override
    public List<ProdDetVo> prodDet(Long prodId) {
        List<ProdDetVo> prodDet=prodDesMapper.prodDet(prodId);
        return prodDet;
    }

    @Override
    public void prodAdd(ProdDetForm params) {
        prodDesMapper.insertProd(params);
        //创建java文件夹
//        String dirStr = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\resources\\static\\wision\\dist\\views\\supp\\prodlist\\mytest";
//        File directory = new File(dirStr);
//        directory.mkdir();
        //创建html文件夹
        //...
    }

    @Override
    public void prodDel(Long prodId) {
        prodDesMapper.deleteProd(prodId);
    }

    @Override
    public void prodEdit(ProdDetForm params) {
        prodDesMapper.updateProd(params);
    }

    @Override
    public List<TblListVo> tblList(Long prodId) {
        List<TblListVo> tblList = prodDesMapper.tblList(prodId);
        return tblList;
    }

    @Override
    public List<MenuListVo> menuList(Long prodId) {
        List<MenuListVo> menuList=prodDesMapper.menuList(prodId);
        for(int i=0;i<menuList.size();i++){
            List<RelatDetVo> toolList=prodDesMapper.getToolIdsByMenuId(menuList.get(i).getMenuId());
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
        prodDesMapper.insertMenu(prodId);
    }

    @Override
    public void menuDel(Long menuId) {
//      先删除对应关系,再删除菜单
        prodDesMapper.deleteRelatExt(menuId);
        prodDesMapper.deleteRelatMain(menuId);
        prodDesMapper.deleteMenuMain(menuId);
    }


    @Override
    public void menuEdit(MenuEditForm params) {
        if(Objects.equals(params.getField(), "toolIds")){
//          在t_supp_relat_main表中新增菜单
            String toolIdsTemp = params.getValue()+',';
            while(toolIdsTemp.indexOf(',')>0){
                String toolId=toolIdsTemp.substring(0,toolIdsTemp.indexOf(','));

//                List<RelatDetVo> toolIdList = prodDesMapper.getToolIdsByMenuId();
//                params.getValue()

                Long checkRelat=prodDesMapper.checkRelat(params.getMenuId(),Long.valueOf(toolId));
                if(checkRelat==null){
                    prodDesMapper.insertRelat(params.getMenuId(),Long.valueOf(toolId));
                }


                toolIdsTemp=toolIdsTemp.substring(toolIdsTemp.indexOf(',')+1,toolIdsTemp.length());
            }
//          清除多余数据
            prodDesMapper.cleanExt(params.getMenuId(),params.getValue());
            prodDesMapper.cleanRelat(params.getMenuId(),params.getValue());
        }else {
//          更新其余信息时，仅更新菜单
            prodDesMapper.updateMenu(params.getMenuId(), method(params.getField()), params.getValue());
        }
    }

    @Override
    public List<MenuTreeVo> menuTree(Long prodId) {
        List<MenuTreeVo> MenuTreeVo=prodDesMapper.menuFather(prodId);
        for(int i=0;i<MenuTreeVo.size();i++){
            List<children> menuChild=prodDesMapper.menuChild(MenuTreeVo.get(i).getId());
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
            toolSel = prodDesMapper.toolSel(Long.valueOf(menuId),params);
        }
        return PageInfo.of(toolSel);
    }

    @Override
    public List<ChildListVo> childList(Long menuId) {
        List<ChildListVo> childList = prodDesMapper.childList(menuId);
        return childList;
    }

    @Override
    public void createPage(Long menuId) {
        Long relatId = prodDesMapper.getMainRelatId(menuId);
        List<PagePathVo> destinyPath = prodDesMapper.getDestinyPath(relatId);
        for(int i=0;i<destinyPath.size();i++){
            //1-删除同名html文件
            String filePath = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\resources\\static\\wision\\prodsto\\" + destinyPath.get(i).getDestinyPath();
            File htmlFile = new File(filePath);
            htmlFile.delete();
            //2-创建一个空的html文件
            String filepath = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\resources\\static\\wision\\prodsto\\" + destinyPath.get(i).getDestinyPath();
            File file = new File(filepath);
            try {
                file.createNewFile();
                System.out.println("文件创建成功！");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //3-生成新的页面
            List<PagePathVo> sourcePath = prodDesMapper.getSourcePath(relatId,destinyPath.get(i).getDestinyPath());
            String destinationPath = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\resources\\static\\wision\\prodsto\\"  + destinyPath.get(i).getDestinyPath(); // 目标页面路径
            for(int j=0;j<sourcePath.size();j++){
                sourcePath.get(j).setSourcePath("D:\\MyProgame\\Workspaces\\wision\\src\\main\\resources\\static\\wision\\toolsto\\" + sourcePath.get(j).getSourcePath()); // 替换成页面完整路径
                try (FileReader fr = new FileReader(sourcePath.get(j).getSourcePath());
                     BufferedReader br = new BufferedReader(fr);
                     FileWriter fw = new FileWriter(destinationPath, true); // 注意这里的true，表示追加
                     BufferedWriter bw = new BufferedWriter(fw)) {
                    String currentLine;
                    while ((currentLine = br.readLine()) != null) {
                        bw.write(currentLine + System.lineSeparator()); // 追加内容并换行
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
