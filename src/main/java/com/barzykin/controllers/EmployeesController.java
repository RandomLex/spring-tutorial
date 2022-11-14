package com.barzykin.controllers;

import com.barzykin.model.Employee;
import com.barzykin.model.Mentor;
import com.whitepages.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeesController {
    private final EmployeeRepository employeeRepository;

    @RequestMapping(value = "/api/employees", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @RequestMapping(value = "/api/employees/alex", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public Employee returnAlex() {
        return new Mentor(15, "Alex", 1000);
    }

}
