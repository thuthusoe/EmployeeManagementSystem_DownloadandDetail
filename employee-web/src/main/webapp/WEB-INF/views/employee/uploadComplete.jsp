<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>File Upload Screen</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/common/styles.css">
</head>
<body>
	<div id="wrapper">

		<%-- screen name --%>
		<h1>Employee Details Screen</h1>
		<%-- global message area --%>
		<t:messagesPanel />
		<c:forEach items="${uploadFileInfoList}" var="uploadFileInfoList"
			varStatus="status">
			<%-- uploaded file information --%>
        Download ${f:h(uploadFileInfoList.description)} : 
        <a target="${uploadFileInfoList.fileId}"
				href="${pageContext.request.contextPath}/employee/download?employeeId=${f:u(employeeId)}&fileId=${f:u(uploadFileInfoList.fileId)}">${f:h(uploadFileInfoList.fileName)}</a>

			<br>
		</c:forEach>
	</div>

	<c:forEach items="${page.content}" var="employee" varStatus="status">
		<table>
			<tr>
				<td>Employee ID</td>
				<td>${employee.employeeId}</td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td>${employee.employeeName}</td>
			</tr>
			<tr>
				<td>Birthday (mm/dd/yyyy):</td>
				<td>${employee.birthdate}</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>${employee.gender}</td>
			</tr>
			<tr>
				<td>Marital Status</td>
				<td>${employee.maritalStatus}</td>
			</tr>
			<tr>
				<td>Japanese Level</td>
				<td>${employee.levelName}</td>
			</tr>
			<tr>
				<td>Department</td>
				<td>${employee.departmentName}</td>
			</tr>
			<tr>
				<td>Join Date (mm/dd/yyyy):</td>
				<td>${employee.joinDate}</td>
			</tr>
			<tr>
				<td>Position</td>
				<td>${employee.positionName}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${employee.email}</td>
			</tr>
			<tr>
				<td>Phone No.</td>
				<td>${employee.phone}</td>
			</tr>
		</table>
	</c:forEach>

	<div id="wrapper" style="text-align: center;">
		<form:form action="${pageContext.request.contextPath}/employee">
			<button type="submit">Back</button>
		</form:form>
	</div>
</body>
</html>
