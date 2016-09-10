package com.kanper.service.impl;

import java.util.Calendar;
import java.util.Map;

import com.kanper.bean.EmployeeBean;
import com.kanper.bean.MailSenderInfoBean;
import com.kanper.service.ISendEmailService;
import com.kanper.utils.HtmlUtil;
import com.kanper.utils.SimpleMailSendUtil;

public class SendEmailServiceImpl implements ISendEmailService {

	@Override
	public void sendEmailtoEmployees(Map<Integer, EmployeeBean> map) {
		MailSenderInfoBean bean = new MailSenderInfoBean();
		Calendar now = Calendar.getInstance();
		bean.setMailServerHost("smtp.163.com");
		bean.setMailServerPort("25");
		bean.setValidate(true);
		bean.setUserName("kangpeng82651204@163.com");
		bean.setPassword("kp890318");// 您的邮箱密码
		bean.setFromAddress("kangpeng82651204@163.com");
		for (EmployeeBean e : map.values()) {
			bean.setToAddress(e.getEmployeeEmail());
			bean.setSubject(e.getEmployeeName() + "的" + (now.get(Calendar.MONTH) + 1) + "月工资邮件");
			bean.setContent(HtmlUtil.changeEmployeeToHtml(e));
			SimpleMailSendUtil.sendHtmlMail(bean);
		}
	}

}
