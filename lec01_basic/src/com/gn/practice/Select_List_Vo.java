package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Select_List_Vo {
//	1) 문제
//	Test 테이블에 있는 모든 정보 조회
//	조회 결과를 List<Test>에 담기
//	조회 결과 출력해보기
//	2) 출력 예시
//	번호:1, 이름:테스트1, 등록일:2025-01-02 14:20:56
//	번호:2, 이름:테스트2, 등록일:2025-01-02 14:20:56
//	번호:3, 이름:테스트3, 등록일:2025-01-02 14:20:56
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String ur1 = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
			String id = "scott";
			String pwd = "tiger";
			conn = DriverManager.getConnection(ur1, id, pwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT t_no, t_name, t_date FROM test");

			List<Map<String, Object>> Test = new ArrayList<Map<String, Object>>();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("번호:", rs.getInt("t_no"));
				map.put("이름:", rs.getString("t_name"));
				map.put("등록일:", rs.getTimestamp("t_date"));
				Test.add(map);
			}
			if (Test.isEmpty()) {
				System.out.println("조회된 결과가 없습니다");
			} else {
				for (Map<String, Object> t : Test) {
					System.out.println(t);
				}
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
	}
}
