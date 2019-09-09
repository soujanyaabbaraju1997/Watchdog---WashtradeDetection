package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private Connection openConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DRIVER LOADED SUCCESSFULLY");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "group8", "trade");
			System.out.println("CONNECTION OBTAINED");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}

		return conn;
	}

	public String dologin(String username, String password) {
		String name = "no_user";
		String SQL_LOGIN = "select username, password from users where username=? and password=?";
		try (Connection connection = openConnection(); PreparedStatement ps = connection.prepareStatement(SQL_LOGIN);) {

			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet set = ps.executeQuery();
			while (set.next()) {
				name = set.getString(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return name;

	}

}
