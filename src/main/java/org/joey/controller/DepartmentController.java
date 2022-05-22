package org.joey.controller;

import org.joey.pojo.Department;
import org.joey.pojo.Msg;
import org.joey.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: JoeyShelby
 * @date: 2022-05-17 10:23
 */
@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;


    @RequestMapping("/departments")
    @ResponseBody
    public Msg getAllDepartments() {
        List<Department> allDepartments = departmentService.getAllDepartments();
        return Msg.success().add("Departments", allDepartments);
    }
}
