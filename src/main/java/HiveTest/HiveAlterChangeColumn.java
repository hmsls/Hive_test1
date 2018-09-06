package HiveTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveAlterChangeColumn {
	private static String driveName = "org.apache.hive.jdbc.HiveDriver";
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.174.128:10000/test1","lishuai","123456");
			String sql = "alter table employee rename to emp";
			Statement s = conn.createStatement();
			s.execute("alter table emp change e1name e2name String");
			s.execute("alter table emp change salart salart Double");
			s.close();
			s.close();
			System.out.println("change column successful.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
