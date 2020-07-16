package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.Movie;
import com.entity.User;
import com.mysql.jdbc.Statement;

public class AuthenticationDao {
	private User user;

	public static boolean checkAlreadyRegistered(User user) {
		boolean isRegistered = true;
		try {

			Connection conn = ConnectionManager.getConnection();
			String query = "SELECT Count(*) FROM user WHERE name = ? AND password = ?";

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());

			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int numberOfRows = rs.getInt(1);
				if (numberOfRows == 1) {			
				} else if(numberOfRows == 0){	
					isRegistered = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isRegistered;

	}
	
	public static int countOfRecords() {
		
		int numberOfRow = 0;
		
		try {

			Connection conn = ConnectionManager.getConnection();
			String query = "select * from user";

			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			

			while (rs.next()) {

				numberOfRow = rs.getRow();
	
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return numberOfRow;
	}
	
	public static int register(User user) {
		Connection conn = ConnectionManager.getConnection();
		String query = "Insert Into user values(?,?,?)";

		PreparedStatement statement;
		int updateResult = 0;
		
		try {
			statement = conn.prepareStatement(query);
			System.out.println("records" + countOfRecords());
			
			statement.setInt(1, countOfRecords()+1);
			statement.setString(2, user.getName());
			statement.setString(3, user.getPassword());
			
			updateResult = statement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updateResult;
		
	}
}
