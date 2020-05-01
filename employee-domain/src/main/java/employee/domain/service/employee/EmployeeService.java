package employee.domain.service.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import employee.domain.model.Employee;

public interface EmployeeService {

    Page<Employee> findAll(Pageable pageable);
    
    Page<Employee> search(String searchCondition,Pageable pageable);
    
    Employee findOne(String employeeId);

    Employee create(Employee emp);
    
    UploadFileInfo createFile(UploadFileInfo file);

    Employee finish(String employeeId);

    void delete(String employeeId);

    public long count();

}
