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

    @Test
    public void testGetAllEmps() {
        employeeService.getAllEmployees().forEach(System.out::println);
    }
}
