<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
<!--
body, input, button, textarea {
	font-size: 28px;
}

tr {
	margin-bottom: 10px
}

textarea {
	height: 200px;
	width: 800px
}
-->
</style>
</head>
<body>

	<h1>Serialized form</h1>
	<form action="IndexController" method="post">
		<input type="text" name="action" value="serialized" hidden>
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td><label>Email</label></td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td><label>Năm sinh</label></td>
				<td><input type="text" name="birth"></td>
			</tr>
			<tr>
				<td><label>Số điện thoại</label></td>
				<td><input type="text" name="phone"></td>
			</tr>
		</table>
		<br>
		<button type="submit">Serialized</button>
	</form>
	<br>
	<c:if test="${serializedObj != null}">
		<textarea><c:out value="${serializedObj}" /></textarea>
	</c:if>
	<hr>
	<h1>Serialized form</h1>
	<form action="IndexController" method="post">
		<input type="text" name="action" value="deserialized" hidden>
		<label>Base64 string</label> <input type="text" name="strBase64"><br>
		<br>
		<button type="submit">Deserialized</button>
	</form>
	<br>
	<c:if test="${deserializedObj != null}">
		<table>
			<tr>
				<td>Username:</td>
				<td>${deserializedObj.username }</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${deserializedObj.email }</td>
			</tr>
			<tr>
				<td>Ngày sinh:</td>
				<td>${deserializedObj.birth }</td>
			</tr>
			<tr>
				<td>Số điện thoại: &nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>${deserializedObj.phone }</td>
			</tr>
		</table>

		
	</c:if>

</body>
</html>