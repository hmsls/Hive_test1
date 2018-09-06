package com.xxx.Hive_text1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;


public class Test_CRUD {
	private Connection conn;
	
	@Before
	public void init() throws Exception{
		Class.forName("org.apache.hive.jdbc.HiveDriver");
		conn = DriverManager.getConnection("jdbc:hive2://192.168.174.128:10000/test1","lishuai","123456");
	}
	
	@Test
	public void create() throws Exception{
		PreparedStatement ppst = conn.prepareStatement("create table test1.users4(id int,lishuai123 string,age int)");
		ppst.execute();
		ppst.close();
		conn.close();
		System.out.println("over");
	}
	
	@Test
	public void batchInsert() throws SQLException{
		PreparedStatement ppst = conn.prepareStatement("insert into hive1.users(id,name,age) values(?,?,?)");
		ppst.setInt(1, 1);
		ppst.setString(2, "tom");
		ppst.setInt(3, 11);
		
		ppst.setInt(1, 2);
		ppst.setString(2, "tom2");
		ppst.setInt(3, 12);
		
		ppst.setInt(1, 3);
		ppst.setString(2, "tom3");
		ppst.setInt(3, 13);
		
		ppst.executeUpdate();
		ppst.close();
		conn.close();
		System.out.println("over");
	}
	
	@Test
	public void count() throws Exception{
		PreparedStatement ppst = conn.prepareStatement("select count(*) from hive1.users");
		ResultSet rs = ppst.executeQuery();
		rs.next();
		System.out.println(rs.getInt(1));
		ppst.close();
		conn.close();
		System.out.println("over");
	}
	@Test
	public void droptable() throws Exception{
		PreparedStatement ppst = conn.prepareStatement("drop table test1.users4");
		ppst.execute();
		ppst.close();
		conn.close();
		System.out.println("over");
		
	}
}
