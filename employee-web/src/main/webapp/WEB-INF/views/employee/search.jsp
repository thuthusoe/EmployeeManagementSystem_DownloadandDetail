<!DOCTYPE html>
<html>
<head>
<title>Search Page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
	<h2>Search Page</h2>
	<form:form action="${pageContext.request.contextPath}/employee/findOne"
		method="get" modelAttribute="employeeForm" style="text-align:center">
		<form:input path="searchCondition" />
		<button type="submit">Search</button>
	</form:form>
	<form:form action="${pageContext.request.contextPath}/employee">
		<button type="submit">Find All Employees</button>
	</form:form>
	<form:form
		action="${pageContext.request.contextPath}/employee/register">
		<button type="submit">Register</button>
	</form:form>
		<table>
			<tr>
				<th>Employee Id</th>
				<th>Name</th>
				<th>Join Date</th>
				<th>Department</th>
				<th>Position</th>
				<th>Email</th>
				<th>Ph No.</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${page.content}" var="employee" varStatus="status">
				<tr>
					<td>${employee.employeeId}</td>
					<td>${employee.employeeName}</td>
					<td>${employee.joinDate}</td>
					<td>${employee.departmentName}</td>
					<td>${employee.positionName}</td>
					<td>${employee.email}</td>
					<td>${employee.phone}</td>
					<td>
						<form:form action="${pageContext.request.contextPath}/upload/multiple" method="post"
							modelAttribute="employeeForm" cssStyle="display: inline-block;">
							<form:hidden path="employeeId" value="${employee.employeeId}" />
							<form:button>Upload</form:button>
						</form:form> 
						
						<form:form action="${pageContext.request.contextPath}/employee/edit"
						method="post" modelAttribute="employeeForm"
							cssStyle="display: inline-block;">
							<form:hidden path="employeeId" value="${employee.employeeId}" />
							<form:hidden path="employeeName" value="${employee.employeeName}" />
							<form:hidden path="birthdate" value="${employee.birthdate}" />
							<form:hidden path="gender" value="${employee.gender}" />
							<form:hidden path="maritalStatus" value="${employee.maritalStatus}" />
							<form:hidden path="levelId" value="${employee.levelId}" />
							<form:hidden path="departmentId" value="${employee.departmentId}" />
							<form:hidden path="joinDate" value="${employee.joinDate}"/>
							<form:hidden path="positionId" value="${employee.positionId}" />
							<form:hidden path="email" value="${employee.email}" />
							<form:hidden path="phone" value="${employee.phone}" />
							<form:button>Edit</form:button>
						</form:form> 
						
						<form:form
							action="${pageContext.request.contextPath}/employee/delete"
							method="post" modelAttribute="employeeForm"
							cssStyle="display: inline-block;">
							<form:hidden path="employeeId"
								value="${f:h(employee.employeeId)}" />
							<form:hidden path="employeeName"
								value="${f:h(employee.employeeName)}" />
							<form:button style="background-color: red;">Delete</form:button>
						</form:form>
						</td>
				</tr>
			</c:forEach>
 		</table>
		<div class="container" style="text-align:center">
			<div class="paginationPart">
				<t:pagination page="${page}" outerElementClass="pagination"
					maxDisplayCount="5" criteriaQuery="${f:query(employeeForm)}" />
			</div>
			<div>
				<fmt:formatNumber value="${page.totalElements}" />results
			</div>
			<div>
    			<fmt:formatNumber value="${(page.number * page.size) + 1}" /> -
    			<fmt:formatNumber value="${(page.number * page.size) + page.numberOfElements}" />
			</div>
			<div>${f:h(page.number + 1) }/${f:h(page.totalPages)}Pages
			</div>
		</div>
</body>