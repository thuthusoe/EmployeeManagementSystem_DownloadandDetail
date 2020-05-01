package employee.domain.model;

public class Employee {

	private static final long serialVersionUID = 1L;
	
	private String employeeId;

	private String employeeName;

	private String birthdate;
	
	private String gender;
	
	private String maritalStatus;
	
	private String levelName;
	
	private String departmentName;
	
	private String joinDate;
	
	private String positionName;
	
	private String email;
	
	private String phone;
	
	private String levelId;
	
	private String departmentId;
	
	private String positionId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getLevelId() {
		return levelId;
	}

	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getPositionId() {
		return positionId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", birthdate=" + birthdate
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus + ", levelName=" + levelName
				+ ", departmentName=" + departmentName + ", joinDate=" + joinDate + ", positionName=" + positionName
				+ ", email=" + email + ", phone=" + phone + ", levelId=" + levelId + ", departmentId=" + departmentId
				+ ", positionId=" + positionId + "]";
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	
}
