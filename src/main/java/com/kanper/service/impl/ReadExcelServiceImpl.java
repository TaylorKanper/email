package com.kanper.service.impl;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.kanper.bean.EmployeeBean;
import com.kanper.service.IReadExcelService;
import com.kanper.utils.ExcelReaderUtil;

public class ReadExcelServiceImpl implements IReadExcelService {

	@Override
	public Map<Integer, EmployeeBean> readEmployeesFromExcel(InputStream in) {
		Map<Integer, EmployeeBean> content = new HashMap<>();
		POIFSFileSystem fs;
		HSSFWorkbook wb;
		HSSFSheet sheet;
		HSSFRow row;
		try {
			fs = new POIFSFileSystem(in);
			wb = new HSSFWorkbook(fs);
			sheet = wb.getSheetAt(0);
			// 得到总行数
			int rowNum = sheet.getLastRowNum();
			row = sheet.getRow(0);
			// 正文内容应该从第二行开始,第一行为表头的标题
			for (int i = 1; i < rowNum; i++) {
				EmployeeBean bean = new EmployeeBean();
				row = sheet.getRow(i);
				bean.setEmployeeName(ExcelReaderUtil.getCellFormatValue(row.getCell(0)).trim());
				bean.setPieceWage(Double.valueOf(ExcelReaderUtil.getCellFormatValue(row.getCell(1)).trim()));
				bean.setLeadFee(Double.valueOf(ExcelReaderUtil.getCellFormatValue(row.getCell(2)).trim()));
				bean.setAbsentDay(Double.valueOf(ExcelReaderUtil.getCellFormatValue(row.getCell(3)).trim()));
				bean.setInjuryFee(Double.valueOf(ExcelReaderUtil.getCellFormatValue(row.getCell(4)).trim()));
				bean.setWeldFee(Double.valueOf(ExcelReaderUtil.getCellFormatValue(row.getCell(5)).trim()));
				bean.setInsureFee(Double.valueOf(ExcelReaderUtil.getCellFormatValue(row.getCell(6)).trim()));
				bean.setBaseWage(Double.valueOf(ExcelReaderUtil.getCellFormatValue(row.getCell(7)).trim()));
				bean.setRevenueFee(Double.valueOf(ExcelReaderUtil.getCellFormatValue(row.getCell(8)).trim()));
				bean.setRealityWage(Double.valueOf(ExcelReaderUtil.getCellFormatValue(row.getCell(9)).trim()));
				bean.setEmployeeEmail(ExcelReaderUtil.getCellFormatValue(row.getCell(10)).trim());
				content.put(i, bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

}
