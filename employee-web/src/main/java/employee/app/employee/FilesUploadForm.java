package employee.app.employee;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import employee.app.validator.UploadFilesRequired;

public class FilesUploadForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @Valid
    @NotNull
    @NotEmpty
    @UploadFilesRequired
    private List<FileUploadForm> uploadUploadForms;
    
    private String employeeId;
    

    public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public List<FileUploadForm> getUploadUploadForms() {
        return uploadUploadForms;
    }

    public void setUploadUploadForms(List<FileUploadForm> uploadUploadForms) {
        this.uploadUploadForms = uploadUploadForms;
    }
}
