package com.test.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.kanper.utils.ExcelReaderUtil;

public class TestExcel {
	
	public void test() {
		InputStream is = null,is2 = null;
		try {
			// 对读取Excel表格标题测试
			is = new FileInputStream("C:\\Users\\kangpeng1\\Desktop\\2016-7月.xls");
			String[] title = ExcelReaderUtil.readExcelTitle(is);
			for (String s : title) {
				System.out.print(s + " ");
			}
			System.out.println();
			// 对读取Excel表格内容测试
			is2 = new FileInputStream("C:\\Users\\kangpeng1\\Desktop\\2016-7月.xls");
			Map<Integer, String> map = ExcelReaderUtil.readExcelContent(is2);
			for (int i = 1; i <= map.size(); i++) {
				System.out.println(map.get(i));
			}

		} catch (FileNotFoundException e) {
			System.out.println("未找到指定路径的文件!");
			e.printStackTrace();
		} finally {
			try {
				is.close();
				is2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
