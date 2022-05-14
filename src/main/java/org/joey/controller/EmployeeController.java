package org.joey.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.joey.pojo.Employee;
import org.joey.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: JoeyShelby
 * @date: 2022-05-14 09:09
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
     * 分页，返回员工列表
     * @param pageNumber
     * @param model
     * @return
     */
    @RequestMapping("/employee")
    public String toEmployee(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                             Model model) {
        PageHelper.startPage(pageNumber, 5);
        List<Employee> employees = employeeService.getAllEmployees();

        PageInfo pageInfo = new PageInfo(employees, 5);
        model.addAttribute("pageInfo", pageInfo);
        System.out.println(pageInfo);

        return "employee";
    }
}
