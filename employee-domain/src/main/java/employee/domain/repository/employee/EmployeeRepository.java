package employee.domain.repository.employee;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import employee.domain.model.Employee;
import employee.domain.service.employee.UploadFileInfo;


public interface EmployeeRepository {
	List<Employee> search(@Param("pageable") Pageable pageable,@Param("searchCondition") String searchCondition );

    List<Employee> findAll(@Param("pageable") Pageable pageable);
    
    Employee findOne(String todoId);

    void create(Employee todo);
    
    void createFile(UploadFileInfo todo);

    boolean update(Employee todo);

    void delete(String employeeId);

	long count();
    
	long countById(@Param("searchCondition") String employeeId);
}
