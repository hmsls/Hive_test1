package HiveTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DropDatabase {
	private static String driveName = "org.apache.hive.jdbc.HiveDriver";
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.174.128:10000/test5","lishuai","123456");
			String sql = "drop database if EXISTS test5";
			PreparedStatement ppst = conn.prepareStatement(sql);
			ppst.execute();
			ppst.close();
			conn.close();
			System.out.println("Drop database successful.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
