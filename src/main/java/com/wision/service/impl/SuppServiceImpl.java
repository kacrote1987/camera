package com.wision.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.mapper.SuppMapper;
import com.wision.service.SuppService;
import com.wision.util.ExcelUtils;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@Service
public class SuppServiceImpl implements SuppService {
    @Resource
    SuppMapper suppMapper;

    @Override
    public PageInfo<ToolListVo> toolList(ToolListForm params) {
        PageHelper.startPage(params.getPage(), 10);
        List<ToolListVo> toolList = suppMapper.toolList(params);
        return PageInfo.of(toolList);
    }

    @Override
    public List<ToolDetVo> toolDet(String params) {
        List<ToolDetVo> toolDet = null;
        if (!params.equals("add")) {
            toolDet = suppMapper.toolDet(Long.valueOf(params));
        }
        return toolDet;
    }

    @Override
    public void toolSave(ToolDetForm params) {
        if (params.getAction().equals("add")) {
            suppMapper.insertTool(params);
        } else if (params.getAction().equals("del")) {
            suppMapper.deleteTool(params.getToolId());
        } else {
            suppMapper.updateTool(params);
        }
    }

    @Override
    public PageInfo<ToolListVo> toolSel(String prodId,ToolListForm params) {
        PageHelper.startPage(params.getPage(), 10);
        String menuId;
        List<ToolListVo> toolSel = null;
        if(prodId.indexOf("menuId")>-1){
            menuId = prodId.substring(prodId.indexOf("menuId=")+7,prodId.length());
            toolSel = suppMapper.toolSel(Long.valueOf(menuId),params);
        }
        return PageInfo.of(toolSel);
    }

    @Override
    public PageInfo<ProdListVo> prodList(ProdListForm params) {
        PageHelper.startPage(params.getPage(), 10);
        List<ProdListVo> prodList = suppMapper.prodList(params);
        return PageInfo.of(prodList);
    }

    @Override
    public List<ProdDetVo> prodDet(String params) {
        List<ProdDetVo> prodDet=suppMapper.prodDet(params);
        return prodDet;
    }

    @Override
    public void prodSave(ProdDetForm params) {
        if (params.getAction().equals("add")) {
            suppMapper.insertProd(params);
        } else if (params.getAction().equals("del")) {
            suppMapper.deleteProd(params.getProdId());
        } else {
            suppMapper.updateProd(params);
        }
        //创建文件夹
        String dirStr = "D:\\MyProgame\\Workspaces\\wision\\src\\main\\resources\\static\\wision\\dist\\views\\supp\\prodlist\\mytest";
        File directory = new File(dirStr);
        directory.mkdir();
        //创建html文件
        //...
    }

    @Override
    public List<ProdViewVo> prodView(String params) {
        List<ProdViewVo> prodView=suppMapper.prodView(Long.valueOf(params));
        prodView.get(0).setMenuList(suppMapper.menuList(Long.valueOf(params)));
        return prodView;
    }

    @Override
    public void tblSave(BasicTblList params) {
        if(params.getAction().equals("del")){//删除
            String tblName=suppMapper.checkTblExists(params.getTblCode());
            if(tblName!=null){
                suppMapper.dropTbl(params.getTblCode());
            }
            suppMapper.deleteTblById(params.getTblId());
        }else{//新增
            suppMapper.insertTblByName(params.getProdId(),params.getTblName());
            Long tblId=suppMapper.getTblIdByName(params.getProdId(),params.getTblName());
            String tblCode="t_imp_"+tblId+"_"+getPinYinHeadChar(params.getTblName());
            suppMapper.updateTblByCode(tblId,tblCode);
        }
    }

    @Override
    public List<BasicTblList> basicTbl(String params) {
        Long prodId=Long.valueOf(params.substring(0,params.indexOf("=")));
        List<BasicTblList> basicTblList = suppMapper.basicTblList(prodId);
        return basicTblList;
    }

    @Override
    public List<MenuListVo> menuList(String prodId) {
        List<MenuListVo> menuList=suppMapper.menuList(Long.valueOf(prodId.substring(0,prodId.indexOf("="))));
        for(int i=0;i<menuList.size();i++){
            List<RelatDetVo> toolList=suppMapper.getToolIdsByMenuId(menuList.get(i).getMenuId());
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
    public void menuSave(MenuListForm params) {
        if (params.getAction().equals("add")) {
            suppMapper.insertMenu(params.getProdId());
        } else if (params.getAction().equals("del")) {
//            先删除对应关系
            List<RelatDetVo> relatIds=suppMapper.getRelatIdsByMenuId(params.getMenuId());
            for(int i=0;i<relatIds.size();i++){
                List<RelatDetVo> typeIds=suppMapper.getTypeIds(relatIds.get(i).getRelatId());
                for(int j=0;j<typeIds.size();j++){
//                    *注:此处暂时写死为basic和step,后期再放开
                    if(typeIds.get(j).getRelatName()=="basic" || typeIds.get(j).getRelatName()=="step"){
                        suppMapper.deleteType(typeIds.get(j).getRelatId(),typeIds.get(j).getRelatName()+"_id","t_supp_tool_"+typeIds.get(j).getRelatName());
                    }
                }
                suppMapper.deleteRelatExt(relatIds.get(i).getRelatId());
            }
            suppMapper.deleteRelatMain(params.getMenuId());
//            再删除菜单
            suppMapper.deleteMenuMain(params.getMenuId());
        } else if (params.getField().equals("toolIds")) {
//            更新对应关系t_supp_relat_main表和t_supp_relat_ext表
            String toolIdsTemp=params.getValue()+',';
            while(toolIdsTemp.indexOf(',')>0){
                String toolId=toolIdsTemp.substring(0,toolIdsTemp.indexOf(','));
                Long existRelat=suppMapper.existRelat(params.getMenuId(),Long.valueOf(toolId));
                if(existRelat==null){
                    suppMapper.insertRelat(params.getMenuId(),Long.valueOf(toolId));
                    suppMapper.insertExtByMenu(params.getMenuId(),Long.valueOf(toolId));
                }
                toolIdsTemp=toolIdsTemp.substring(toolIdsTemp.indexOf(',')+1,toolIdsTemp.length());
            }
//            清除多余数据
            List<RelatDetVo> relatVo=suppMapper.getCleanExtIds(params.getMenuId(),params.getValue());
            for(int i=0;i<relatVo.size();i++){
//                *注:此处暂时写死为basic和step,后期再放开
                if(relatVo.get(i).getRelatName()=="basic" || relatVo.get(i).getRelatName()=="step"){
                    suppMapper.cleanType("t_supp_tool_"+relatVo.get(i).getRelatName(),relatVo.get(i).getRelatName()+"_id",relatVo.get(i).getRelatId());
                }
            }
            suppMapper.cleanExt(params.getMenuId(),params.getValue());
            suppMapper.cleanRelat(params.getMenuId(),params.getValue());
        } else {
//            更新其余信息时，仅更新菜单
            suppMapper.updateMenu(params.getMenuId(),method(params.getField()),params.getValue());
        }
    }

    @Override
    public List<MenuTreeVo> menuTree(String params) {
        List<MenuTreeVo> MenuTreeVo=suppMapper.menuFather(Long.valueOf(params));
        for(int i=0;i<MenuTreeVo.size();i++){
            List<children> menuChild=suppMapper.menuChild(MenuTreeVo.get(i).getId());
            if(menuChild.size()!=0){
                MenuTreeVo.get(i).setChildren(menuChild);
            }else {
                i++;
            }
        }
        return MenuTreeVo;
    }

    @Override
    public List<FlowListVo> flowList(String params) {
        Long relatId=Long.valueOf(params.substring(0,params.indexOf("=")));
        List<FlowListVo> flowList=suppMapper.flowList(relatId);
        return flowList;
    }

    @Override
    public void flowSave(FlowListForm params) {
        if (params.getAction().equals("add")) {
            suppMapper.insertFlow(params.getRelatId());
        } else if (params.getAction().equals("del")) {
            suppMapper.deleteFlow(params.getExtId());
        } else {
            suppMapper.updateFlow(params.getExtId(),method(params.getField()),params.getValue());
        }
    }

    @Override
    public List<RelatDetVo> relatDet(Long relatId) {
        List<RelatDetVo> relatDet=suppMapper.relatDet(relatId);
//        String basicTbl=suppMapper.getMainTblByOtherRelatId(relatId);
//        relatDet.get(0).setMainTbl(basicTbl.substring(0,basicTbl.indexOf(",")));
//        relatDet.get(0).setBasicTbl(basicTbl.substring(basicTbl.indexOf(",")+1,basicTbl.length()));
        return relatDet;
    }

    @Override
    public List<TblImpForm> tblList(String params) {
        Long tblId=Long.valueOf(params.substring(0,params.indexOf("=")));
        List<TblImpForm> tblList = suppMapper.tblList(tblId);
        return tblList;
    }

    @Override
    public List<TblImpForm> tblDet(String params) {
        List<TblImpForm> tblDet = suppMapper.tblDet(Long.valueOf(params));
        return tblDet;
    }

    @Override
    public void relatSave(RelatForm params) {
        //先判断组件类型，再判断是否主表
        String toolType=suppMapper.getToolType(params.getRelatId());
        if(toolType.equals("basic")){ //basic
            String layoutType=suppMapper.getLayoutType(params.getRelatId());
            String basicTbl;
            if(layoutType!=null){//主表，更新映射，更新用户表名称
                basicTbl="t_imp_"+params.getRelatId()+"_"+getPinYinHeadChar(params.getRelatName());
                suppMapper.updateRelatBasic(params,basicTbl);
            }else{ //非主表（字典表）
                suppMapper.updateRelatBasic(params,null);
            }
        }else{ //flow
            suppMapper.updateRelatFlow(params);
            String check=suppMapper.checkStepCol(params.getMainTbl());
            if(check==null){
                suppMapper.addStepCol(params.getMainTbl());
                suppMapper.iniStepCol(params.getMainTbl());
                String stepCode=suppMapper.chkExtCol(suppMapper.getmainRelatId(params.getRelatId()));
                if(stepCode==null){
                    suppMapper.addExtCol(suppMapper.getmainRelatId(params.getRelatId()));
                }
            }
        }
    }

    public static String getPinYinHeadChar(String str) {
        if (isNull(str)) {
            return "";
        }
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            // 提取汉字的首字母
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            }
            else {
                convert += word;
            }
        }
//        return convert.toUpperCase();
        return convert;
    }

    @Override
    public void basicImp(MultipartFile file,Long tblId,String tblCode) throws Exception {
//        tblId=159;tblCode=t_imp_159_ahdlsm
//        创建表并初始化
        String[] keys = {"col1","col2","col3","col4","col5","col6","col7","col8","col9","col10"};
        String keysName="'" + Arrays.toString(keys).substring(1,Arrays.toString(keys).length()-1).replace(",","','") + "'";
//        判断表是否存在
        String tblName=suppMapper.checkTblExists(tblCode);
        if(tblName!=null){
            suppMapper.dropTbl(tblCode);
        }
        suppMapper.createTbl(tblCode,keysName);
        suppMapper.cleanTbl(tblCode);
        for(int k=0;k<keys.length;k++){
            suppMapper.alterTbl(tblCode,keys[k]);
        }
//        导入，读取excel中列的信息
        List<Map<String, Object>> list= ExcelUtils.importExcel(file,keys);
        for(Map<String,Object> map:list){
            String col="";
            for(int i=1;i<=map.size();i++){
                col += "'"+map.get("col"+i).toString()+"',";
            }
            col=col.substring(0,col.length()-1);
            suppMapper.insertTbl(tblCode,col);
        }
//        先清除t_supp_relat_ext中已有表头
        suppMapper.cleanHeader(tblId);
//        再重新新增t_supp_relat_ext表中的表头
        String cols=Arrays.toString(keys).substring(1,Arrays.toString(keys).length()-1);
        String[] array1 = cols.split(",");
        cols=cols.replace(",",",',',");
        String header=suppMapper.getHeader(tblCode,cols);
        String[] array2 = header.split(",");
        for(int i=0;i<array1.length;i++){
            suppMapper.insertHeader(tblId,array1[i],array2[i]);
        }
//        清除列中的空格
        suppMapper.cleanBasicBlank();
//        从表中删除t_imp_X_X表中第一行表头
        suppMapper.deleteHeader(tblCode);
    }

    @Override
    public List<BasicCol> basicCol(Long id) {
        List<BasicCol> basicCol=suppMapper.getColName(id);
        return basicCol;
    }

    @Override
    public void colSave(BasicCol params) {
        suppMapper.updateCol(params.getExtId(),method(params.getField()),params.getValue());
    }

    @Override
    public List<ChildTblSelVo> childTblSel(String menuId) {
        List<ChildTblCol> childTblCol=new ArrayList<>();
        //增加选择框
        ChildTblCol childTblMenu1=new ChildTblCol();
        childTblMenu1.setType("checkbox");
        childTblCol.add(childTblMenu1);
        //获取查询结果列名
        List<ChildTblCol> childTblCol1=suppMapper.getTblSel(Long.valueOf(menuId),"1",null);
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
        List<ChildTblCol> basicSel=suppMapper.getTblSel(Long.valueOf(menuId),null,"1");
        //将获取的列名插入ChildTblSel中
        ChildTblSelVo ChildTblSel= new ChildTblSelVo();
        ChildTblSel.setChildTblCol(childTblCol);
        ChildTblSel.setChildTblSel(basicSel);
        //将获取的列名插入ChildTblSelVo中
        List<ChildTblSelVo> ChildTblSelVo = new ArrayList<>();
        ChildTblSelVo.add(ChildTblSel);
        return ChildTblSelVo;
    }

    @Override
    public PageInfo<ChildTblForm> childTblCont(String menuId,ChildTblForm params) {
        //获取表名
        String tblName=suppMapper.getBasicChildTbl(Long.valueOf(menuId.substring(0,menuId.indexOf("="))));//tblName=t_imp_40_xmzb
        //获取导入表的内容
        PageHelper.startPage(params.getPage(), 10);
        String search=params.getSearch()+",";
        String val=params.getVal();
        ChildTblCont params1 = new ChildTblCont();
        params1.setTblName(tblName);
        if(val!=null){
            while (search.indexOf(",")>0){
                String key=search.substring(0,search.indexOf(","));
                String value=val.substring(0,val.indexOf(","));
                if(key.equals("col1")){
                    params1.setCol1(value);
                }else if(key.equals("col2")){
                    params1.setCol2(value);
                }else if(key.equals("col3")){
                    params1.setCol3(value);
                }else if(key.equals("col4")){
                    params1.setCol4(value);
                }else if(key.equals("col5")){
                    params1.setCol5(value);
                }else if(key.equals("col6")){
                    params1.setCol6(value);
                }else if(key.equals("col7")){
                    params1.setCol7(value);
                }else if(key.equals("col8")){
                    params1.setCol8(value);
                }else if(key.equals("col9")){
                    params1.setCol9(value);
                }else if(key.equals("col10")){
                    params1.setCol10(value);
                }else if(key.equals("col11")){
                    params1.setCol11(value);
                }else if(key.equals("col12")){
                    params1.setCol12(value);
                }else if(key.equals("col13")){
                    params1.setCol13(value);
                }else if(key.equals("col14")){
                    params1.setCol14(value);
                }else if(key.equals("col15")){
                    params1.setCol15(value);
                }else if(key.equals("col16")){
                    params1.setCol16(value);
                }else if(key.equals("col17")){
                    params1.setCol17(value);
                }else if(key.equals("col18")){
                    params1.setCol18(value);
                }else if(key.equals("col19")){
                    params1.setCol19(value);
                }else if(key.equals("col20")){
                    params1.setCol20(value);
                }else{
                    params1.setStep(value);
//                    if(projStepcode==null){
//                        projStepcode="step0"; }
//                    projStepcode=projStepcode.substring(4,projStepcode.length());
                }
                search=search.substring(search.indexOf(",")+1,search.length());
                val=val.substring(val.indexOf(",")+1,val.length());
            }
//            String jsonString = JSONObject.toJSONString(params1);
//            System.out.println("jsonString = " + jsonString);
        }
        List<ChildTblForm> childTblCont=suppMapper.childTblCont(Long.valueOf(menuId.substring(0,menuId.indexOf("="))),params1);
        return PageInfo.of(childTblCont);
    }

    @Override
    public ChildTblDetForm childTblDet(String params) {
        Long id = Long.valueOf(params.substring(0,params.indexOf("&")));
        Long menuId = Long.valueOf(params.substring(params.indexOf("&")+1,params.length()));
        ChildTblDetForm childTblDet = new ChildTblDetForm();
//        //获取字段名
        List<BasicCol> childTblHeadDet = suppMapper.childTblHeadDet(menuId);
//        //获取字段值
        String tblName = suppMapper.getBasicChildTbl(menuId);
        ChildTblForm childTblContDet = suppMapper.childTblContDet(tblName,id);
//        //放入表格中
        childTblDet.setId(id);
        childTblDet.setMenuId(menuId);
        childTblDet.setChildTblHeadDet(childTblHeadDet);
        childTblDet.setChildTblContDet(childTblContDet);
        return childTblDet;
    }

    @Override
    public List<MainTblVo> mainTbl(String params) {
        Long menuId=Long.valueOf(params.substring(params.indexOf("_")+1,params.length()));
        List<MainTblVo> mainTbl=suppMapper.getMainTbl(menuId);
        return mainTbl;
    }

    @Override
    public Float calculator(Calculator params) {
        Float param1,param2,param3,param4,param5,param6;
        if(params.getParam1()==null){param1=0f;}else{param1=params.getParam1();}
        if(params.getParam2()==null){param2=0f;}else{param2=params.getParam2();}
        if(params.getParam3()==null){param3=0f;}else{param3=params.getParam3();}
        if(params.getParam4()==null){param4=0f;}else{param4=params.getParam4();}
        if(params.getParam5()==null){param5=0f;}else{param5=params.getParam5();}
        if(params.getParam6()==null){param6=0f;}else{param6=params.getParam6();}
        Float result=param1+param2+param3+param4+param5+param6;
        return result;
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
