package employee.domain.service.employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.SystemException;

import employee.domain.model.UploadConfig;
import employee.domain.model.UploadFileIdGenerator;

@Transactional
@Service
public class UploadServiceImpl implements UploadService {

    @Inject
    private UploadConfig uploadConfig;

    @Inject
    private UploadFileIdGenerator uploadFileIdGenerator;

    @Override
    public UploadFileInfo saveFile(String uploadTmpFileId, String fileName, String description) {
    	String folderName = "employee_"+ fileName;
    	String fileId = fileName;
    	 Path path = Paths.get(uploadConfig.getUploadTmpDir() + "\\" + folderName + "\\");
         if (!Files.exists(path)) {
             try {
                 Files.createDirectories(path);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
        
       //String fileId = uploadFileIdGenerator.generate();
        File uploadFile = new File(uploadConfig.getUploadSaveDir()+ "\\" + folderName + "\\", fileId);
        File uploadTmpFile = new File(uploadConfig.getUploadTmpDir()+ "\\" + folderName + "\\", uploadTmpFileId);
        
        try {
            FileUtils.moveFile(uploadTmpFile, uploadFile);
        } catch (IOException e) {
            throw new SystemException("e.xx.fw.9003", e);
        }
        return new UploadFileInfo(fileId, fileName, description);
    }

    @Override
    public UploadFileInfo saveFile(UploadFileInfo uploadTmpFileInfo) {
        return saveFile(uploadTmpFileInfo.getFileId(), uploadTmpFileInfo.getFileName(),
                uploadTmpFileInfo.getDescription());
    }

    @Override
    public List<UploadFileInfo> saveFiles(List<UploadFileInfo> uploadTmpFileInfos) {
        List<UploadFileInfo> savedUploadFiles = new ArrayList<UploadFileInfo>();
        for (UploadFileInfo uploadTmpFileInfo : uploadTmpFileInfos) {
            savedUploadFiles.add(saveFile(uploadTmpFileInfo));
        }
        return savedUploadFiles;
    }

}
