<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="com.dao.MovieDao"%>
<%@ page import="com.entity.Movie"%>
<%@ page import="java.util.ArrayList"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="movies">
	<c:if test="${movies_filter.size() > 0}">
	
		<c:forEach items="${movies_filter}" var="movie">
			<a href="details?id=${movie.id}">${movie.name}</a>
			</br>
		</c:forEach>
	</c:if>

	<c:if test="${movies_filter.size() == 0}">
		<h2>No result found</h2>
	</c:if>
</div>