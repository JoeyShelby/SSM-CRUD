import org.joey.mapper.DepartmentMapper;
import org.joey.mapper.EmployeeMapper;
import org.joey.pojo.Department;
import org.joey.pojo.DepartmentExample;
import org.joey.pojo.Employee;
import org.joey.pojo.EmployeeExample;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;

/**
 * @author: JoeyShelby
 * @date: 2022-05-02 17:50
 * 使用SpringTest
 * 1. 导入SpringTest依赖
 * 2. @ContextConfiguration(locations = {"classpath:applicationContext.xml"})指定Spring配置文件位置
 * 3. @ExtendWith(SpringExtension.class)
 * 4. 直接autowired要使用的组件即可
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void testInsertEmployee() {
        for (int i = 0; i < 24; i++) {
            Employee employee = new Employee(null, "张三", "M", "123@qq.com", 1);
            employeeMapper.insertSelective(employee);
        }
    }

    @Test
    public void testDeleteEmployee(){
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmpIdEqualTo(1).andGenderEqualTo("M");
        employeeMapper.deleteByExample(employeeExample);
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee(2,"张三","F","456@qq.com",null);
        //如果某个字段为 null，则不执行更新操作
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    @Test
    public void testSelectEmployee() {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmpIdEqualTo(2).andGenderEqualTo("F");
        List<Employee> employees = employeeMapper.selectByExampleWithDeptName(employeeExample);
        employees.forEach(System.out::println);
    }


    @Test
    public void testInsertDepartment() {
        Department department = new Department(null, "保卫处");
        departmentMapper.insertSelective(department);
        Department department2 = new Department(null, "研发部");
        departmentMapper.insertSelective(department);
    }

    @Test
    public void testDeleteDepartment() {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDeptIdBetween(2,3);
        departmentMapper.deleteByExample(departmentExample);
    }

    @Test
    public void testUpdateDepartment() {
        Department department = new Department(4,"基建处");
        departmentMapper.updateByPrimaryKey(department);
    }

    @Test
    public void testSelectDepartment() {
        DepartmentExample departmentExample = new DepartmentExample();
        departmentExample.createCriteria().andDeptIdBetween(1,4);
        List<Department> departments = departmentMapper.selectByExample(departmentExample);
        departments.forEach(System.out::println);

    }
    @Test
    public void testGetEmpById(){

    }
}
