package com.gn.study.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class D_Insert {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();
//			String sql = "INSERT INTO test(t_name) VALUES('테스트4')";
			String sql = "INSERT INTO test " + "VALUES(5,'테스트5',NOW())";
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
