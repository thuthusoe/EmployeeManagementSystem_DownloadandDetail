package employee.domain.service.employee;

import java.io.InputStream;
import java.io.Serializable;

public class DirectUploadFileInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private InputStream inputStream;
    private String fileName;
    private String description;
    private String employeeId;

    public DirectUploadFileInfo() {

    }

    public DirectUploadFileInfo(InputStream inputStream, String fileName, String description, String employeeId) {
        this.inputStream = inputStream;
        this.fileName = fileName;
        this.description = description;
        this.employeeId = employeeId;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}
