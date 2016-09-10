package com.kanper.service;

import java.io.InputStream;
import java.util.Map;

import com.kanper.bean.EmployeeBean;

public interface IReadExcelService {
	public Map<Integer,EmployeeBean> readEmployeesFromExcel(InputStream in);
}
