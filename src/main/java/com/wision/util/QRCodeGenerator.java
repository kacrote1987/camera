package com.wision.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QRCodeGenerator {
    //无logo无文字版
    public void simple(){
        String text = "Hello, World!";
        String imagePath = "D:/qrcode.png";
        int QR_CODE_SIZE = 300;

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, QR_CODE_SIZE, QR_CODE_SIZE);
            Path path = FileSystems.getDefault().getPath(imagePath);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    //有文字无logo版
    public void charOnly(){
//        String text = "Hello, World!";
        String text = "https://www.baidu.com";
        int width = 300;
        int height = 300;

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        Graphics2D graphics2D = image.createGraphics();

        // 设置字体和颜色
        graphics2D.setColor(new java.awt.Color(0, 0, 0));
        graphics2D.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 15));

        // 获取要写入的文本的长度，然后计算基线位置
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int fontHeight = fontMetrics.getHeight();
        int textWidth = fontMetrics.stringWidth(text);
        int x = textWidth / 2;
        int y = height - fontHeight - 5;

        // 写入文本
        graphics2D.drawString("31303305002024010001", x, y);
        graphics2D.dispose();

        // 保存图片
        File outputFile = new File("D:/qrcode.png");
        try {
            ImageIO.write(image, "png", outputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //有logo无文字版,黑白logo
    public void logoBlack(){
        String text = "https://www.baidu.com";
        int width = 300;
        int height = 300;
        String logoPath = "D:/logo.png"; // 路径指向你的logo图片
        File file = new File("D:/qrcode.png");

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
        BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
        Graphics2D graphics2D = bufferedImage.createGraphics();

        // 插入Logo
        BufferedImage logoImage = null;
        try {
            logoImage = ImageIO.read(new File(logoPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int logoWidth = 50; // Logo宽度
        int logoHeight = 50; // Logo高度
        int x = (width - logoWidth) / 2;
        int y = (height - logoHeight) / 2;
        graphics2D.drawImage(logoImage, x, y, logoWidth, logoHeight, null);
        graphics2D.dispose();

        // 保存图片
        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //有logo无文字版,彩色logo（无法扫码）
    public void logoColor(){
        String content = "https://www.baidu.com"; // 二维码内容
        String logoPath = "D:/logo.png"; // LOGO图片路径
        File file = new File("D:/qrcode.png"); // 二维码输出路径
        int width = 300; // 二维码宽度
        int height = 300; // 二维码高度

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }

        // 确保LOGO图片的大小合适
        int width1 = bitMatrix.getWidth();
        int height1 = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width1, height1, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        // 插入二维码图片
        graphics2D.drawImage(MatrixToImageWriter.toBufferedImage(bitMatrix), 0, 0, null);
        // 插入LOGO图片
        BufferedImage logoImage = null;
        try {
            logoImage = ImageIO.read(new File(logoPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 缩放LOGO图片
        int logoWidth = width1 / 5;  // Logo宽度  50
        int logoHeight = height1 / 5;  // Logo高度  50
        int x = (width - logoWidth) / 2;
        int y = (height - logoHeight) / 2;
        Image scaledLogoImage = logoImage.getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.drawImage(scaledLogoImage, x, y, null);
        graphics.dispose();

        // 输出到文件
        try {
            ImageIO.write(image, "PNG", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    有logo有文字版,彩色logo
      public void charAndLogoColor(){
        String content = "https://www.baidu.com"; // 二维码扫码后的内容
        String text = "33050200581314000032"; // 二维码展示文字内容
        String logoPath = "src\\main\\resources\\static\\wision\\config\\img\\qrcode_logo.png"; // 二维码展示logo图片
        File file = new File("D:/qrcode.png"); // 二维码输出路径
        int width = 300; // 二维码宽度
        int height = 300; // 二维码高度

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }
        BufferedImage bufferedImage = new BufferedImage(bitMatrix.getWidth(), bitMatrix.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();

        // 插入二维码图片
        graphics2D.drawImage(MatrixToImageWriter.toBufferedImage(bitMatrix), 0, 0, null);
        // 插入LOGO图片
        BufferedImage logoImage = null;
        try {
            logoImage = ImageIO.read(new File(logoPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 缩放LOGO图片
        int logoWidth = 50;  // Logo宽度  50
        int logoHeight = 35;  // Logo高度  35
        int x = (width - logoWidth) / 2;
        int y = (height - logoHeight) / 2;
        Image scaledLogoImage = logoImage.getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH);
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        graphics.drawImage(scaledLogoImage, x, y, null);
        graphics.dispose();

        // 设置字体和颜色
        graphics2D.setColor(new java.awt.Color(0, 0, 0));
        graphics2D.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        // 计获取要写入的文本的长度，然后算基线位置
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int fontHeight = fontMetrics.getHeight();
        int textWidth = fontMetrics.stringWidth(text);
        // 写入文本
        graphics2D.drawString(text, (width-textWidth) / 2, height - fontHeight + 5);
        graphics2D.dispose();

        // 保存图片
        try {
            ImageIO.write(bufferedImage, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}