package com.xxx.Hive_text1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, Exception
    {
    	Class.forName("org.apache.hive.jdbc.HiveDriver");
    	Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.174.128:10000/hive1","lishuai","123456");
    	PreparedStatement ppst = conn.prepareStatement("select * from test2");
    	ResultSet rs = ppst.executeQuery();
    	while(rs.next()){
    		int id = rs.getInt("id");
    		String name = rs.getString("name");
    		int age = rs.getInt("age");
    		System.out.println(id+":"+name+":"+age);
    	}
    	rs.close();
    	ppst.close();
    	conn.close();
    }
}
