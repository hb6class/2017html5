package com.hb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDb {
	// conn��ü �̱��� Ÿ������...
	private static Connection conn;
	private MyDb() {}
	
	public static Connection getConnection() {
		try {
			if(conn==null || conn.isClosed()){
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			}
		} catch (SQLException e) {
			System.out.println("�����ͺ��̽� ���ӿ���");
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc14 Ȯ��");
		}
		return conn;
	}
}
