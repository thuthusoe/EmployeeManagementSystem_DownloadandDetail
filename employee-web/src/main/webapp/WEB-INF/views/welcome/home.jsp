<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
<style>
</style>
</head>

<sec:authentication property="principal.account" var="account" />

<body>
	<div id="wrapper" style="text-align: center;">
		<form:form action="${pageContext.request.contextPath}/employee">
			<button type="submit">Employee
				Management</button>
		</form:form>
	</div>
</body>
</html>