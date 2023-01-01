package com.cnp.util;

	import java.sql.Connection;
	import java.sql.SQLException;

	import javax.naming.InitialContext;
	import javax.naming.NamingException;
	import javax.sql.DataSource;

	public class ConnectionUtil {
		static Connection con;
	public static Connection getConnection() {
		
		try {
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/myds");
		con = dataSource.getConnection();
		}catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	
	}
	}
