package org.joey.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.joey.pojo.Employee;
import org.joey.pojo.Msg;
import org.joey.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: JoeyShelby
 * @date: 2022-05-14 09:09
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;


    @RequestMapping("/employee")
    @ResponseBody
    public Msg toEmployee(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber) {
        PageHelper.startPage(pageNumber, 5);
        List<Employee> employees = employeeService.getAllEmployees();

        PageInfo pageInfo = new PageInfo(employees, 5);
        System.out.println(pageInfo);

        Msg success = Msg.success().add("pageInfo", pageInfo);
        return success;
    }


    @RequestMapping("/checkEmpName")
    @ResponseBody
    public Msg checkEmpName(@RequestParam(value = "empName", defaultValue = "")String empName) {
        boolean checkEmpName = employeeService.checkEmployeeName(empName);
        if (checkEmpName) {
            return Msg.success().add("checkEmpName", checkEmpName);
        } else {
            return Msg.fail().add("checkEmpName","员工名已被占用");
        }

    }

    @RequestMapping("/addEmp")
    @ResponseBody
    public Msg addEmp(@Valid Employee employee, BindingResult result){
        // jsr303 检测不通过
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : fieldErrors) {
                String field = error.getField();
                String defaultMessage = error.getDefaultMessage();
                errors.put(field,defaultMessage);
                System.out.println(field+":"+defaultMessage);
            }

            return Msg.fail().add("errors",errors);
        }

        //员工名是否重复
        boolean checkEmpName = employeeService.checkEmployeeName(employee.getEmpName());
        if (checkEmpName) { //不重复直接添加
            System.out.println(employee);
            int i = employeeService.insertEmployee(employee);

            if(i>=1) {
                return Msg.success().add("error", "添加成功");
            } else {
                return Msg.fail().add("error", "添加失败");
            }
        } else {
            return Msg.fail().add("error", "员工名重复");
        }

    }

    /*根据id 获得员工信息*/
    @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmployeeById(@PathVariable Integer id) {
        Employee employeeById = employeeService.getEmployeeById(id);
        if (employeeById != null) {
            return Msg.success().add("employee",employeeById);
        }
        return Msg.fail();
    }

    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateEmployeeById(@PathVariable Integer empId, @Valid Employee employee, BindingResult result) {
        // jsr303 检测不通过
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : fieldErrors) {
                String field = error.getField();
                String defaultMessage = error.getDefaultMessage();
                errors.put(field,defaultMessage);
                System.out.println(field+":"+defaultMessage);
            }

            return Msg.fail().add("errors",errors);
        }
        System.out.println("update:"+employee);
        if(employeeService.updateEmployee(employee) < 1){
            return Msg.fail();
        }

        return Msg.success().add("employee",employee);
    }
}
