//package com.wision.util;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.*;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import static com.itextpdf.text.pdf.PdfName.DEST;
//
///**
// * @version V1.0
// * @Description：生成PDF文件
// * @Author: Mr.LJie
// * @Date: 2021/11/30 14:17
// */
//public class PdfUtils {
//    /**
//     * 固定高
//     */
//    public static float fixedHeight = 27f;
//    /**
//     * 跨行
//     */
//    public static int rowSpan = 0;
//    /**
//     * 跨列
//     */
//    public static int colSpan = 0;
//    /**
//     * 左边距
//     */
//    public static float marginLeft = 20;
//    /**
//     * 右边距
//     */
//    public static float marginRight = 20;
//    /**
//     * 上边距
//     */
//    public static float marginTop = 20;
//    /**
//     * 下边距
//     */
//    public static float marginBottom = 20;
//
//    /***
//     * @Description :创建A4纵向文件
//     * @param
//     * @return com.itextpdf.text.Document
//     * @Author Mr.Jie
//     * @Date 2021/11/30 14:25
//     */
//    public static Document createPortraitDocument() {
//        //生成pdf
//        Document document = new Document();
//        // 页面大小
//        Rectangle rectangle = new Rectangle(PageSize.A4);
//        // 页面背景颜色
//        rectangle.setBackgroundColor(BaseColor.WHITE);
//        document.setPageSize(rectangle);
//        // 页边距 左，右，上，下
//        document.setMargins(marginLeft, marginRight, marginTop, marginBottom);
//        return document;
//    }
//
//    /***
//     * @Description :创建A4横向文件
//     * @param
//     * @return com.itextpdf.text.Document
//     * @Author Mr.Jie
//     * @Date 2021/11/30 15:42
//     */
//    public static Document createTransverseDocument() {
//        //生成pdf
//        Document document = new Document();
//        // 页面大小
//        Rectangle rectangle = new Rectangle(new RectangleReadOnly(842F, 595F));
//        // 页面背景颜色
//        rectangle.setBackgroundColor(BaseColor.WHITE);
//        document.setPageSize(rectangle);
//        // 页边距 左，右，上，下
//        document.setMargins(marginLeft, marginRight, marginTop, marginBottom);
//
//        return document;
//    }
//
//    /**
//     * @param text 段落内容
//     * @param font 字体设置
//     * @return com.itextpdf.text.Paragraph
//     * @Description :创建段落内容
//     * @Author Mr.Jie
//     * @Date 2021/11/30 14:59
//     */
//    public static Paragraph createParagraph(String text, Font font) {
//        Paragraph elements = new Paragraph(text, font);
//        elements.setSpacingBefore(5);
//        elements.setSpacingAfter(5);
//        return elements;
//    }
//
//
//    /***
//     * @Description :创建字体样式
//     * @param fontNumber    字号
//     * @param fontSize      字体大小
//     * @param fontColor     字体颜色
//     * @return com.itextpdf.text.Font
//     * @Author Mr.Jie
//     * @Date 2021/11/30 14:57
//     */
//    public static Font createFont(int fontNumber, int fontSize, BaseColor fontColor) {
//        //中文字体 ----不然中文会乱码
//        BaseFont bf = null;
//        try {
//            bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//            return new Font(bf, fontNumber, fontSize, fontColor);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new Font(bf, Font.DEFAULTSIZE, Font.NORMAL, BaseColor.BLACK);
//    }
//
//    /***
//     * @Description :隐藏表格边框线
//     * @param cell  单元格
//     * @return void
//     * @Author Mr.Jie
//     * @Date 2021/11/30 14:57
//     */
//    public static void disableBorderSide(PdfPCell cell) {
//        if (cell != null) {
//            cell.disableBorderSide(1);
//            cell.disableBorderSide(2);
//            cell.disableBorderSide(4);
//            cell.disableBorderSide(8);
//        }
//    }
//
//
//    /***
//     * @Description :创建居中得单元格
//     * @param
//     * @return com.itextpdf.text.pdf.PdfPCell
//     * @Author Mr.Jie
//     * @Date 2021/11/30 14:57
//     */
//    public static PdfPCell createCenterPdfPCell() {
//        PdfPCell cell = new PdfPCell();
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setFixedHeight(fixedHeight);
//        return cell;
//    }
//
//    /***
//     * @Description :创建指定文字得单元格
//     * @param text      文字内容
//     * @param rowSpan   跨行合并单元格
//     * @param colSpan   跨列合并单元格
//     * @param font      字体
//     * @return com.itextpdf.text.pdf.PdfPCell
//     * @Author Mr.Jie
//     * @Date 2021/11/30 14:50
//     */
//    public static PdfPCell createCenterPdfPCell(String text, int rowSpan, int colSpan, Font font) {
//        PdfPCell cell = new PdfPCell(new Paragraph(text, font));
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//        cell.setFixedHeight(fixedHeight);
//        cell.setRowspan(rowSpan);
//        cell.setColspan(colSpan);
//        return cell;
//    }
//
//    /***
//     * @Description :表格列数
//     * @param len
//     * @return com.itextpdf.text.pdf.PdfPTable
//     * @Author Mr.Jie
//     * @Date 2021/11/30 14:52
//     */
//    public static PdfPTable createPdfPTable(int len) {
//        PdfPTable pdfPTable = new PdfPTable(len);
//        //宽度100%填充
//        pdfPTable.setWidthPercentage(100);
//        return pdfPTable;
//    }
//
//    /***
//     * @Description :创建表头
//     * @param document
//     * @param headers
//     * @param font
//     * @return void
//     * @Author Mr.Jie
//     * @Date 2021/11/30 15:27
//     */
//    public static void createHeader(Document document, PdfPTable table, String[] headers, Font font) throws DocumentException {
//        for (int i = 0; i < headers.length; i++) {
//            //默认不跨行、跨列
//            PdfPCell cell = PdfUtils.createCenterPdfPCell(headers[i], rowSpan, rowSpan, font);
//            //居中显示
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            table.addCell(cell);
//        }
//        document.add(table);
//    }
//
//    /***
//     * @Description :数据处理
//     * @param document
//     * @param table
//     * @param list
//     * @param font
//     * @return void
//     * @Author Mr.Jie
//     * @Date 2021/11/30 15:32
//     */
//    public static void dataProcessing(Document document, PdfPTable table, List<Map<String, Object>> list, Font font) throws DocumentException {
//        Iterator<Map<String, Object>> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            //获取对象
//            Map<String, Object> map = iterator.next();
//            //Map 获取key & value
//            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                Object value = entry.getValue();
//                //默认不跨行、跨列
//                PdfPCell cell = PdfUtils.createCenterPdfPCell(value.toString(), rowSpan, rowSpan, font);
//                table.addCell(cell);
//            }
//            document.add(table);
//        }
//    }
//
////其他其他
//    /**
//     * 表格各种属性综合使用
//     *
//     * @throws IOException
//     * @throws DocumentException
//     */
//    public static void createTablePdf() throws IOException, DocumentException {
//        Document document = new Document();
//        // 创建PdfWriter对象
//        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(String.valueOf(DEST)));
//        // 打开文档
//        document.open();
//
//        // 添加表格，4列
//        PdfPTable table = new PdfPTable(4);
////        设置表格宽度比例为%100
//        table.setWidthPercentage(100);
//        // 设置表格的宽度
//        table.setTotalWidth(500);
//        // 也可以每列分别设置宽度
//        table.setTotalWidth(new float[] { 160, 70, 130, 100 });
//        // 锁住宽度
//        table.setLockedWidth(true);
//        // 设置表格上面空白宽度
//        table.setSpacingBefore(10f);
//        // 设置表格下面空白宽度
//        table.setSpacingAfter(10f);
//        // 设置表格默认为无边框
//        table.getDefaultCell().setBorder(0);
//        PdfContentByte cb = writer.getDirectContent();
//
//        // 构建每个单元格
//        PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
//        // 边框颜色
//        cell1.setBorderColor(BaseColor.BLUE);
//        // 设置背景颜色
//        cell1.setBackgroundColor(BaseColor.ORANGE);
//        // 设置跨两行
//        cell1.setRowspan(2);
//        // 设置距左边的距离
//        cell1.setPaddingLeft(10);
//        // 设置高度
//        cell1.setFixedHeight(20);
//        // 设置内容水平居中显示
//        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
//        // 设置垂直居中
//        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell1);
//
//        PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
//        cell2.setBorderColor(BaseColor.GREEN);
//        cell2.setPaddingLeft(10);
//        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell2);
//
//        PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
//        cell3.setBorderColor(BaseColor.RED);
//        cell3.setPaddingLeft(10);
//        // 设置无边框
//        cell3.setBorder(Rectangle.NO_BORDER);
//        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell3);
//
//        // 在表格添加图片
////        Image cellimg = Image.getInstance(IMG1);
////        PdfPCell cell4 = new PdfPCell(cellimg, true);
////        cell4.setBorderColor(BaseColor.RED);
////        cell4.setPaddingLeft(10);
////        cell4.setFixedHeight(30);
////        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
////        cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
////        table.addCell(cell4);
//
//        // 增加一个条形码到表格
//        Barcode128 code128 = new Barcode128();
//        code128.setCode("14785236987541");
//        code128.setCodeType(Barcode128.CODE128);
//        // 生成条形码图片
//        Image code128Image = code128.createImageWithBarcode(cb, null, null);
//        // 加入到表格
//        PdfPCell cellcode = new PdfPCell(code128Image, true);
//        cellcode.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cellcode.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cellcode.setFixedHeight(30);
//        table.addCell(cellcode);
//
//        PdfPCell cell5 = new PdfPCell(new Paragraph("Cell 5"));
//        cell5.setPaddingLeft(10);
//        // 设置占用列数
//        cell5.setColspan(2);
//        cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        table.addCell(cell5);
//        document.add(table);
//        // 关闭文档
//        document.close();
//    }
//}