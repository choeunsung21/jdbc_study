package com.gn.study.controller;

import java.sql.Connection;
import java.sql.Statement;

public class G_Delete {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;

		try {

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
