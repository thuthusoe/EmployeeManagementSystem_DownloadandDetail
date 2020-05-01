<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
<style>
#login {
	border-radius: 12px;
	background-color: #4CAF50; /* Green */
	border: none;
	color: white;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	margin: 4px 2px;
	cursor: pointer;
	height: 40px;
	width: 100px;
}
</style>    	
</head>
<body>
	<div id="wrapper">
		<h1>
			<a href="${pageContext.request.contextPath}/">Employee Management System</a>
		</h1>
		<h3>Login with Username and Password</h3>

		<!-- (1) -->
		<c:if test="${param.containsKey('error')}">
			<!-- (2) -->
			<t:messagesPanel messagesType="error"
				messagesAttributeName="SPRING_SECURITY_LAST_EXCEPTION" />
		</c:if>

		<!-- (3) -->
		<form:form action="${pageContext.request.contextPath}/login">
			<table>
				<tr>
					<td><label for="username">User ID</label></td>
					<td><input type="text" id="username" name="username"
						value='demo'>(demo)</td>
					<!-- (4) -->
				</tr>
				<tr>
					<td><label for="password">Password</label></td>
					<td><input type="password" id="password" name="password"
						value="demo" />(demo)</td>
					<!-- (5) -->
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input id="login"name="submit" type="submit" value="Login" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>