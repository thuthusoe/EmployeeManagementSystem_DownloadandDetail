<h2>${screenTitle}</h2>
<div id="employee">
	<t:messagesPanel />

	<form:form action="${pageContext.request.contextPath}/employee/create"
		method="post" modelAttribute="employeeForm">
		<form:hidden path="employeeId" value="${employeeForm.employeeId}" />
		<form:hidden path="employeeName" value="${employeeForm.employeeName}" />
		<form:hidden path="birthdate" value="${employeeForm.birthdate}" />
		<form:hidden path="gender" value="${employeeForm.gender}" />
		<form:hidden path="maritalStatus" value="${employeeForm.maritalStatus}" />
		<form:hidden path="levelId" value="${employeeForm.levelId}" />
		<form:hidden path="departmentId" value="${employeeForm.departmentId}" />
		<form:hidden path="joinDate" value="${employeeForm.joinDate}"/>
		<form:hidden path="positionId" value="${employeeForm.positionId}" />
		<form:hidden path="email" value="${employeeForm.email}" />
		<form:hidden path="phone" value="${employeeForm.phone}" />
		<table>
			<tr>
				<td>Employee ID</td>
				<td>${employeeForm.employeeId}</td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td>${employeeForm.employeeName}</td>
			</tr>
			<tr>
				<td>Birthday (mm/dd/yyyy):</td>
				<td>${employeeForm.birthdate}</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>${employeeForm.gender}</td>
			</tr>
			<tr>
				<td>Marital Status</td>
				<td>${employeeForm.maritalStatus}</td>
			</tr>
			<tr>
				<td>Japanese Level</td>
				<td>${employeeForm.levelName}</td>
			</tr>
			<tr>
				<td>Department</td>
				<td>${employeeForm.departmentName}</td>
			</tr>
			<tr>
				<td>Join Date (mm/dd/yyyy):</td>
				<td>${employeeForm.joinDate}</td>
			</tr>
			<tr>
				<td>Position</td>
				<td>${employeeForm.positionName}</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>${employeeForm.email}</td>
			</tr>
			<tr>
				<td>Phone No.</td>
				<td>${employeeForm.phone}</td>
			</tr>
		</table>

		<form:button>${buttonTitle}</form:button>
	</form:form>
	<form:form action="${pageContext.request.contextPath}/employee/registerRedo" method="post" modelAttribute="employeeForm">
	<form:hidden path="employeeId" value="${employeeForm.employeeId}" />
		<form:hidden path="employeeName" value="${employeeForm.employeeName}" />
		<form:hidden path="birthdate" value="${employeeForm.birthdate}" />
		<form:hidden path="gender" value="${employeeForm.gender}" />
		<form:hidden path="maritalStatus" value="${employeeForm.maritalStatus}" />
		<form:hidden path="levelId" value="${employeeForm.levelId}" />
		<form:hidden path="departmentId" value="${employeeForm.departmentId}" />
		<form:hidden path="joinDate" value="${employeeForm.joinDate}"/>
		<form:hidden path="positionId" value="${employeeForm.positionId}" />
		<form:hidden path="email" value="${employeeForm.email}" />
		<form:hidden path="phone" value="${employeeForm.phone}" />
		<button type="submit" style="background-color: red;">Back</button>
	</form:form>
</div>