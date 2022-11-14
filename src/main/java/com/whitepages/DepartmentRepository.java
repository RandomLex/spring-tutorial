package com.whitepages;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentRepository {
    public List<String> getDepartments() {
        return List.of("Bank", "Financial");
    }
}
