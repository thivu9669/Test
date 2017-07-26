package dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnect {
	static String servername;
	static String port;
	static String db_name;
	static String db_user;
	static String db_pass;

	static {
		servername = "127.0.0.1";
		port = "1433";
		db_name = "sem2_demo";
		db_user = "sa";
		db_pass = "123456";
	}
	public MyConnect() {
		servername = "127.0.0.1";
		port = "1433";
		db_name = "sem2_demo";
		db_user = "sa";
		db_pass = "123456";
	}

	public MyConnect(String server, String port, String db_name, String db_user, String db_pass) {
		this.servername = servername;
		this.port = port;
		this.db_name = db_name;
		this.db_user = db_user;
		this.db_pass = db_pass;
	}

	public static Connection getcn() {
		Connection cn = null;
		try {
			// databse url
			String db_url = "jdbc:sqlserver://" + servername + ":" + port + ";database = " + db_name;

			// load JDBC
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// ket noi database
			cn = DriverManager.getConnection(db_url, db_user, db_pass);
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return cn;
	}
}
