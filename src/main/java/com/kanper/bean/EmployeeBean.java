package com.kanper.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeBean {
	/**
	 * 员工姓名
	 */
	private String employeeName;
	/**
	 * 带班费
	 */
	private double leadFee;
	/**
	 * 计件工资
	 */
	private double pieceWage;
	/**
	 * 事假/加班
	 */
	private double absentDay;
	/**
	 * 工伤费
	 */
	private double injuryFee;
	/**
	 * 补焊费
	 */
	private double weldFee;
	/**
	 * 保险费
	 */
	private double insureFee;
	/**
	 * 基本工资
	 */
	private double baseWage;
	/**
	 * 个人所得税
	 */
	private double revenueFee;
	/**
	 * 实发工资
	 */
	private double realityWage;
	/**
	 * 员工邮箱
	 */
	private String employeeEmail;

}
