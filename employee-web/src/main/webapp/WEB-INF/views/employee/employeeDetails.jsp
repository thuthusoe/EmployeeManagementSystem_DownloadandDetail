<h2>${screenTitle}</h2>
<h2>${employeeId}</h2>
<div id="employee">
	<t:messagesPanel />
	Upload File :
<c:forEach items="${uploadFileInfoList}" var="uploadFileInfoList"
			varStatus="status">
			<%-- uploaded file information --%>
        Upload File : <a target="${uploadFileInfoList.fileId}"
				href="${pageContext.request.contextPath}/download/${f:u(uploadFileInfoList.fileId)}">${f:h(uploadFileInfoList.fileName)}</a>
			<br>
        Description : ${f:h(uploadFileInfoList.description)}<br>

			<br>
		</c:forEach>	
	
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
	<%-- <form:form action="${pageContext.request.contextPath}/employee/registerRedo" method="post" modelAttribute="employeeForm">
	<form:hidden path="employeeId" value="${page.employeeId}" />
		<form:hidden path="employeeName" value="${page.employeeName}" />
		<form:hidden path="birthdate" value="${page.birthdate}" />
		<form:hidden path="gender" value="${page.gender}" />
		<form:hidden path="maritalStatus" value="${page.maritalStatus}" />
		<form:hidden path="levelId" value="${page.levelId}" />
		<form:hidden path="departmentId" value="${page.departmentId}" />
		<form:hidden path="joinDate" value="${page.joinDate}"/>
		<form:hidden path="positionId" value="${page.positionId}" />
		<form:hidden path="email" value="${page.email}" />
		<form:hidden path="phone" value="${page.phone}" />
		<button type="submit" style="background-color: red;">Back</button>
	</form:form>  --%>
</div>