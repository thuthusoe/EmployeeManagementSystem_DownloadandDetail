<h2>${screenTitle}</h2>
<div id="employeeForm">
	<t:messagesPanel />

	<form:form
		action="${pageContext.request.contextPath}/employee/confirmForm"
		method="post" modelAttribute="employeeForm">
		<table>
			<tr>
				<td>Employee ID</td>
				<td>
					<form:input path="employeeId" value="${employee.employeeId}"/> 
					<form:errors path="employeeId" cssClass="text-error" />
				</td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td>
					<form:input path="employeeName" value="${employee.employeeName}"/> 
					<form:errors path="employeeName" cssClass="text-error" />
				</td>
			</tr>
			<tr>
				<td>Birthday (yyyymmdd):</td>
				<td>
					<form:input path="birthdate" value="${employee.birthdate}"/> 
					<form:errors path="birthdate" cssClass="text-error" />
				</td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<form:radiobutton path="gender" value="M" /> Male 
					<form:radiobutton path="gender" value="F" /> Female 
					<form:errors path="gender" cssClass="text-error" />
				</td>
			</tr>
			<tr>
				<td>Marital Status</td>
				<td>
					<form:radiobutton path="maritalStatus" value="S" /> Single
					<form:radiobutton path="maritalStatus" value="M" /> Married 
					<form:errors path="maritalStatus" cssClass="text-error" />
				</td>
			</tr>
			<tr>
				<td>Japanese Level</td>
				<td>
					<form:select path="levelId">
						<form:option value="" />
						<form:option value="1" label="N1" />
						<form:option value="2" label="N2" />
						<form:option value="3" label="N3" />
						<form:option value="4" label="N4" />
						<form:option value="5" label="N5" />
						<form:option value="6" label="Beginner" />
					</form:select> 
					<form:errors path="levelId" cssClass="text-error" />
				</td>
			</tr>
			<tr>
				<td>Department</td>
				<td>
					<form:select path="departmentId" value="${employee.departmentId}">
						<form:option value="" />
						<form:option value="1" label="System Development" />
						<form:option value="2" label="Infra" />
						<form:option value="3" label="HR" />
						<form:option value="4" label="Finance" />
					</form:select> <form:errors path="departmentId" cssClass="text-error" />
				</td>
			</tr>
			<tr>
				<td>Join Date (yyyymmdd):</td>
				<td>
					<form:input path="joinDate" />
				</td>
			</tr>
			<tr>
				<td>Position</td>
				<td>
					<form:select path="positionId">
						<form:option value="" />
						<form:option value="1" label="JSE" />
						<form:option value="2" label="SE" />
						<form:option value="3" label="SSE" />
						<form:option value="4" label="TL" />
						<form:option value="5" label="PL" />
						<form:option value="6" label="PM" />
						<form:option value="7" label="Junior HR" />
						<form:option value="8" label="Senior HR" />
					</form:select> 
					<form:errors path="positionId" cssClass="text-error" />
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					<form:input path="email" /> 
					<form:errors path="email" cssClass="text-error" />
				</td>
			</tr>
			<tr>
				<td>Phone No.</td>
				<td>
					<form:input path="phone" /> 
					<form:errors path="phone" cssClass="text-error" />
				</td>
			</tr>
		</table>
		<form:button>${buttonTitle}</form:button>
	</form:form>
	
	<form:form action="${pageContext.request.contextPath}/employee">
			<button type="submit" style="background-color: red;">Back</button>
	</form:form>
</div>