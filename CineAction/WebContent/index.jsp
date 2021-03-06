<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="com.dao.MovieDao"%>
<%@ page import="com.entity.Movie"%>
<%@ page import="com.dao.CategoryDao"%>
<%@ page import="com.entity.Category"%>
<%@ page import="java.util.ArrayList"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%
ArrayList<Category> categories = CategoryDao.getAllCategories();
request.getServletContext().setAttribute("categories", categories);
ArrayList<Movie> allMovies = new MovieDao().getAllMovies();
request.setAttribute("movies", allMovies);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<div id="header"><jsp:include
			page="/WEB-INF/Resources/header.jsp" /></div>
	<div id="container">
		<jsp:include page="/WEB-INF/Resources/movies_all.jsp">
			<jsp:param value="${allMovies}" name="movies" />
		</jsp:include>
		<jsp:include page="/WEB-INF/Resources/rightbar.jsp">
			<jsp:param value="${categories}" name="categories" />
		</jsp:include>
	</div>
	<div id="footer"><jsp:include
			page="/WEB-INF/Resources/footer.jsp" /></div>

</body>
</html>