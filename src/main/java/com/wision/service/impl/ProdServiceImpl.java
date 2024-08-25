package com.wision.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.mapper.ProdMapper;
import com.wision.service.ProdService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProdServiceImpl implements ProdService {
    @Resource
    ProdMapper prodMapper;

    @Override
    public PageInfo<ProdListVo> prodList(ProdListForm params) {
        PageHelper.startPage(params.getPage(), 10);
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
        PageHelper.startPage(params.getPage(), 10);
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
    public List<TblListVo> tblList(Long prodId) {
        return null;
    }

//    @Override
//    public List<MenuListVo> menuList(String prodId) {
//        List<MenuListVo> menuList=prodMapper.menuList(Long.valueOf(prodId.substring(0,prodId.indexOf("="))));
//        for(int i=0;i<menuList.size();i++){
//            List<RelatDetVo> toolList=prodMapper.getToolIdsByMenuId(menuList.get(i).getMenuId());
//            String toolIds="";
//            if(toolList.size()>0){
//                for(int j=0;j<toolList.size();j++){
//                    toolIds = toolIds + toolList.get(j).getToolId() + ",";
//                }
//                toolIds=toolIds.substring(0,toolIds.length()-1);
//            }
//            menuList.get(i).setToolIds(toolIds);
//        }
//        return menuList;
//    }

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
//    @Override
//    public List<BasicTblList> basicTbl(String params) {
//        Long prodId=Long.valueOf(params.substring(0,params.indexOf("=")));
//        List<BasicTblList> basicTblList = prodMapper.basicTblList(prodId);
//        return basicTblList;
//    }

//
//    @Override
//    public void menuSave(MenuListForm params) {
//        if (params.getAction().equals("add")) {
//            prodMapper.insertMenu(params.getProdId());
//        } else if (params.getAction().equals("del")) {
////            先删除对应关系
//            List<RelatDetVo> relatIds=prodMapper.getRelatIdsByMenuId(params.getMenuId());
//            for(int i=0;i<relatIds.size();i++){
//                List<RelatDetVo> typeIds=prodMapper.getTypeIds(relatIds.get(i).getRelatId());
//                for(int j=0;j<typeIds.size();j++){
////                    *注:此处暂时写死为basic和step,后期再放开
//                    if(typeIds.get(j).getRelatName()=="basic" || typeIds.get(j).getRelatName()=="step"){
//                        prodMapper.deleteType(typeIds.get(j).getRelatId(),typeIds.get(j).getRelatName()+"_id","t_supp_tool_"+typeIds.get(j).getRelatName());
//                    }
//                }
//                prodMapper.deleteRelatExt(relatIds.get(i).getRelatId());
//            }
//            prodMapper.deleteRelatMain(params.getMenuId());
////            再删除菜单
//            prodMapper.deleteMenuMain(params.getMenuId());
//        } else if (params.getField().equals("toolIds")) {
////            更新对应关系t_supp_relat_main表和t_supp_relat_ext表
//            String toolIdsTemp=params.getValue()+',';
//            while(toolIdsTemp.indexOf(',')>0){
//                String toolId=toolIdsTemp.substring(0,toolIdsTemp.indexOf(','));
//                Long existRelat=prodMapper.existRelat(params.getMenuId(),Long.valueOf(toolId));
//                if(existRelat==null){
//                    prodMapper.insertRelat(params.getMenuId(),Long.valueOf(toolId));
//                    prodMapper.insertExtByMenu(params.getMenuId(),Long.valueOf(toolId));
//                }
//                toolIdsTemp=toolIdsTemp.substring(toolIdsTemp.indexOf(',')+1,toolIdsTemp.length());
//            }
////            清除多余数据
//            List<RelatDetVo> relatVo=prodMapper.getCleanExtIds(params.getMenuId(),params.getValue());
//            for(int i=0;i<relatVo.size();i++){
////                *注:此处暂时写死为basic和step,后期再放开
//                if(relatVo.get(i).getRelatName()=="basic" || relatVo.get(i).getRelatName()=="step"){
//                    prodMapper.cleanType("t_supp_tool_"+relatVo.get(i).getRelatName(),relatVo.get(i).getRelatName()+"_id",relatVo.get(i).getRelatId());
//                }
//            }
//            prodMapper.cleanExt(params.getMenuId(),params.getValue());
//            prodMapper.cleanRelat(params.getMenuId(),params.getValue());
//        } else {
////            更新其余信息时，仅更新菜单
//            prodMapper.updateMenu(params.getMenuId(),method(params.getField()),params.getValue());
//        }
//    }
//
//    @Override
//    public List<MenuTreeVo> menuTree(String params) {
//        return null;
//    }
//
////    @Override
////    public List<MenuTreeVo> menuTree(String params) {
////        List<MenuTreeVo> MenuTreeVo=prodMapper.menuFather(Long.valueOf(params));
////        for(int i=0;i<MenuTreeVo.size();i++){
////            List<children> menuChild=prodMapper.menuChild(MenuTreeVo.get(i).getId());
////            if(menuChild.size()!=0){
////                MenuTreeVo.get(i).setChildren(menuChild);
////            }else {
////                i++;
////            }
////        }
////        return MenuTreeVo;
////    }
////
////    @Override
////    public List<FlowListVo> flowList(String params) {
////        Long relatId=Long.valueOf(params.substring(0,params.indexOf("=")));
////        List<FlowListVo> flowList=prodMapper.flowList(relatId);
////        return flowList;
////    }
////
////    @Override
////    public void flowSave(FlowListForm params) {
////        if (params.getAction().equals("add")) {
////            prodMapper.insertFlow(params.getRelatId());
////        } else if (params.getAction().equals("del")) {
////            prodMapper.deleteFlow(params.getExtId());
////        } else {
////            prodMapper.updateFlow(params.getExtId(),method(params.getField()),params.getValue());
////        }
////    }
//
//    @Override
//    public List<RelatDetVo> relatDet(Long relatId) {
//        List<RelatDetVo> relatDet=prodMapper.relatDet(relatId);
////        String basicTbl=prodMapper.getMainTblByOtherRelatId(relatId);
////        relatDet.get(0).setMainTbl(basicTbl.substring(0,basicTbl.indexOf(",")));
////        relatDet.get(0).setBasicTbl(basicTbl.substring(basicTbl.indexOf(",")+1,basicTbl.length()));
//        return relatDet;
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
//    public List<ChildTblSelVo> childTblSel(String menuId) {
//        List<ChildTblCol> childTblCol=new ArrayList<>();
//        //增加选择框
//        ChildTblCol childTblMenu1=new ChildTblCol();
//        childTblMenu1.setType("checkbox");
//        childTblCol.add(childTblMenu1);
//        //获取查询结果列名
//        List<ChildTblCol> childTblCol1=prodMapper.getTblSel(Long.valueOf(menuId),"1",null);
//        for(int i=0;i<childTblCol1.size();i++){
//            childTblCol.add(childTblCol1.get(i));
//        }
//        //增加操作菜单
//        ChildTblCol childTblMenu2=new ChildTblCol();
//        childTblMenu2.setTitle("操作");
//        childTblMenu2.setToolbar("#test-table-toolbar-barDemo");
//        childTblCol.add(childTblMenu2);
//        //设置平均列间距
////        String width=String.valueOf(100/childTblCol.size())+'%';
//        String width="8%";
//        for(int i=0;i<childTblCol.size();i++){
//            childTblCol.get(i).setWidth(width);
//        }
//        //获取查询条件
//        List<ChildTblCol> basicSel=prodMapper.getTblSel(Long.valueOf(menuId),null,"1");
//        //将获取的列名插入ChildTblSel中
//        ChildTblSelVo ChildTblSel= new ChildTblSelVo();
//        ChildTblSel.setChildTblCol(childTblCol);
//        ChildTblSel.setChildTblSel(basicSel);
//        //将获取的列名插入ChildTblSelVo中
//        List<ChildTblSelVo> ChildTblSelVo = new ArrayList<>();
//        ChildTblSelVo.add(ChildTblSel);
//        return ChildTblSelVo;
//    }
//
//    @Override
//    public PageInfo<ChildTblForm> childTblCont(String menuId,ChildTblForm params) {
//        //获取表名
//        String tblName=prodMapper.getBasicChildTbl(Long.valueOf(menuId.substring(0,menuId.indexOf("="))));//tblName=t_imp_40_xmzb
//        //获取导入表的内容
//        PageHelper.startPage(params.getPage(), 10);
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
//        List<ChildTblForm> childTblCont=prodMapper.childTblCont(Long.valueOf(menuId.substring(0,menuId.indexOf("="))),params1);
//        return PageInfo.of(childTblCont);
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
