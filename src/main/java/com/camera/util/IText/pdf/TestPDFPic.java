//package com.hsiri.util.itext.pdf;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPRow;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.net.URL;
//import java.util.List;
//
//public class TestPDFPic {
//
//    public static void main(String[] args) throws DocumentException, IOException {
//
//        //创建文件
//        Document document = new Document();
//        //建立一个书写器
//        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/test.pdf"));
//        //打开文件
//        document.open();
//        //添加内容
//        document.add(new Paragraph("HD content here"));
//
//        //图片1
//        Image image1 = Image.getInstance("D:/微信图片_20210304144346.jpg");
//        //设置图片位置的x轴和y周
//        image1.setAbsolutePosition(100f, 550f);
//        //设置图片的宽度和高度
//        image1.scaleAbsolute(200, 200);
//        //将图片1添加到pdf文件中
//        document.add(image1);
//
//        //图片2
////        Image image2 = Image.getInstance(new URL("http://static.cnblogs.com/images/adminlogo.gif"));
//        //将图片2添加到pdf文件中
////        document.add(image2);
//
//        //关闭文档
//        document.close();
//        //关闭书写器
//        writer.close();
//    }
//
//}