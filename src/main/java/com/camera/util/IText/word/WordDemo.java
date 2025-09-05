//package com.wision.util;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
///**
// * @author fj
// * @date 2022-09-14 09:15
// * @description
// */
//public class wordDemo {
//    public static void main(String[] args) {
//        HashMap<String, Object> map = new HashMap<>();
//
//        //模拟其它普通数据
//        map.put("enName", "公司人员");
//        map.put("username", "张三");
//        map.put("date", "2019-10-10");
//        map.put("desc", "测试");
//        map.put("boo", "这是一段很长的描述，这是一段很长的说明阿附件三；阿济格你；是否是将连接 \" +\n" +
//                "                \"罚单否卡萨丁平万科蓝山，发送副经理。到家了开讲啦，的奖金额，第三方就拉萨尔，第三方就老魏到家了就饿了干的");
//        map.put("bool1","这是测试合并单元格");
//        //模拟表格数据
//        ArrayList<HashMap<String, String>> list = new ArrayList<>();
//        HashMap<String, String> temp = new HashMap<>();
//        temp.put("sn","1");
//        temp.put("name","设备1");
//        temp.put("age","设备问题1");
//        temp.put("exception", "有异常");
//        temp.put("qu", "这个设备有问题，会造成断电");
//        list.add(temp);
//        temp = new HashMap<>();
//        temp.put("sn","2");
//        temp.put("name","设备2");
//        temp.put("age","设备问题2");
//        temp.put("exception", "无");
//        temp.put("qu", "无");
//        list.add(temp);
//        temp = new HashMap<>();
//        temp.put("sn","3");
//        temp.put("name","设备3");
//        temp.put("age","设备问题3");
//        temp.put("exception", "有");
//        temp.put("qu", "无危害");
//        list.add(temp);
//        temp = new HashMap<>();
//        temp.put("sn","4");
//        temp.put("name","设备4");
//        temp.put("age","设备问题4");
//        temp.put("exception", "有");
//        temp.put("qu", "无危害");
//        list.add(temp);
//        map.put("personlist",list);
//        //word模板绝对路径、word生成路径、word生成的文件名称、数据源参数
//        wordutil.exportWord("E:\\cfj\\ware\\demo.docx", "E:\\cfj\\ware\\", "生成文件.docx", map);
//    }
//}