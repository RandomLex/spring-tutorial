package com.whitepages;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;


    public void printEmployees() {
        System.out.println(employeeRepository.getEmployees());
        System.out.println(departmentRepository.getDepartments());
    }
}
