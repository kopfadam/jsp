package com.dao;

import java.util.ArrayList;
import java.util.Arrays;

import com.entity.Movie;

public class MovieDao {
	
	public ArrayList getAllMovies() {
		ArrayList<Movie> movies = new ArrayList<>();
		
		movies.add(new Movie("Saving Private Ryan"));
		movies.add(new Movie("Sunshine"));
		movies.add(new Movie("Once Upon a Time in America"));
		movies.add(new Movie("Saving Private Gokhan"));
		
		return movies;
	}
}
