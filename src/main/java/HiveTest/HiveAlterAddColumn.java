package HiveTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveAlterAddColumn {
	private static String driveName = "org.apache.hive.jdbc.HiveDriver";
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.174.128:10000/test1","lishuai","123456");
			String sql = "alter table employee rename to emp";
			Statement s = conn.createStatement();
			s.execute("alter table emp add columns ( dept String comment 'Department name')");
			s.close();
			s.close();
			System.out.println("add column successful.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
