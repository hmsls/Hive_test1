package HiveTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveAlterReplaceColumn {
	private static String driveName = "org.apache.hive.jdbc.HiveDriver";
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.174.128:10000/test1","lishuai","123456");
			Statement s = conn.createStatement();
			s.executeUpdate("alter table emp replace columns(eid int, empid int)");
			s.close();
			s.close();
			System.out.println("replace column successful.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
