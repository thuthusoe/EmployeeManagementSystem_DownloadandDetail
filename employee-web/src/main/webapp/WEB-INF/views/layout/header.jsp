<div class="header"
	style="text-align: center; background: #e5eCf9; height: 50px;">
	<h1 style="float: left;">
		<a href="${pageContext.request.contextPath}/">Employee Management
			System</a>
	</h1>

	<form:form action="${pageContext.request.contextPath}/logout">
		<button type="submit"
			style="height:40px; width: 75px; float: right;">Logout</button>
	</form:form>
	<form:form action="${pageContext.request.contextPath}/employee">
		<button type="submit"
			style="height:40px; width: 75px; float: right;">Home</button>
	</form:form>
	<form:form action="${pageContext.request.contextPath}/account">
		<button type="submit"
			style="height:40px; width: 75px; float: right;">View
			Account</button>
	</form:form>
</div>