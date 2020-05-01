package employee.app.employee;

import java.io.IOException;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.message.ResultMessages;
import employee.app.employee.FileUploadForm.FileUpload;
import employee.app.employee.FileUploadForm.SingleFileUpload;
import employee.domain.model.Messages;
import employee.domain.service.employee.DirectUploadService;

@RequestMapping("upload/single")
@Controller
public class FileUploadController {

	@Inject
	private DirectUploadService directUploadService;

	@RequestMapping(method = RequestMethod.GET)
	public String uploadFileForm(FileUploadForm form) {
		return "employee/uploadFile";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String uploadFile(
			@Validated({ SingleFileUpload.class, FileUpload.class, Default.class }) FileUploadForm form,
			BindingResult result, RedirectAttributes redirectAttributes) throws IOException {

		// handle validation result.
		if (result.hasErrors()) {
			return "employee/uploadFile";
		}

		// save file.
		MultipartFile multipartFile = form.getFile();
		directUploadService.saveFile(multipartFile.getInputStream(), multipartFile.getOriginalFilename(),
				form.getDescription(), form.getFileId());

		// set result message.
		redirectAttributes
				.addFlashAttribute(ResultMessages.success().add(Messages.UP_FILE_UPLOADED.getResultMessage()));

		return "employee/uploadConfirm";
	}

}
