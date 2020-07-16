<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="rightbar">
	<jsp:include page="filters.jsp"></jsp:include>
	<hr>
	<jsp:include page="categories.jsp">
		<jsp:param value="${categories}" name="categories"/>
	</jsp:include>
</div>