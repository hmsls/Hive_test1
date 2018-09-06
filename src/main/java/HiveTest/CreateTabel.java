package HiveTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import AutoCreateTable.ReadFields;
/*
 * 建表是，字段顺序有影响吗？
 */
public class CreateTabel {
	private static String driveName = "org.apache.hive.jdbc.HiveDriver";
	private static Connection conn;
	private static PreparedStatement ppst;
	
	public static void main(String[] args) {
//		String url = "jdbc:hive2://192.168.174.128:10000/test1";
//		String name = "lishuai";
//		String passwd = "123456";
		String url = "jdbc:hive2://60.24.64.142:10000/lishuai";
		String name = "";
		String passwd = "";
		try {
			conn = DriverManager.getConnection(url,name,passwd);
//			String sql = "create table if not exists "+ args[0] +"(" + getFields(ReadFields.context()) + ")" 
//					+ " comment 'employee details' " 
//					+ " ROW FORMAT DELIMITED "
//					+ " FIELDS TERMINATED BY '\t' " 
//					+ " LINES TERMINATED BY '\n' " 
//					+ " STORED AS TEXTFILE " ;
//			ppst = conn.prepareStatement(sql);
//			ppst.execute();
//			ppst.close();
//			conn.close();
//			System.out.println("建表完成");
			String sql = "create table test1(id int,name string)";
			ppst = conn.prepareStatement(sql);
			ppst.execute();
			ppst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getFields(Map<String,String> map){
		StringBuffer sb = new StringBuffer();
		Set<Entry<String,String>> entry = map.entrySet();
		Iterator<Entry<String,String>> it = entry.iterator();
		while(it.hasNext()){
			Entry<String,String> ent = it.next();
			String fie = ent.getKey();
			String val = ent.getValue();
			sb.append(fie+" "+val+",");
		}
		String ssb = sb.substring(0, sb.length()-1);
		String text = ssb.toString();
		return text;
	}
}
