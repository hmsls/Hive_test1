package AutoCreateTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CreateTable {
	private static String driveName = "com.mysql.jdbc.Driver";
	private Connection conn ;
	
	private void init(){
		try {
			Class.forName(driveName);
//			String url  = "jdbc:mysql://localhost:3306/mysql";
			String url  = "jdbc:mysql://localhost:3306/mysql";
			String user  = "root";
			String passwd = "123456";
			conn = DriverManager.getConnection(url,user,passwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getFields(Map<String,String> map){
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
	
	private void  create(String name,String fields) throws Exception{
		String sql = "create table "+name+ "(" + fields +")" ; 
		System.out.println(sql);
		PreparedStatement ppst = conn.prepareStatement(sql);
		ppst.execute();
		ppst.close();
		conn.close();
		System.out.println("建表完成");
	}
	
	public static void main(String[] args) {
		CreateTable ct = new CreateTable();
		try {
			Map<String,String> map = ReadFields.context();
			ct.init();
			String fields = ct.getFields(map);
			System.out.println(fields);
			ct.create("libin123",fields);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
