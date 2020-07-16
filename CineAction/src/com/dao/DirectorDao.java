package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entity.Director;

public class DirectorDao {

	public ArrayList getAllDirectors() {
		ArrayList<Director> directors = new ArrayList<>();

		try {

			Connection conn = ConnectionManager.getConnection();

			String query = "select * from director";

			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");

				Director director = new Director(id, name);

				directors.add(director);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return directors;
	}

	public int getDirectorId(String name) {
		int id = 0;
		try {

			Connection conn = ConnectionManager.getConnection();

			String query = "select * from director where name=?";

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
