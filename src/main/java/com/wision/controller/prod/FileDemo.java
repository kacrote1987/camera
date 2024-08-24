package com.wision.controller.test;
import java.io.*;
public class FileDemo {
	public static void main(String[] args) {
		try {
			// 如果文件不存在，也不会报错,如果已经存在同名文件则无法创建，也不会覆盖同名文件中的内容
			File f1 = new File("D:\\test\\gugu1.txt");
			boolean flag1 = f1.createNewFile();     //使用createNewFile()方法创建一个普通文件
			System.out.println(flag1 ? "文件创建成功" : "文件创建失败");

			//创建一个文件夹           不存在则创建，存在则不创建
			File f2 = new File("D:\\test\\27427\\Desktop\\gugu2");
			boolean flag2 = f2.mkdir();         //使用mkdir()方法创建一个文件夹
			System.out.println(flag2 ? "文件夹创建成功" : "文件夹创建失败");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}