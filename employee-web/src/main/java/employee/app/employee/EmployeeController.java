package employee.app.employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.groups.Default;
import org.apache.commons.io.FilenameUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;
import employee.app.employee.EmployeeForm.EmployeeCreate;
import employee.app.employee.EmployeeForm.EmployeeDelete;
import employee.app.employee.FileUploadForm.FileUpload;
import employee.app.employee.FileUploadForm.SingleFileUpload;
import employee.domain.model.Account;
import employee.domain.model.Employee;
import employee.domain.service.employee.DirectUploadService;
import employee.domain.service.employee.EmployeeService;
import employee.domain.service.userdetails.SampleUserDetails;

@Controller
@RequestMapping("employee")
public class EmployeeController {

	@Inject
	Mapper beanMapper;

	@Value("${app.upload.saveDir}")
	private File uploadSaveDir;

	@Inject
	private DirectUploadService directUploadService;

	@ModelAttribute
	public EmployeeForm setUpForm() {
		EmployeeForm form = new EmployeeForm();
		return form;
	}

	// (1)
	@ModelAttribute
	public FileUploadForm setFileUploadForm() {
		return new FileUploadForm();
	}

	@Inject
	EmployeeService employeeService;

	@RequestMapping({ "", "/" })
	public String view(Model model, @PageableDefault(size = 10) Pageable pageable) {
		Page<Employee> result = employeeService.findAll(pageable);
		model.addAttribute("page", result);
		return "employee/search";
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String uploadForm(EmployeeForm employeeForm, Model model) {
		model.addAttribute("employeeId", employeeForm.getEmployeeId());
		return "employee/uploadForm";
	}

	@RequestMapping(value = "findOne", method = { RequestMethod.POST, RequestMethod.GET })
	public String findOne(@ModelAttribute EmployeeForm employeeForm, Model model,
			@PageableDefault(size = 10) Pageable pageable) {
		if (!(employeeForm.getSearchCondition().isEmpty())) {
			Page<Employee> employee = employeeService.search(employeeForm.getSearchCondition(), pageable);
			model.addAttribute("page", employee);
		} else {
			Page<Employee> employee = employeeService.findAll(pageable);
			model.addAttribute("page", employee);
		}
		return "employee/search";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@AuthenticationPrincipal SampleUserDetails userDetails, Model model) {
		Account account = userDetails.getAccount();
		model.addAttribute(account);
		model.addAttribute("employeeForm", new EmployeeForm());
		model.addAttribute("screenTitle", "Register Screen");
		model.addAttribute("buttonTitle", "Register");
		return "employee/register";
	}

	@RequestMapping(value = "registerRedo", method = RequestMethod.POST)
	public String registerRedo(@ModelAttribute("employeeForm") EmployeeForm employeeForm, Model model) {
		model.addAttribute("employeeForm", employeeForm);
		return "employee/register";
	}

	@RequestMapping(value = "/confirmForm", method = RequestMethod.POST)
	public String submitForm(
			@Validated({ Default.class,
					EmployeeCreate.class }) @ModelAttribute("employeeForm") EmployeeForm employeeForm,
			Model model, BindingResult bindingResult, @PageableDefault(size = 10) Pageable pageable) {
		if (bindingResult.hasErrors()) {
			return view(model, pageable);
		}
		if ("1".equals(employeeForm.getDepartmentId())) {
			employeeForm.setDepartmentName("System Development");
		} else if ("2".equals(employeeForm.getDepartmentId())) {
			System.out.println("I am Here");
			employeeForm.setDepartmentName("Infra");
		} else if ("3".equals(employeeForm.getDepartmentId())) {
			employeeForm.setDepartmentName("HR");
		} else {
			employeeForm.setDepartmentName("Finance");
		}

		if ("1".equals(employeeForm.getLevelId())) {
			employeeForm.setLevelName("N1");
		} else if ("2".equals(employeeForm.getLevelId())) {
			employeeForm.setLevelName("N2");
		} else if ("3".equals(employeeForm.getLevelId())) {
			employeeForm.setLevelName("N3");
		} else if ("4".equals(employeeForm.getLevelId())) {
			employeeForm.setLevelName("N4");
		} else if ("5".equals(employeeForm.getLevelId())) {
			employeeForm.setLevelName("N5");
		} else {
			employeeForm.setLevelName("Beginner");
		}

		if ("1".equals(employeeForm.getPositionId())) {
			employeeForm.setPositionName("JSE");
		} else if ("2".equals(employeeForm.getPositionId())) {
			employeeForm.setPositionName("SE");
		} else if ("3".equals(employeeForm.getPositionId())) {
			employeeForm.setPositionName("SSE");
		} else if ("4".equals(employeeForm.getPositionId())) {
			employeeForm.setPositionName("TL");
		} else if ("5".equals(employeeForm.getPositionId())) {
			employeeForm.setPositionName("PL");
		} else if ("6".equals(employeeForm.getPositionId())) {
			employeeForm.setPositionName("PM");
		} else if ("7".equals(employeeForm.getPositionId())) {
			employeeForm.setPositionName("Junior HR");
		} else {
			employeeForm.setPositionName("Senior HR");
		}
		model.addAttribute("employeeForm", employeeForm);
		Page<Employee> employee = employeeService.search(employeeForm.getEmployeeId(), pageable);
		if (employee.getContent().isEmpty()) {
			model.addAttribute("screenTitle", "Register Confirm Screen");
			model.addAttribute("buttonTitle", "Register Confirm");
		} else {
			model.addAttribute("screenTitle", "Edit Confirm Screen");
			model.addAttribute("buttonTitle", "Edit Confirm");
		}
		return "employee/confirm";
	}

	@RequestMapping(value = "create", method = { RequestMethod.POST, RequestMethod.GET })
	public String create(Employee employeeForm, BindingResult bindingResult, Model model, RedirectAttributes attributes,
			@PageableDefault(size = 10) Pageable pageable) {
		if (bindingResult.hasErrors()) {
			return view(model, pageable);
		}
		Page<Employee> employeeSearch = employeeService.search(employeeForm.getEmployeeId(), pageable);
		System.out.println("Employee =" + employeeSearch.getContent());
		if (employeeSearch.getContent().isEmpty()) {
			model.addAttribute("screenTitle", "Register Complete Screen");
			model.addAttribute("textTitle", "Successfully Registered.");
		} else {
			model.addAttribute("screenTitle", "Edit Complete Screen");
			model.addAttribute("textTitle", "Successfully Edited.");
		}
		Employee employee = beanMapper.map(employeeForm, Employee.class);
		model.addAttribute("employees", employee);
		try {
			employeeService.create(employee);
		} catch (BusinessException e) {
			model.addAttribute(e.getResultMessages());
			return view(model, pageable);
		}

		attributes.addFlashAttribute(ResultMessages.success().add(ResultMessage.fromText("Created successfully!")));

		return "employee/complete";
	}

	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(@Validated({ Default.class, EmployeeDelete.class }) EmployeeForm form,
			BindingResult bindingResult, Model model, RedirectAttributes attributes,
			@PageableDefault(size = 10) Pageable pageable) {

		try {
			employeeService.delete(form.getEmployeeId());
		} catch (BusinessException e) {
			model.addAttribute(e.getResultMessages());
			return view(model, pageable);
		}

		attributes.addFlashAttribute(ResultMessages.success().add(ResultMessage.fromText("Deleted successfully!")));

		return view(model, pageable);
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(EmployeeForm employeeForm, BindingResult bindingResult, Model model) {

		System.out.println("level Id is " + employeeForm.getLevelId());
		model.addAttribute("employeeForm", employeeForm);
		model.addAttribute("screenTitle", "Edit Screen");
		model.addAttribute("buttonTitle", "Edit");
		return "employee/register";
	}

	@RequestMapping(value = "uploadFile", method = RequestMethod.POST)
	public String uploadFile(
			@Validated({ SingleFileUpload.class, FileUpload.class, Default.class }) FileUploadForm form,
			BindingResult result, RedirectAttributes redirectAttributes) throws IOException {
		// (8)
		if (result.hasErrors()) {
			return "employee/uploadForm";
		}
		String fileName = form.getEmployeeId() + form.getDescription();
		form.setFileId(fileName);
		form.setFileName(fileName);
		// save file.
		MultipartFile multipartFile = form.getFile();
		directUploadService.saveFile(multipartFile.getInputStream(), fileName,
				form.getDescription(), form.getEmployeeId());

		redirectAttributes.addFlashAttribute(ResultMessages.success().add("i.xx.at.0001"));
		return "employee/uploadConfirm";
	}

	@RequestMapping(value = "employeeDetails", method = RequestMethod.GET)
	public String details(String employeeId, Model model, @PageableDefault(size = 10) Pageable pageable) {
		System.out.println("I am here" + employeeId);
		model.addAttribute("screenTitle", "Employee Details Screen");
		model.addAttribute("employeeId", employeeId);
		return "employee/employeeDetails";
	}

	@RequestMapping(value = "download", method = RequestMethod.GET, params = "employeeId")
	public String downloarProc(@RequestParam("employeeId") String empID, @RequestParam("fileId") String fileId,
			Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String folderName = "employee_" + empID;
		// String fileName = fileId;
		String fileName = FilenameUtils.removeExtension(fileId);
		Path path = Paths.get(uploadSaveDir + "\\" + folderName + "\\");
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (Files.exists(path)) {
			DirectoryStream<Path> streams = Files.newDirectoryStream(path);
			for (Path pt : streams) {
				String fileName2 = FilenameUtils.removeExtension(pt.getFileName().toString());
				if (fileName.equals(fileName2)) {
					String ext = FilenameUtils.getExtension(pt.toString());
					response.setContentType(ext);
					response.addHeader("Content-Disposition", "attachment; filename=" + pt.getFileName());
					Files.copy(pt, response.getOutputStream());
					response.getOutputStream().flush();
					break;
				} else {
				}
			}
		} else {
			return "employee/employeeDetails";
		}
		return "employee/employeeDetails";
	}
}
