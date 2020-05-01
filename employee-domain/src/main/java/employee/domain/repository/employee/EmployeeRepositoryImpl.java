/*
 * package employee.domain.repository.employee;
 * 
 * import java.util.Collection; import java.util.List; import java.util.Map;
 * import java.util.concurrent.ConcurrentHashMap;
 * 
 * import org.apache.ibatis.annotations.Param; import
 * org.apache.ibatis.session.RowBounds; import
 * org.springframework.data.domain.Pageable; import
 * org.springframework.stereotype.Repository; import
 * employee.domain.model.Employee;
 * 
 * 
 * @Repository public class EmployeeRepositoryImpl implements
 * EmployeeRepository{
 * 
 * private static final Map<String, Employee> EMPLOYEE_MAP = new
 * ConcurrentHashMap<String, Employee>();
 * 
 * @SuppressWarnings("unchecked") public Collection<Employee> search(String
 * employeeId) { return (Collection<Employee>) EMPLOYEE_MAP.get(employeeId); }
 * 
 * @Override public List<Employee> findAll(Pageable pageable) { return
 * (List<Employee>) EMPLOYEE_MAP.values(); }
 * 
 * @Override public Employee findOne(String employeeId) { return
 * EMPLOYEE_MAP.get(employeeId); }
 * 
 * @Override public void create(Employee emp) {
 * EMPLOYEE_MAP.put(emp.getEmployeeId(), emp); }
 * 
 * @Override public boolean update(Employee emp) {
 * EMPLOYEE_MAP.put(emp.getEmployeeId(), emp); return true; }
 * 
 * @Override public void delete(String employeeId) {
 * EMPLOYEE_MAP.remove(employeeId); }
 * 
 * 
 * }
 */