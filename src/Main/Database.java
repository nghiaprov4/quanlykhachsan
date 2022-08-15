package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	public Connection getConnect() throws SQLException {
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyKhachSan10";
		String dbUser = "sa";
		String dbPass = "1234";
		Connection con = DriverManager.getConnection(dbURL, dbUser, dbPass);
		return con;  
	}
}
