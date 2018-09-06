package HiveTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTable {
	private static String driveName = "org.apache.hive.jdbc.HiveDriver";
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:hive2://192.168.174.128:10000/test5","lishuai","123456");
			String sql = "insert into h_kl_kup_scen111 partition(datadt = \"1\") "
					+ " (timetm,datetm,profvl,explvl,trigtp,syscod,scensm,scentx,scencd,corpno) "
					+ "  values(\"1\",\"1\",\"1\",\"1\",\"1\",\"1\",\"1\",\"1\",\"1\",\"1\") ;";
			PreparedStatement ppst = conn.prepareStatement(sql);
			ppst.execute();
			ppst.close();
			conn.close();
			System.out.println("insert data into table successful.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
