package com.wision.service.impl;

import com.github.pagehelper.PageInfo;
import com.wision.entity.ChildMainVo;
import com.wision.entity.ChildMenuVo;
import com.wision.entity.TblContVo;
import com.wision.mapper.ChildMapper;
import com.wision.service.ChildService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChildServiceImpl implements ChildService {
    @Resource
    ChildMapper childMapper;

    @Override
    public String getChildName(Long prodId) {
        String childName = childMapper.getChildName(prodId);
        return childName;
    }

    @Override
    public ChildMainVo getChildMain(Long prodId) {
        ChildMainVo childMain = new ChildMainVo();
        childMain.setProdName(childMapper.getChildName(prodId));
        List<ChildMenuVo> childMenuVo = childMapper.getChildMenu(prodId);
        childMain.setChildMenuVo(childMenuVo);
        return childMain;
    }

    @Override
    public PageInfo<TblContVo> tblCont(Long menuId) {
//        //获取表名
//        String tblName=childMapper.getBasicChildTbl(menuId);//tblName=t_imp_40_xmzb
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
//        List<TblContVo> childTblCont=childMapper.childTblCont(menuId);
        return PageInfo.of(null);
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
