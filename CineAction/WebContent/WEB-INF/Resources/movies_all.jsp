<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="movies">
	<c:forEach items="${movies}" var="movie">
		<a href="details?id=${movie.id}">${movie.name}</a>
		</br>
	</c:forEach>
</div>