<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE HTML>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>createUser</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form:form id="form" method="post" modelAttribute="user">
		<div class="header">
			<h2>User</h2>
			<c:if test="${not empty message}">
				<div id="message" class="success">${message}</div>
			</c:if>
			<s:bind path="*">
				<c:if test="${status.error}">
					<div id="message" class="error">User has errors</div>
				</c:if>
			</s:bind>
		</div>
		<legend>User Info</legend>
		<form:label path="name">
			Name 
		</form:label>
		<form:input path="name" />
		<br />
		<form:errors path="name" />

		<form:label path="lastName">
			LastName 
		</form:label>
		<form:input path="lastName" />
		<br />
		<form:errors path="lastName" />
		<form:label path="age">
			Age 
		</form:label>
		<form:input path="age" />
		<br />
		<form:errors path="age" />

		<form:label path="accountId">
			<br />
			Account Id 
		</form:label>
		<form:input path="accountId" />
		<form:errors path="accountId" /><br/>
		<p>
		<button type="submit">Submit</button>
		</p>
	</form:form>
</body>
</html>