<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="com.dao.MovieDao"%>
<%@ page import="com.entity.Movie"%>
<%@ page import="com.dao.CategoryDao"%>
<%@ page import="com.entity.Category"%>
<%@ page import="java.util.ArrayList"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cine Action</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<div id="header"><jsp:include
			page="/WEB-INF/Resources/header.jsp" /></div>
	<div id="container">
		<c:if test="${not empty movie_detail}">
			<jsp:include page="/WEB-INF/Resources/details.jsp">
				<jsp:param value="${movie_detail}" name="movie_detail" />
			</jsp:include>
		</c:if>
		<c:if test="${movies_filter != null}">
			<jsp:include page="/WEB-INF/Resources/movies_filtered.jsp">
				<jsp:param value="${movies_filter}" name="movies_filter" />
			</jsp:include>
		</c:if>
		<jsp:include page="/WEB-INF/Resources/rightbar.jsp">
			<jsp:param value="${categories}" name="categories" />
		</jsp:include>
	</div>
	<div id="footer"><jsp:include
			page="/WEB-INF/Resources/footer.jsp" /></div>

</body>
</html>