package employee.app.employee;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import employee.app.validator.UploadFileMaxSize;
import employee.app.validator.UploadFileNameMaxLength;
import employee.app.validator.UploadFileNotEmpty;
import employee.app.validator.UploadFileRequired;

public class FileUploadForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @UploadFileRequired(groups = { SingleFileUpload.class })
    @UploadFileNotEmpty(groups = { FileUpload.class })
    @UploadFileMaxSize(groups = { FileUpload.class })
    @UploadFileNameMaxLength(groups = { FileUpload.class })
    private MultipartFile file;

    @NotNull
    @Size(max = 100)
    private String description;

    @NotNull(groups = Upload.class)
    @Size(max = 256, groups = Upload.class)
    private String fileName;

    @NotNull(groups = { Upload.class, DeleteUploadFile.class })
    private String fileId;
    
    private String uploadTemporaryFileId;
    
    private MultipartFile image;
    
    private String employeeId;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }
    

    public String getUploadTemporaryFileId() {
		return uploadTemporaryFileId;
	}

	public void setUploadTemporaryFileId(String uploadTemporaryFileId) {
		this.uploadTemporaryFileId = uploadTemporaryFileId;
	}


	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}


	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	public static interface SingleFileUpload {
    }

    public static interface FileUpload {
    }

    public static interface Upload {
    }

    public static interface DeleteUploadFile {
    }

	public Object getUploadUploadForms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "FileUploadForm [file=" + file + ", description=" + description + ", fileName=" + fileName + ", fileId="
				+ fileId + ", uploadTemporaryFileId=" + uploadTemporaryFileId + ", image=" + image + ", employeeId="
				+ employeeId + "]";
	}
	

}