package com.gn.study.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.gn.study.model.vo.Member;

public class MemberDao {
	public List<Member> selectMemberAll() {
		// 전체 member 정보 조회 -> List<Member>
		List<Member> list = new ArrayList<Member>();
		// DB에 SQL문 요청
//		MemberDao에 전체 정보 조회 코드 작성
//		MemberMenu에 결과 화면 구성
//		(1) 만약에 list가 비어있다면 -> 조회된 결과가 없습니다.
//		(2) Member 목록 출력
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String ur1 = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(ur1, id, pw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM `member`");

			while (rs.next()) {
				Member m = new Member();
				m.setMemberNo(rs.getInt("m_no"));
				m.setMemberId(rs.getString("m_id"));
				m.setMemberPw(rs.getString("m_pw"));
				m.setMemberName(rs.getString("m_name"));
				m.setMemberEmail(rs.getString("m_email"));
				m.setMemberPhone(rs.getString("m_phone"));
				m.setMemberGender(rs.getString("m_gender"));
				m.setRegDate(LocalDateTime.parse(rs.getString("reg_date"), dtf));
				m.setModDate(LocalDateTime.parse(rs.getString("mod_date"), dtf));

				list.add(m);
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

		return list;
	}

	public int insertMember(Member m) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pwd = "tiger";

			conn = DriverManager.getConnection(url, id, pwd);
			stmt = conn.createStatement();

			String sql = "INSERT INTO member (m_id ,m_pw ,m_name ,m_email ,m_phone ,m_gender)" + " VALUES ('"
					+ m.getMemberId() + "', '" + m.getMemberPw() + "', '" + m.getMemberName() + "', '"
					+ m.getMemberEmail() + "', '" + m.getMemberPhone() + "', '" + m.getMemberGender() + "')";
			result = stmt.executeUpdate(sql);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}