//package com.hsiri.util.itext.pdf;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.*;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.List;
//
//public class TaskPDF {
//
//    public static void main(String[] args) throws DocumentException, IOException {
//        //创建文件
//        Document document = new Document();
//        //建立一个书写器
//        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/test.pdf"));
//        //打开文件
//        document.open();
//
//        //中文字体,解决中文不能显示问题
//        BaseFont bfChinese = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
//
//        //黑色字体
//        Font blackFont = new Font(bfChinese);
//        blackFont.setColor(BaseColor.BLACK);
//        //创建章节
//        Paragraph chapterTitle = new Paragraph("HSQS/QR-339(1)", blackFont);
//        Chapter chapter1 = new Chapter(chapterTitle, '0');
//        chapter1.setNumberDepth(0);
//        Paragraph sectionTitle = new Paragraph("", blackFont);
//
//        Section section1 = chapter1.addSection(sectionTitle);
//        Paragraph sectionContent = new Paragraph("湖州市特种设备检测研究院\n", blackFont);
//        section1.add(sectionContent);
//
//        Paragraph sectionContent1 = new Paragraph("科技项目任务书\n", blackFont);
//        section1.add(sectionContent1);
//
//        Paragraph sectionContent2 = new Paragraph("项 目 编 号：\n项 目 名 称：\n专 业 类 别：\n项目负责人：\n起 止 年 月：", blackFont);
//        section1.add(sectionContent2);
//
//        // 3列的表.
//        PdfPTable table = new PdfPTable(8);
//        table.setWidthPercentage(100); // 宽度100%填充
//        table.setSpacingBefore(10f); // 前间距
//        table.setSpacingAfter(10f); // 后间距
//
//        List<PdfPRow> listRow = table.getRows();
//        //设置列宽
//        float[] columnWidths = { 1f, 1f, 1f, 1f, 1f, 1f, 1f, 1f };
//        table.setWidths(columnWidths);
//
//        //行1
//        PdfPCell cells1[]= new PdfPCell[8];
//        PdfPRow row1 = new PdfPRow(cells1);
//        //单元格
//        cells1[0] = new PdfPCell(new Paragraph("项目名称",blackFont));//单元格内容
//        cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells1[0].setColspan(2);
//        cells1[2] = new PdfPCell(new Paragraph(""));
//        cells1[2].setColspan(6);
//
//        //行2
//        PdfPCell cells2[]= new PdfPCell[8];
//        PdfPRow row2 = new PdfPRow(cells2);
//        //单元格
//        cells2[0] = new PdfPCell(new Paragraph("项目起止日期",blackFont));//单元格内容
//        cells2[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells2[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells2[0].setColspan(2);
//        cells2[2] = new PdfPCell(new Paragraph("年    月至     年   月",blackFont));
//        cells2[2].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells2[2].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells2[2].setColspan(6);
//
//        //行3
//        PdfPCell cells3[]= new PdfPCell[8];
//        PdfPRow row3 = new PdfPRow(cells3);
//        //单元格
//        cells3[0] = new PdfPCell(new Paragraph("项目经费(万元)",blackFont));//单元格内容
//        cells3[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells3[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells3[0].setColspan(2);
//        cells3[2] = new PdfPCell(new Paragraph(""));
//        cells3[2].setColspan(6);
//
//        //行4
//        PdfPCell cells4[]= new PdfPCell[8];
//        PdfPRow row4 = new PdfPRow(cells4);
//        //单元格
//        cells4[0] = new PdfPCell(new Paragraph("第一申请单位",blackFont));//单元格内容
//        cells4[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells4[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells4[0].setColspan(2);
//        cells4[2] = new PdfPCell(new Paragraph(""));
//        cells4[2].setColspan(4);
//        cells4[6] = new PdfPCell(new Paragraph(""));
//        cells4[7] = new PdfPCell(new Paragraph(""));
//
//        //行5
//        PdfPCell cells5[]= new PdfPCell[8];
//        PdfPRow row5 = new PdfPRow(cells5);
//        //单元格
//        cells5[0] = new PdfPCell(new Paragraph("合作单位",blackFont));//单元格内容
//        cells5[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells5[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells5[0].setRowspan(2);
//        cells5[1] = new PdfPCell(new Paragraph("1"));
//        cells5[1].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells5[1].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells5[2] = new PdfPCell(new Paragraph(""));
//        cells5[2].setColspan(6);
//
//        //行6
//        PdfPCell cells6[]= new PdfPCell[8];
//        PdfPRow row6 = new PdfPRow(cells6);
//        //单元格
//        cells6[1] = new PdfPCell(new Paragraph("2"));
//        cells6[1].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells6[1].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells6[2] = new PdfPCell(new Paragraph(""));
//        cells6[2].setColspan(6);
//
//        //行7
//        PdfPCell cells7[]= new PdfPCell[8];
//        PdfPRow row7 = new PdfPRow(cells7);
//        //单元格
//        cells7[0] = new PdfPCell(new Paragraph("项目组组成",blackFont));//单元格内容
//        cells7[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells7[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells7[0].setColspan(2);
//        cells7[2] = new PdfPCell(new Paragraph("姓名",blackFont));
//        cells7[2].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells7[2].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells7[3] = new PdfPCell(new Paragraph("出生年月",blackFont));
//        cells7[3].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells7[3].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells7[4] = new PdfPCell(new Paragraph("学位",blackFont));
//        cells7[4].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells7[4].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells7[5] = new PdfPCell(new Paragraph("职称/职务",blackFont));
//        cells7[5].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells7[5].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells7[6] = new PdfPCell(new Paragraph("工作单位",blackFont));
//        cells7[6].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells7[6].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells7[6].setColspan(2);
//
//        //行8
//        PdfPCell cells8[]= new PdfPCell[8];
//        PdfPRow row8 = new PdfPRow(cells8);
//        //单元格
//        cells8[0] = new PdfPCell(new Paragraph("项目负责人",blackFont));//单元格内容
//        cells8[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells8[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells8[0].setColspan(2);
//        cells8[2] = new PdfPCell(new Paragraph(""));
//        cells8[3] = new PdfPCell(new Paragraph(""));
//        cells8[4] = new PdfPCell(new Paragraph(""));
//        cells8[5] = new PdfPCell(new Paragraph(""));
//        cells8[6] = new PdfPCell(new Paragraph(""));
//        cells8[6].setColspan(2);
//
//        //行9
//        PdfPCell cells9[]= new PdfPCell[8];
//        PdfPRow row9 = new PdfPRow(cells9);
//        //单元格
//        cells9[0] = new PdfPCell(new Paragraph("项目组成员",blackFont));//单元格内容
//        cells9[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells9[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells9[0].setColspan(2);
//        cells9[2] = new PdfPCell(new Paragraph(""));
//        cells9[3] = new PdfPCell(new Paragraph(""));
//        cells9[4] = new PdfPCell(new Paragraph(""));
//        cells9[5] = new PdfPCell(new Paragraph(""));
//        cells9[6] = new PdfPCell(new Paragraph(""));
//        cells9[6].setColspan(2);
//
//        //行10
//        PdfPCell cells10[]= new PdfPCell[8];
//        PdfPRow row10 = new PdfPRow(cells10);
//        //单元格
//        cells10[0] = new PdfPCell(new Paragraph(" "));//单元格内容
//        cells10[0].setColspan(2);
//        cells10[2] = new PdfPCell(new Paragraph(""));
//        cells10[3] = new PdfPCell(new Paragraph(""));
//        cells10[4] = new PdfPCell(new Paragraph(""));
//        cells10[5] = new PdfPCell(new Paragraph(""));
//        cells10[6] = new PdfPCell(new Paragraph(""));
//        cells10[6].setColspan(2);
//
//        //行11
//        PdfPCell cells11[]= new PdfPCell[8];
//        PdfPRow row11 = new PdfPRow(cells11);
//        //单元格
//        cells11[0] = new PdfPCell(new Paragraph(" "));//单元格内容
//        cells11[0].setColspan(2);
//        cells11[2] = new PdfPCell(new Paragraph(""));
//        cells11[3] = new PdfPCell(new Paragraph(""));
//        cells11[4] = new PdfPCell(new Paragraph(""));
//        cells11[5] = new PdfPCell(new Paragraph(""));
//        cells11[6] = new PdfPCell(new Paragraph(""));
//        cells11[6].setColspan(2);
//
//        //行12
//        PdfPCell cells12[]= new PdfPCell[8];
//        PdfPRow row12 = new PdfPRow(cells12);
//        //单元格
//        cells12[0] = new PdfPCell(new Paragraph(" "));//单元格内容
//        cells12[0].setColspan(2);
//        cells12[2] = new PdfPCell(new Paragraph(""));
//        cells12[3] = new PdfPCell(new Paragraph(""));
//        cells12[4] = new PdfPCell(new Paragraph(""));
//        cells12[5] = new PdfPCell(new Paragraph(""));
//        cells12[6] = new PdfPCell(new Paragraph(""));
//        cells12[6].setColspan(2);
//
//        //行13
//        PdfPCell cells13[]= new PdfPCell[8];
//        PdfPRow row13 = new PdfPRow(cells13);
//        //单元格
//        cells13[0] = new PdfPCell(new Paragraph(" "));//单元格内容
//        cells13[0].setColspan(2);
//        cells13[2] = new PdfPCell(new Paragraph(""));
//        cells13[3] = new PdfPCell(new Paragraph(""));
//        cells13[4] = new PdfPCell(new Paragraph(""));
//        cells13[5] = new PdfPCell(new Paragraph(""));
//        cells13[6] = new PdfPCell(new Paragraph(""));
//        cells13[6].setColspan(2);
//
//        //行14
//        PdfPCell cells14[]= new PdfPCell[8];
//        PdfPRow row14 = new PdfPRow(cells14);
//        //单元格
//        cells14[0] = new PdfPCell(new Paragraph("项目主要研究内容、创新点及要达到的主要技术和经济指标\n"
//                + "一. 项目主要研究内容、创新点(含技术关键)\n" + "××××××××××××××××××××××××××××××××××××××××\n"
//                + "1. 项目主要研究内容\n" + "××××××××××××××××××××××××××××××××××××××××\n"
//                + "2. 项目的创新点和技术关键\n" + "项目主要创新点：\n" + "××××××××××××××××××××××××××××××××××××××××\n"
//                + "项目技术关键主要包括：\n" + "××××××××××××××××××××××××××××××××××××××××\n"
//                + "二. 项目要达到的主要技术和经济指标、社会效益及预期取得的科技成果、知识产权\n"
//                + "1. 主要技术和经济指标\n" + "××××××××××××××××××××××××××××××××××××××××\n"
//                + "2. 社会效益及技术应用前景\n" + "××××××××××××××××××××××××××××××××××××××××\n"
//                + "3. 预期取得的科技成果、知识产权\n" + "××××××××××××××××××××××××××××××××××××××××\n"
//                + "三. 计划进度\n"
//                ,blackFont));//单元格内容
//        cells14[0].setColspan(8);
//
//        //行15
//        PdfPCell cells15[]= new PdfPCell[8];
//        PdfPRow row15 = new PdfPRow(cells15);
//        //单元格
//        cells15[0] = new PdfPCell(new Paragraph("起止日期",blackFont));//单元格内容
//        cells15[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells15[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells15[0].setColspan(2);
//        cells15[2] = new PdfPCell(new Paragraph("进度目标要求(每栏限80字)",blackFont));
//        cells15[2].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells15[2].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells15[2].setColspan(6);
//
//        //行16
//        PdfPCell cells16[]= new PdfPCell[8];
//        PdfPRow row16 = new PdfPRow(cells16);
//        //单元格
//        cells16[0] = new PdfPCell(new Paragraph("起止日期",blackFont));//单元格内容
//        cells16[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells16[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells16[0].setColspan(2);
//        cells16[2] = new PdfPCell(new Paragraph("进度目标要求(每栏限80字)",blackFont));
//        cells16[2].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells16[2].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells16[2].setColspan(6);
//
//        //行17
//        PdfPCell cells17[]= new PdfPCell[8];
//        PdfPRow row17 = new PdfPRow(cells17);
//        //单元格
//        cells17[0] = new PdfPCell(new Paragraph("月  日至   月 日",blackFont));//单元格内容
//        cells17[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells17[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells17[0].setColspan(2);
//        cells17[2] = new PdfPCell(new Paragraph(""));
//        cells17[2].setColspan(6);
//
//        //行18
//        PdfPCell cells18[]= new PdfPCell[8];
//        PdfPRow row18 = new PdfPRow(cells18);
//        //单元格
//        cells18[0] = new PdfPCell(new Paragraph("月  日至   月 日",blackFont));//单元格内容
//        cells18[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells18[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells18[0].setColspan(2);
//        cells18[2] = new PdfPCell(new Paragraph(""));
//        cells18[2].setColspan(6);
//
//        //行19
//        PdfPCell cells19[]= new PdfPCell[8];
//        PdfPRow row19 = new PdfPRow(cells19);
//        //单元格
//        cells19[0] = new PdfPCell(new Paragraph("月  日至   月 日",blackFont));//单元格内容
//        cells19[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
//        cells19[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中
//        cells19[0].setColspan(2);
//        cells19[2] = new PdfPCell(new Paragraph(""));
//        cells19[2].setColspan(6);
//
//        //把第一行添加到集合
//        listRow.add(row1);
//        listRow.add(row2);
//        listRow.add(row3);
//        listRow.add(row4);
//        listRow.add(row5);
//        listRow.add(row6);
//        listRow.add(row7);
//        listRow.add(row8);
//        listRow.add(row9);
//        listRow.add(row10);
//        listRow.add(row11);
//        listRow.add(row12);
//        listRow.add(row13);
//        listRow.add(row14);
//        listRow.add(row15);
//        listRow.add(row16);
//        listRow.add(row17);
//        listRow.add(row18);
//        listRow.add(row19);
//        //将章节添加到文章中
//        document.add(chapter1);
//        //把表格添加到文件中
////        document.add(table);
//
//        //关闭文档
//        document.close();
//        //关闭书写器
//        writer.close();
//    }
//
//}