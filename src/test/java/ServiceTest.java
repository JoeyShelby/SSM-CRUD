import org.joey.pojo.Employee;
import org.joey.service.DepartmentService;
import org.joey.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author: JoeyShelby
 * @date: 2022-05-14 09:45
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ServiceTest {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;

    @Test
    public void testGetAllEmps() {
        employeeService.getAllEmployees().forEach(System.out::println);
    }

    @Test
    public void testInsertEmployee() {
        Employee employee = new Employee(null, "测试插入", "M", "123@abc.com", 2);
        System.out.println(employeeService.insertEmployee(employee));
    }

    @Test
    public void testCheckEmployeeName() {
        System.out.println(employeeService.checkEmployeeName("张三"));
    }

    @Test
    public void testGetEmployeeById() {
        System.out.println(employeeService.getEmployeeById(2));
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee(27, "测试更新", "F", null, null);
        System.out.println(employeeService.updateEmployee(employee));
    }

    @Test
    public void testDeleteEmployee() {
        System.out.println(employeeService.deleteEmployee(27));
    }

    @Test
    public void testGetAllDepartments() {
        departmentService.getAllDepartments().forEach(System.out::println);
    }
}
