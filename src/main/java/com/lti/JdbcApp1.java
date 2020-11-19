package com.lti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp1 {
	Connection con;
	Statement st;
	ResultSet rs;

	public JdbcApp1() {

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:OSE", "system", "Oraclepractice1");
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// business logic
	public void getStudentDetails() {
		try {
			rs = st.executeQuery("select * from student");
			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
