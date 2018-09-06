package ChengePartition;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadTableFromExcel {
	private static List<String> list = null;
	public static List<String> getTableName() {
		list = new ArrayList<String>();
		File excelFile = new File("D:\\JavaPractice\\Maven\\Hive_Test1\\partition1.xls");
		try {
			InputStream is = new FileInputStream(excelFile);
			
			Workbook wk = Workbook.getWorkbook(is);
			Sheet sheet = wk.getSheet("Sheet2");
			Cell[] tbNameCells = sheet.getColumn(0);
//			Cell[] tbSize = sheet.getColumn(1);
//			int rowsNum = sheet.getRows();
//			for(int i = 0;i<=rowsNum;i++){
//				Cell[] cell = sheet.getRow(1);
//				for(Cell c:cell){
//					String text = c.getContents();
//					System.out.println(text);
//				}
//			}
			for(Cell c:tbNameCells){
				String tableName = c.getContents();
				list.add(tableName);
			}
//			
			Iterator<String> it = list.iterator();
			while(it.hasNext()){
				String name = it.next();
				System.out.println(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
