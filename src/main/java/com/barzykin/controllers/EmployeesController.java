package com.barzykin.controllers;

import com.barzykin.model.Employee;
import com.barzykin.model.Mentor;
import com.whitepages.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeesController {
    private final EmployeeRepository employeeRepository;

    @GetMapping("/api/employees")
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @GetMapping("/api/employees/alex")
    public Employee returnAlex() {
        return new Mentor(15, "Alex", 1000);
    }

}
