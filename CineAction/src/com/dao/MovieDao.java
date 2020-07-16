package com.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.entity.Movie;
import java.sql.*;

public class MovieDao {
	//ArrayList<Movie> movies;
	private int count = 1;

	public ArrayList getMoviesByParameter(Map<String, String> params) {

		ArrayList<Movie> movies = new ArrayList<>();
		
		try {

			Connection conn = ConnectionManager.getConnection();
			String query = "select * from movie where (? is NULL OR name=?) AND (? is NULL OR directorId=?) AND (? is NULL OR categoryId=?) AND (? is NULL OR year=?)";

			PreparedStatement statement = conn.prepareStatement(query);
			
			params.forEach((k, v) -> {
				try {
					if (v.equals("")) {
						statement.setNull(count++, java.sql.Types.NULL);
						statement.setNull(count++, java.sql.Types.NULL);
					}else if(k.equals("name")) {
						statement.setString(count++, v);
						statement.setString(count++, v);
					}
					else {
						statement.setInt(count++, Integer.valueOf(v));
						statement.setInt(count++, Integer.valueOf(v));
						}						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int movieId = rs.getInt("id");
				String name = rs.getString("name");
				int year = rs.getInt("year");

				Movie movie = new Movie(movieId, name, year);

				movies.add(movie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return movies;
	}
	
	public ArrayList getAllMovies() {

		ArrayList<Movie> movies = new ArrayList<>();
		try {

			Connection conn = ConnectionManager.getConnection();

			String query = "select * from movie";

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {

				int movieId = rs.getInt("id");
				String name = rs.getString("name");
				int year = rs.getInt("year");

				Movie movie = new Movie(movieId, name, year);

				movies.add(movie);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return movies;
	}
	
	public Movie getMovieDetails(int id) {


		Movie movie = new Movie();
		try {

			Connection conn = ConnectionManager.getConnection();

			String query = "select * from movie where id=?";

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int movieId = rs.getInt("id");
				String name = rs.getString("name");
				int year = rs.getInt("year");

				movie = new Movie(movieId, name, year);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return movie;
	}

	public ArrayList getMoviesByCategory(int categoryId) {
		ArrayList<Movie> movies = new ArrayList<>();
		try {

			Connection conn = ConnectionManager.getConnection();
			String query = "select * from movie where categoryId=?";

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, categoryId);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int movieId = rs.getInt("id");
				String name = rs.getString("name");
				int year = rs.getInt("year");

				Movie movie = new Movie(movieId, name, year);

				movies.add(movie);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return movies;
	}

	public ArrayList getMoviesByDirector(int directorId) {
		ArrayList<Movie> movies = new ArrayList<>();
		try {

			Connection conn = ConnectionManager.getConnection();
			String query = "select * from movie where directorId=?";

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, directorId);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int movieId = rs.getInt("id");
				String name = rs.getString("name");
				int year = rs.getInt("year");

				Movie movie = new Movie(movieId, name, year);

				movies.add(movie);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return movies;
	}
	
	public ArrayList getMoviesByName(String movieName) {
		ArrayList<Movie> movies = new ArrayList<>();
		try {

			Connection conn = ConnectionManager.getConnection();
			String query = "select * from movie where name=?";

			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, movieName);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int movieId = rs.getInt("id");
				String name = rs.getString("name");
				int year = rs.getInt("year");

				Movie movie = new Movie(movieId, name, year);

				movies.add(movie);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return movies;
	}
}
