package com.gn.study.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class E_Insert_Transaction {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, id, pw);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String str = "테스트윽";
			String sql1 = "SELECT COUNT(*) FROM test WHERE t_name = '" + str + "'";
			rs = stmt.executeQuery(sql1);
			int cnt = 0;
			if (rs.next()) {
				cnt = rs.getInt(1);
			}
			System.out.println(cnt);
			if (cnt == 0) {
				String sql2 = "INSERT INTO test(t_name) VALUES ('" + str + "')";
				cnt = stmt.executeUpdate(sql2);
				if (cnt > 0) {
					System.out.println("성공");
				} else {
					System.out.println("실패");
				}
			} else {
				System.out.println("이미 존재하는 이름입니다.");
			}
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
