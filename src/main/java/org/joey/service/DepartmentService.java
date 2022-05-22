package org.joey.service;

import org.joey.mapper.DepartmentMapper;
import org.joey.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: JoeyShelby
 * @date: 2022-05-15 08:57
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getAllDepartments() {
        return departmentMapper.selectByExample(null);
    }
}
