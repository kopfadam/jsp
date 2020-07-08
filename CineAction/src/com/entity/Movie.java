package com.entity;

public class Movie {
	private int id;
	private int year;
	private String name;
	private Category category;
	private Director director;

	
	
	public Movie() {
		
	}
	
	public Movie (String name){
		this.name = name;
	}

	public Movie(int id, String name, Category category, Director director,int year) {
		super();
		this.id = id;
		this.year = year;
		this.name = name;
		this.category = category;
		this.director = director;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}
	
	
}
