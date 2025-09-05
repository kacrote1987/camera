package com.camera.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class PdfTable {
    public static void main(String[] args) throws IOException, DocumentException {
        Document document = new Document();
        document.setPageSize(PageSize.A4);//设置A4
        BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(baseFont, 12);
        PdfWriter.getInstance(document, new FileOutputStream("D:/test.pdf"));
        document.open();

        PdfPTable table01 = new PdfPTable(1);
        PdfPCell cell0101 = new PdfPCell(new Phrase("需求调研记录表",font));//单元格
        PdfPCell cell0102 = new PdfPCell(new Phrase(" ",font));//单元格
        cell0101.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置单元格的垂直对齐方式
        cell0101.setHorizontalAlignment(Element.ALIGN_CENTER);//设置单元格的水平对齐方式
        cell0101.disableBorderSide(15);
        table01.addCell(cell0101);
        document.add(table01);

        PdfPTable table02 = new PdfPTable(1);
        PdfPCell cell0201 = new PdfPCell(new Phrase("工程名称：                                                                        编号：",font));//单元格
        cell0201.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置单元格的垂直对齐方式
        cell0201.setHorizontalAlignment(Element.ALIGN_LEFT);//设置单元格的水平对齐方式
        cell0201.disableBorderSide(13);
        table02.addCell(cell0201);
        document.add(table02);

        PdfPTable table03 = new PdfPTable(4);
        PdfPCell cell0301 = new PdfPCell(new Phrase("调研主题",font));//单元格
        cell0301.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置单元格的垂直对齐方式
        cell0301.setHorizontalAlignment(Element.ALIGN_CENTER);//设置单元格的水平对齐方式
        table03.addCell(cell0301);
        PdfPCell cell0302 = new PdfPCell(new Phrase("点位治理子系统、统一工作台、驾驶舱需求调研",font));//单元格
        cell0302.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置单元格的垂直对齐方式
        cell0302.setHorizontalAlignment(Element.ALIGN_CENTER);//设置单元格的水平对齐方式
        cell0302.setRowspan(1);
        cell0302.setColspan(3);
        table03.addCell(cell0302);
        PdfPCell cell0303 = new PdfPCell(new Phrase("调研部门",font));//单元格
        cell0303.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置单元格的垂直对齐方式
        cell0303.setHorizontalAlignment(Element.ALIGN_CENTER);//设置单元格的水平对齐方式
        table03.addCell(cell0303);
        PdfPCell cell0304 = new PdfPCell(new Phrase("区大数据局、区公安分局",font));//单元格
        cell0304.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置单元格的垂直对齐方式
        cell0304.setHorizontalAlignment(Element.ALIGN_CENTER);//设置单元格的水平对齐方式
        cell0304.setRowspan(1);
        cell0304.setColspan(3);
        table03.addCell(cell0304);
        document.add(table03);

        PdfPTable table04 = new PdfPTable(4);
        PdfPCell cell0401 = new PdfPCell(new Phrase("调研人员",font));//单元格
        cell0401.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置单元格的垂直对齐方式
        cell0401.setHorizontalAlignment(Element.ALIGN_CENTER);//设置单元格的水平对齐方式
        table04.addCell(cell0401);
        PdfPCell cell0402 = new PdfPCell(new Phrase("李淑华、赵新森、张纬良",font));//单元格
        cell0402.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置单元格的垂直对齐方式
        cell0402.setHorizontalAlignment(Element.ALIGN_CENTER);//设置单元格的水平对齐方式
        table04.addCell(cell0402);
        PdfPCell cell0403 = new PdfPCell(new Phrase("调研时间",font));//单元格
        cell0403.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置单元格的垂直对齐方式
        cell0403.setHorizontalAlignment(Element.ALIGN_CENTER);//设置单元格的水平对齐方式
        table04.addCell(cell0403);
        table04.addCell(new Paragraph(" ",font));
        document.add(table04);

        PdfPTable table05 = new PdfPTable(4);
        PdfPCell cell0501 = new PdfPCell(new Phrase("调研现况",font));//单元格
        cell0501.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置单元格的垂直对齐方式
        cell0501.setHorizontalAlignment(Element.ALIGN_CENTER);//设置单元格的水平对齐方式
        table05.addCell(cell0501);
        PdfPCell cell0502 = new PdfPCell(new Phrase("√系统开发前需求调研          □开发过程中需求变更调研      " +
                "□上线实施过程中需求变更      □上线实施过程中新增需求调研",font));//单元格
        cell0502.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置单元格的垂直对齐方式
        cell0502.setHorizontalAlignment(Element.ALIGN_LEFT);//设置单元格的水平对齐方式
        cell0502.setRowspan(1);
        cell0502.setColspan(3);
        table05.addCell(cell0502);
        table05.addCell(new Paragraph("",font));
        document.add(table05);

        PdfPTable table06 = new PdfPTable(1);
        PdfPCell cell0601 = new PdfPCell(new Phrase("调研记录",font));//单元格
        cell0601.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);//设置单元格的垂直对齐方式
        cell0601.setHorizontalAlignment(Element.ALIGN_CENTER);//设置单元格的水平对齐方式
        table06.addCell(cell0601);
        document.add(table06);

        PdfPTable table07 = new PdfPTable(1);
        PdfPCell cell0701 = new PdfPCell(new Paragraph("1、了解平台建设目标：\n" +
                "“万像慧治”视频监控一体化管理平台，以吴兴区为试点，依托全市智算中心、吴兴区“物联、数联、智联”三位一体的万物智联运营基地基础能力，聚焦点位共建、能力共享、视频共用、算法共管、事件共治需求，以点位治理、科学布建、视频共享、视频汇聚、资源存储“五统一”为核心功能，包含“我要建”“我要看”“我要派”“我要算”四大核心业务，实现对公共视频监控的全生命周期智能化一体化管理。\n" +
                "2、了解平台预期绩效；由区大数据局主导，搭建统一管理平台，实现堪点-治理-管理全链路流程可视化、可跟踪化，提高全域点位治理效率。\n" +
                "3、了解平台总体架构设计：\n" +
                "吴兴区“万像慧治”视频监控一体化管理平台中，子系统有：统一科学布建子系统、统一视频共享子系统、统一点位治理子系统、统一工作台、驾驶舱、统一综合运维子系统、统一智能算法子系统。\n" +
                "4、了解子系统功能和网络方面的要求：\n" +
                "功能方面：各子系统保证自身业务流程的完整性和可靠性，统一工作台打通浙政钉用户体系，打通各子系统间的数据交互，使部门操作更方便、友好；搭建的驾驶舱接入数据地图。\n" +
                "网络方面：增加必要的网络边界及安全设备，打通政务外网与各部门业务专网，提高安全性能；优化网络架构，去除平台中间节点，提升视频流畅性与清晰度。\n" +
                "了解业务范围：面向吴兴区各部委局办视频监控相关业务的全体工作人员、技术支撑人员。了解平台业务量；初步估计后续平台点位数在两万左右，日均治理量在二十左右，整体运维人员三千名。\n" +
                "5、信息量传输量和存储量分析与预测：\n" +
                "按照三千个用户估算，每个账号日均治理二十个点位，一年产生21900000条记录。",font));
        cell0701.disableBorderSide(2);
        table07.addCell(cell0701);
        document.add(table07);

        PdfPTable table08 = new PdfPTable(1);
        PdfPCell cell0801 = new PdfPCell(new Phrase("调研对象：\n\n\n\n\n\n",font));//单元格
        PdfPCell cell0802 = new PdfPCell(new Phrase(" 年   月   日",font));//单元格
        cell0802.setVerticalAlignment(PdfPCell.ALIGN_CENTER);//设置单元格的垂直对齐方式
        cell0802.setHorizontalAlignment(Element.ALIGN_RIGHT);//设置单元格的水平对齐方式
        cell0802.disableBorderSide(1);
        table08.addCell(cell0801);
        table08.addCell(cell0802);
        document.add(table08);

        document.close();
    }
}