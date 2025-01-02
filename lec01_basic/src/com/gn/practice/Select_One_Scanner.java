package com.gn.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.gn.study.model.vo.Test;

public class Select_One_Scanner {
//		1) 문제
//		사용자로부터 조회하고자 하는 행의 번호 입력받기
//		입력받은 번호를 t_no로 가지고 있는 행의 정보 조회
//		조회한 결과를 Vo에 담아서 출력하기
//		 :전구:
//		수업시간에 만든 것과 출력된 결과가 다릅니다. LocalDateTime을 그대로 사용하지 마시고,
//		날짜 형태를 형변환해서 출력할 수 있도록 toString 메소드를 수정하세요.
//	
//		2) 출력 예시
//		조회하고자 하는 행의 번호를 입력하세요.
//		번호 : 2
//		번호:2, 이름:테스트2, 등록일:2024년05월15일 16시15분50초
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("번호 : ");
		int n = sc.nextInt();
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
			rs = stmt.executeQuery("SELECT t_no ,t_name ,t_date" + " FROM test" + " WHERE t_no = " + n);

			Test t = new Test();
			if (rs.next()) {
				t.setTestNo(rs.getInt("t_no"));
				t.setTestName(rs.getString("t_name"));
				t.setTestDate(rs.getTimestamp("t_date").toLocalDateTime());
			}
			System.out.println(t);

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
