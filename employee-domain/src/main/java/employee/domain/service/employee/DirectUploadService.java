package employee.domain.service.employee;

import java.io.InputStream;
import java.util.List;

public interface DirectUploadService {

    UploadFileInfo saveFile(InputStream inputStream, String fileName, String description, String employeeId);

    UploadFileInfo saveFile(DirectUploadFileInfo directUploadFileInfo);

    List<UploadFileInfo> saveFiles(List<DirectUploadFileInfo> directUploadFileInfos);
}
