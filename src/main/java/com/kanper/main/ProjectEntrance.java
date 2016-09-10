package com.kanper.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.kanper.bean.EmployeeBean;
import com.kanper.service.IReadExcelService;
import com.kanper.service.ISendEmailService;
import com.kanper.service.impl.ReadExcelServiceImpl;
import com.kanper.service.impl.SendEmailServiceImpl;

public class ProjectEntrance {
	public static void main(String[] args) {
		InputStream in = null;
		try {
			in = new FileInputStream("C:\\Users\\kangpeng1\\Desktop\\2016-7月.xls");
			IReadExcelService readExcelService = new ReadExcelServiceImpl();
			ISendEmailService sendEmailService = new SendEmailServiceImpl();
			Map<Integer, EmployeeBean> map = readExcelService.readEmployeesFromExcel(in);
			sendEmailService.sendEmailtoEmployees(map);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
