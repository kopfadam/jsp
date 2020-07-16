<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>A</div>
<div>B</div>
<div>C</div>
<div>
	<c:if test="${empty user}">
		<div id="login_area">
			<form action="login" method="post">
				<table>
					<tr>
						<td><input type="text" name="user" /></td>
						<td><input type="password" name="pass" /></td>
						<td><input type="submit" value="Log in" /></td>
					</tr>
					<tr>
					<td>No account!<a href="register" style="color: red;">Sign Up!</a></td>
					<td><a href="index.jsp">Forgot Password!</a></td>
					</tr>
				</table>
			</form>
			<c:if test="${not empty error}">
				<p style="color: red;">${error}</p>

			</c:if>
		</div>
	</c:if>

	<c:if test="${not empty user}">
		<p>Hello, ${user}</p>
		<a href="logout"><input type="button" value="Log out" /></a>
	</c:if>
</div>