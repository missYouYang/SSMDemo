package com.lz.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
   * 项目名            SSMDemo
   * 包名                com.lz.test
   * 文件名            fileStu.java
   * 创建时间        2019年9月2日 上午11:38:13
 *
 *@author  孙阳阳
   * 描述：file 类练习
 * 
 */
public class fileStu {
	
	public static void main(String[] args) throws IOException {
		
		FileReader read = new FileReader("D:\\file\\1.txt");
		
		int len = 0;
		char[] c = new char[1024];
		while((len = read.read(c)) != -1) {
			
			System.out.println(new String(c));
		}
	}
	
	
}
