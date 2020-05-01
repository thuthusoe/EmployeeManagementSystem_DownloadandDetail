package employee.domain.service.employee;

import java.util.List;

public interface UploadService {

    UploadFileInfo saveFile(String uploadTmpFileId, String fileName, String description);

    UploadFileInfo saveFile(UploadFileInfo uploadTmpFileInfo);

    List<UploadFileInfo> saveFiles(List<UploadFileInfo> uploadTmpFileInfos);

}
