<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="filters">
	<span style="color: red;">Filters</span>
	<form action="movies" method="get">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Director</td>
				<td>
					<!-- <input type="text" name="directorId" />  --> 
					<select name="directorId" id="directors">
						<option value="">--Select a director--</option>
						<option value="Martin Scorsase">Martin Scorsase</option>
						<option value="Steven Spielberg">Steven Spielberg</option>
						<option value="Quentin Tarantino">Quentin Tarantino</option>
						<option value="Francis Ford Cappola">Francis Ford Cappola</option>
						<option value="Woody Allen">Woody Allen</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Category</td>
				<td>
				<select name="categoryId" id="categories">
						<option value="">--Select a category--</option>
						<option value="Drama">Drama</option>
						<option value="Action">Action</option>
						<option value="Romance">Romance</option>
						<option value="Thriller">Thriller</option>
						<option value="Comedy">Comedy</option>
						<option value="History">History</option>
						<option value="Musical">Musical</option>
						<option value="Animation">Animation</option>
						<option value="Science Fiction">Science Fiction</option>
						<option value="Adventure">Adventure</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Year</td>
				<td><input type="text" name="year" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Search" /></td>
			</tr>
		</table>
	</form>
</div>