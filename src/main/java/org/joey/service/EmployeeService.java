package org.joey.service;

import org.joey.mapper.EmployeeMapper;
import org.joey.pojo.Employee;
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
     * 所有员工信息
     * @return
     */
    public List<Employee> getAllEmployees() {
        return employeeMapper.selectByExampleWithDeptName(null);
    }
}
