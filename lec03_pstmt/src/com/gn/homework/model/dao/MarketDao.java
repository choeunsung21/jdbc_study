package com.gn.homework.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gn.homework.model.vo.MarketVo;

public class MarketDao {

	public MarketVo checkId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MarketVo vo = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, user, pw);
			String sql = "SELECT * FROM sm_user WHERE user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MarketVo();
				vo.setUser_id(rs.getString("user_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return vo;
	}

	public int signup(String userId, String userPw, String userName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, user, pw);
			String sql = "INSERT INTO sm_user(user_id ,user_pw ,user_name) " + "VALUES(? ,? ,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);
			pstmt.setString(3, userName);

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public MarketVo checkIdPw(String userId, String userPw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MarketVo vo = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/super_market";
			String user = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, user, pw);
			String sql = "SELECT * FROM sm_user WHERE user_id = ? AND user_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);

			rs = pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return vo;
	}
}
