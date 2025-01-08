package com.gn.study.model.service;

import static com.gn.study.common.JDBCTemplate.close;
import static com.gn.study.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.gn.study.model.dao.Dao;
import com.gn.study.model.vo.Car;

// DB에 접속 -> Connection 객체 생성
public class Service {
	private Dao dao = new Dao();

	public int insertCarOne(Car car) {
		Connection conn = getConnection();
		int result = dao.insertCarOne(car, conn);
		close(conn);
		return result;
//		Connection conn = null;
//		int result = 0;
//
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			String url = "jdbc:mariadb://127.0.0.1:3306/jdbc_basic";
//			String user = "scott";
//			String pw = "tiger";
//			conn = DriverManager.getConnection(url, user, pw);
//			result = dao.insertCarOne(car, conn);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}

	public List<Car> selectCarAll() {
		Connection conn = getConnection();
		List<Car> list = dao.selectCarAll(conn);
		close(conn);
		return list;
	}

	public Car selectCarOneByModel(String model) {
		Connection conn = getConnection();
		Car car = dao.selectCarOneByModel(model, conn);
		close(conn);
		return car;
	}

	public Car selectCarOneByNumber(int number) {
		Connection conn = getConnection();
		Car car = dao.selectCarOneByNumber(number, conn);
		close(conn);
		return car;
	}

	public Car selectCarOneByPrice(int price) {
		Connection conn = getConnection();
		Car car = dao.selectCarOneByPrice(price, conn);
		close(conn);
		return car;
	}

	public Car selectCarOneByDate(String date) {
		Connection conn = getConnection();
		Car car = dao.selectCarOneByDate(date, conn);
		close(conn);
		return car;
	}

	public int deleteCarOne(int carNo) {
		Connection conn = getConnection();
		int result = dao.deleteCarOne(carNo, conn);
		close(conn);
		return result;
	}

	public int updateModel(int carNo, Object obj) {
		Connection conn = getConnection();
		int result = dao.updateModel(carNo, obj, conn);
		close(conn);
		return result;
	}

	public int updatePrice(int carNo, Object obj) {
		Connection conn = getConnection();
		int result = dao.updatePrice(carNo, obj, conn);
		close(conn);
		return result;
	}

	public int updateDate(int carNo, Object obj) {
		Connection conn = getConnection();
		int result = dao.updateDate(carNo, obj, conn);
		close(conn);
		return result;
	}

}
