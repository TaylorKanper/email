package com.kanper.service;

import java.util.Map;

import com.kanper.bean.EmployeeBean;

public interface ISendEmailService {
	public void sendEmailtoEmployees(Map<Integer, EmployeeBean> map);
}
