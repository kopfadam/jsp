<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="categories">
	<span style="color: red;">Categories</span>
	</br>
	<c:forEach items="${categories}" var="category">
		<a href="movies?categoryId=${category.name}">${category.name}</a>
		</br>
	</c:forEach>
</div>