package employee.app.employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.message.ResultMessages;

import employee.app.employee.FileUploadForm.FileUpload;
import employee.domain.model.Employee;
import employee.domain.model.Messages;
import employee.domain.model.UploadConfig;
import employee.domain.service.employee.DirectUploadFileInfo;
import employee.domain.service.employee.DirectUploadService;
import employee.domain.service.employee.EmployeeService;
import employee.domain.service.employee.UploadFileInfo;

@RequestMapping("upload/multiple")
@Controller
public class FilesUploadController {

	@Inject
	private DirectUploadService directUploadService;

	@Inject
	private UploadConfig uploadConfig;

	@Inject
	EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET)
	public String uploadFilesForm(EmployeeForm employeeForm, FilesUploadForm form, Model model) {
		System.out.println("EmployeeId is" + employeeForm.getEmployeeId());
		System.out.println("I am here");
		model.addAttribute("employeeId", employeeForm.getEmployeeId());
		return "employee/uploadFiles";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String uploadFiles(@Validated({ FileUpload.class, Default.class }) FilesUploadForm form,
			BindingResult result, RedirectAttributes redirectAttributes, Model model,
			@PageableDefault(size = 10) Pageable pageable) throws IOException {

		String employeeId = form.getEmployeeId();
		String folderName = "employee_" + employeeId;

		Path path = Paths.get(uploadConfig.getUploadSaveDir() + "\\" + folderName + "\\");
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (result.hasErrors()) {
			return "employee/uploadFiles";
		}

		// save files.
		List<DirectUploadFileInfo> uploadTmpFiles = new ArrayList<DirectUploadFileInfo>();
		for (FileUploadForm fileUploadForm : form.getUploadUploadForms()) {
			MultipartFile multipartFile = fileUploadForm.getFile();
			if (!StringUtils.hasLength(multipartFile.getOriginalFilename())) {
				continue;
			}
			uploadTmpFiles.add(new DirectUploadFileInfo(multipartFile.getInputStream(),
					multipartFile.getOriginalFilename(), fileUploadForm.getDescription(), employeeId));
		}

		List<UploadFileInfo> uploadFileInfoList = directUploadService.saveFiles(uploadTmpFiles);
		model.addAttribute("uploadFileInfoList", uploadFileInfoList);
		model.addAttribute("employeeId", form.getEmployeeId());
		// set result message.
		redirectAttributes
				.addFlashAttribute(ResultMessages.success().add(Messages.UP_FILE_UPLOADED.getResultMessage()));
		Page<Employee> employee = employeeService.search(employeeId, pageable);
		model.addAttribute("page", employee);
		return "employee/uploadComplete";
	}
}
