package HiveTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HiveAlterRenameTo {
	private static String driveName = "org.apache.hive.jdbc.HiveDriver";
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.174.128:10000/test1","lishuai","123456");
			String sql = "alter table employee rename to emp";
			PreparedStatement ppst = conn.prepareStatement(sql);
			ppst.execute();
			ppst.close();
			conn.close();
			System.out.println("rename table successful.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
