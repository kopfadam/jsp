<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.dao.MovieDao"%>
<%@ page import="com.entity.Movie"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Movies</title>
</head>
<body>
	<c:forEach items="${movies}" var="movie">
		<c:out value="${movie.getName()}"></c:out>
		</br>
	</c:forEach>
</body>
</html>