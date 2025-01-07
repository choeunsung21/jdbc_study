package com.gn.homework.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.gn.homework.model.vo.Menu;

public class MenuDao {

	public int checkId(String userId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Menu m = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String ur1 = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(ur1, id, pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM `member` WHERE m_id = '" + userId + "'");
			if (rs.next()) {
				m = new Menu(rs.getInt("m_no"), rs.getString("m_id"), rs.getString("m_pw"));
			}
		} catch (Exception e) {
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
		return m;
	}

}
