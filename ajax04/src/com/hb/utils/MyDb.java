package com.hb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDb {
	// conn객체 싱글톤 타입으로...
	private static Connection conn;
	private MyDb() {}
	
	public static Connection getConnection() {
		try {
			if(conn==null || conn.isClosed()){
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			}
		} catch (SQLException e) {
			System.out.println("데이터베이스 접속오류");
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc14 확인");
		}
		return conn;
	}
}
