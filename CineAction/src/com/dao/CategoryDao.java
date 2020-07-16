package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.entity.Category;


public class CategoryDao {

	public static ArrayList<Category> getAllCategories() {
		ArrayList<Category> categories = new ArrayList<>();
		
		try {
			
			Connection conn = ConnectionManager.getConnection();
			
			String query = "select * from category";
			
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				
				int id= rs.getInt("id");
				String name = rs.getString("name");
			
				Category category = new Category(id,name);
				
				categories.add(category);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return categories;
	}
	
	public int getCategoryId(String name) {
		int id = 0;
		try {

			Connection conn = ConnectionManager.getConnection();

			String query = "select * from category where name=?";

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, name);
			
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				id = rs.getInt("id");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}
}
