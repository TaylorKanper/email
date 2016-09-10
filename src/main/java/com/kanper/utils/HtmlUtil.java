package com.kanper.utils;

import java.util.Calendar;

import com.kanper.bean.EmployeeBean;

public class HtmlUtil {
	private HtmlUtil() {
		throw new AssertionError();
	}

	public static String changeEmployeeToHtml(EmployeeBean bean) {
		Calendar now = Calendar.getInstance();
		StringBuffer sb = new StringBuffer();
		sb.append("<style type=text/css>table.gridtable {" + "font-family: verdana,arial,sans-serif;"
				+ "font-size:11px;" + "color:#333333;" + "border-width: 1px;" + "border-color: #666666;"
				+ "border-collapse: collapse;" + "}" + "table.gridtable th {" + "border-width: 1px;" + "padding: 8px;"
				+ "border-style: solid;" + "border-color: #666666;" + "background-color: #dedede;" + "}"
				+ "table.gridtable td {" + "border-width: 1px;" + "padding: 8px;" + "border-style: solid;"
				+ "border-color: #666666;" + "background-color: #ffffff;" + "}" + "</style>");
		sb.append("<div>");
		sb.append("<h4>你好，" + bean.getEmployeeName() + "," + (now.get(Calendar.MONTH) + 1) + "月工资如下</h4>");
		sb.append(
				"<table class='gridtable'><thead><tr><th>姓名</th><th>计件工资</th><th>带班费</th><th>事假/加班</th><th>工伤</th><th>"
						+ "补焊扣款</th><th>扣保险费</th><th>应发工资</th><th>扣个税</th><th>实发工资</th></tr></thead>");
		sb.append("<tbody><tr><td>" + bean.getEmployeeName() + "</td><td>" + bean.getPieceWage() + "</td><td>"
				+ bean.getLeadFee() + "</td><td>" + bean.getAbsentDay() + "</td><td>" + bean.getInjuryFee()
				+ "</td><td>" + bean.getWeldFee() + "</td><td>" + bean.getInsureFee() + "</td><td>" + bean.getBaseWage()
				+ "</td><td>" + bean.getRevenueFee() + "</td><td>" + bean.getRealityWage()
				+ "</td><tr></tbody></table>");
		sb.append("<br>");
		sb.append("<h4>yours 李华<br>");
		sb.append("best wishes!</h4></div>");
		return sb.toString();
	}
}
