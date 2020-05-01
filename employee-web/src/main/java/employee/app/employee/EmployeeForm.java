package employee.app.employee;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeForm {
	public static interface EmployeeCreate {
    };

    public static interface EmployeeDelete {
    }

    private static final long serialVersionUID = 1L;

    @NotNull(groups = { EmployeeCreate.class, EmployeeDelete.class })
    @Size(min = 1, max = 30, groups = { EmployeeCreate.class })
    private String employeeId;
    
    @NotNull(groups = { EmployeeCreate.class, EmployeeDelete.class })
    private String employeeName;
    
    private String birthdate;
    
    private String gender;
    
    private String maritalStatus;
    
    private String levelId;
    
    private String departmentId;
    
    private String joinDate;
    
    private String positionId;
    
    private String email;
    
    private String phone;
    
    private String levelName;
    
    private String departmentName;
    
    private String positionName;
    
    private String searchCondition;

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

	public void setPositionId(String positionId) {
		this.positionId = positionId;
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
	
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	@Override
	public String toString() {
		return "EmployeeForm [employeeId=" + employeeId + ", employeeName=" + employeeName + ", birthdate=" + birthdate
				+ ", gender=" + gender + ", maritalStatus=" + maritalStatus + ", levelId=" + levelId + ", departmentId="
				+ departmentId + ", joinDate=" + joinDate + ", positionId=" + positionId + ", email=" + email
				+ ", phone=" + phone + ", levelName=" + levelName + ", departmentName=" + departmentName
				+ ", positionName=" + positionName + "]";
	}

}
