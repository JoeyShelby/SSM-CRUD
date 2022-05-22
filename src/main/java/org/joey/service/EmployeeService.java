package org.joey.service;

import org.joey.mapper.EmployeeMapper;
import org.joey.pojo.Employee;
import org.joey.pojo.EmployeeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: JoeyShelby
 * @date: 2022-05-14 09:21
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 查询所有员工信息
     * @return
     */
    public List<Employee> getAllEmployees() {
        return employeeMapper.selectByExampleWithDeptName(null);
    }

    /**
     * 新增一条员工记录
     * @param employee
     * @return
     */
    public int insertEmployee(Employee employee) {
        return employeeMapper.insertSelective(employee);
    }

    /**
     * 检验用户名是否可用
     * @return true：可用 flase：不可用
     */
    public boolean checkEmployeeName(String employeeName) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmpNameEqualTo(employeeName);
        long count = employeeMapper.countByExample(employeeExample);

        return count == 0;
    }

    /**
     * 按 id 查员工
     * @param id
     * @return
     */
    public Employee getEmployeeById(int id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新员工信息
     * @param employee
     * @return
     */
    public int updateEmployee(Employee employee) {
        return employeeMapper.updateByPrimaryKeySelective(employee);
    }

    /**
     * 删除员工
     * @param id
     * @return
     */
    public int deleteEmployee(int id) {
        return employeeMapper.deleteByPrimaryKey(id);
    }
}
