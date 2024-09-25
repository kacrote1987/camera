package com.wision.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wision.entity.*;
import com.wision.mapper.ProdStoMapper;
import com.wision.service.ProdStoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
//        String tblName=childMapper.mainCont(menuId);//tblName=t_imp_40_xmzb
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
        String realPage = prodStoMapper.getRealPage(menuId);
        String tblName = "t_ext_" + realPage.replace("list.html","");
        List<MainContVo> mainCont=prodStoMapper.getMainCont(tblName);
        return PageInfo.of(mainCont);
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
