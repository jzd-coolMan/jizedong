package cn.wang.util;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel 读取工具类 
 * @author 
 *
 */
public class ExcelUitl {
	private final static String excel2003l=".xls";
	private final static String excel2007l=".xlsx";
	
	//读取文件数据
	public static List<List<Object>> getExcelList(InputStream is,String fileName,Integer...integers) throws Exception{
		List<List<Object>> list = new ArrayList<List<Object>>();
		Workbook workbook = null;
		//文件验证格式
		String suffix =fileName.substring(fileName.lastIndexOf("."));
		if(suffix.equals(excel2003l)) {
			workbook = new HSSFWorkbook(is);
		}else if(suffix.equals(excel2007l)){
			workbook = new XSSFWorkbook(is);
		}else {
			//throw
		}
		Sheet sheet=null;
		Row row = null;
		Cell cell= null;
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			sheet = workbook.getSheetAt(i);
			if(sheet==null) continue;
			//遍历循环sheet中全部行
			for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
				row = sheet.getRow(j);
				if(row==null) continue;
				//循环row中的全部列
				List<Object> li =new ArrayList<Object>();
				for (int k = row.getFirstCellNum(); k <= row.getLastCellNum(); k++) {
					cell = row.getCell(k);
					if(cell!=null) {
						li.add(getCellValue(cell));
					}
				}
				list.add(li);
			}
		}
		return list;
	}
	//单元格数据类型格式化
	private static Object getCellValue(Cell cell) {
		Object value = null;
		DecimalFormat decimalFormat = new DecimalFormat("0");
		DecimalFormat decimalFormat2 = new DecimalFormat("0.00");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			if ("General".equals(cell.getCellStyle().getDataFormatString())) {
				value = decimalFormat.format(cell.getNumericCellValue());
			}else if ("m-d-yy".equals(cell.getCellStyle().getDataFormatString())) {
				value = dateFormat.format(cell.getDateCellValue());
			}else {
				value = decimalFormat2.format(cell.getNumericCellValue());
			}
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			value = cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_BLANK:
			value = "";
			break;
		case Cell.CELL_TYPE_STRING:
			value = cell.getStringCellValue();
			break;
		}
		return value;
	}
}