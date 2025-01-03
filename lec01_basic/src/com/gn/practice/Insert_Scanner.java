package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.gn.study.model.vo.Test;

public class Insert_Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.nextLine();

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
			String sql = "INSERT INTO test(t_name) " + "VALUES('" + name + "')";
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				System.out.println("===== test =====");
				List<Test> list = new ArrayList<Test>();
				String sql1 = "SELECT * FROM TEST WHERE t_name = '" + name + "'";
				rs = stmt.executeQuery(sql1);
				while (rs.next()) {
					Test t = new Test(rs.getInt("t_no"), rs.getString("t_name"),
							rs.getTimestamp("t_date").toLocalDateTime());
					list.add(t);
				}
				System.out.println(list);
			} else {
				System.out.println("실패");
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
			sc.close();
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
