package com.xxx.Hive_text1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class CreateDatabase {
	private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	public static void main(String[] args) {
		try {
			Class.forName(driverName);
			Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.174.128:10000/test2","lishuai","123456");
			String sql = "create database test4";
			Statement ss = conn.createStatement();
			ss.execute(sql);
			
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.execute();
			System.out.println("Database userdb created successfully.");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}