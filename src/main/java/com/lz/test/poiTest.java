package com.lz.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.opencsv.CSVWriter;

public class poiTest {
	
	public static void main(String[] args) throws IOException {
		File csv = new File("d:/ljq.csv");
		//设置列头
		String[] strArr = {"姓名","年龄","性别"};
		List slist = new ArrayList<>();
		slist.add("22,3,4");
		slist.add("222,5,6");
		slist.add("33,3,4");
		if (!csv.exists()) {
				csv.createNewFile();
		}
		try {
			CSVWriter writer = new CSVWriter(new OutputStreamWriter(new FileOutputStream(csv), "GBK"),
			CSVWriter.DEFAULT_SEPARATOR, CSVWriter.DEFAULT_QUOTE_CHARACTER);
			writer.writeNext(strArr);
			writer.writeAll(slist);
			writer.flush();
			writer.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
	
	}
}	
