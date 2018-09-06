package ChengePartition;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.metastore.api.Schema;
import org.apache.hadoop.hive.metastore.api.TableStatsRequest;

public class GetTableInfo {
	private static String tableName;
	private static PreparedStatement ppst;

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		ReadTableFromExcel rtfe = new ReadTableFromExcel();
		StringBuffer sb = new StringBuffer();
		try {
			// hive
			 Class.forName("org.apache.hive.jdbc.HiveDriver");
			 String url = "jdbc:hive2://192.168.174.128:10000/test1";
			 String name = "lishuai";
			 String passwd = "123456";
			 Connection conn = DriverManager.getConnection(url,name,passwd);

			// mysql
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/mysql";
//			String name = "root";
//			String passwd = "123456";
//			Connection conn = DriverManager.getConnection(url, name, passwd);

			// 根据表名查表信息
			list = rtfe.getTableName();
			Iterator it = list.iterator();
			// GetTableInfo.getFileInfo();
			while (it.hasNext()) {
				tableName = (String) it.next();

				String sqll = "select * from " + tableName;
				Statement s = conn.createStatement();
				DatabaseMetaData dmd = conn.getMetaData();
				ResultSet rs = (ResultSet) s.executeQuery(sqll);
				// 得到数据
//				while (rs.next()) {
//					int ids = rs.getInt("id");
//					String names = rs.getString("name");
//					System.out.println(ids + names);
//				}

				// 得到表结构中字段的信息(sql中，java自带，非hive中)
//				ResultSetMetaData rsmd = rs.getMetaData();
//				for (int i = 0; i < rsmd.getColumnCount(); i++) {
//					String javaLeiXing = rsmd.getColumnClassName(i + 1);
//					String DBType = rsmd.getColumnTypeName(i + 1);
//					String fieldName = rsmd.getColumnName(i + 1);
//					int fieldLength = rsmd.getColumnDisplaySize(i + 1);
//					System.out.println(javaLeiXing + "--" + DBType + "--"
//							+ fieldName + "--" + fieldLength);
//					sb.append(fieldName + ",");
//				}

				System.out.println("-----------");
				
				long tableSize=getFileInfo(tableName);
				System.out.println(tableSize);
				
				System.out.println("-----------");
//				
//				Schema sa = new Schema();
//				List<FieldSchema> fsas = sa.getFieldSchemas();
//				Iterator<FieldSchema> itFsa = fsas.iterator();
//				while(itFsa.hasNext()){
//					FieldSchema fsa  = itFsa.next();
//					String fieldName = fsa.getName();
//					System.out.println(fieldName);
//				}
				System.out.println("-----------");
				
				TableStatsRequest rsr = new TableStatsRequest("test1","h_kl_kup_scen111",null);
				List<String> colNames = rsr.getColNames();
				Iterator<String> cn = colNames.iterator();
				while(cn.hasNext()){
					String cName = cn.next();
					System.out.println(cName);
				}
			}
//			while (it.hasNext()) {
//				tableName = (String) it.next();
//
//				long tableSize = getFileInfo(tableName);
//				if (tableSize > 1024 * 1024 * 1024) {
//					// 改表名
//					String sql = "alter table " + tableName + " rename to "
//							+ tableName + "_old";
//					System.out.println(sql);
//					ppst = conn.prepareStatement(sql);
//					ppst.execute();
//					System.out.println("改表名完成");
//					System.out.println("-----------");
//					// 建表
//					String fieldsText = sb.toString().substring(0,
//							sb.length() - 1);
//					String createSql = " CREATE  TABLE " + tableName + "("
//							+ fieldsText + ")" + "clustered by (" + "mertid"
//							+ ")  into 5 buckets stored as  orc "
//							+ "tblproperties(" + "\"transactional\"" + "="
//							+ "\"true\"" + ")";
//					ppst = conn.prepareStatement(createSql);
//					ppst.execute();
//					System.out.println("建表完成");
//					System.out.println("-----------");
//				}
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static long getFileInfo(String tableName) {
		Configuration conf = new Configuration();
		long length = 0;
		try {
			FileSystem fs = FileSystem.get(conf);
			//如果没有加"/datadt=1/000004_0"，则得到的文件大小为0，加了后为20
			FileStatus fileStatus = fs.getFileStatus(new Path(
					"/user/hive/warehouse/test1.db/" + tableName+"/datadt=1/000004_0"));
			length = fileStatus.getLen();
			System.out.println(length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return length;
	}
}
