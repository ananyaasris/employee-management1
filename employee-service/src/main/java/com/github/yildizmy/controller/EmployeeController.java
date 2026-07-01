package com.github.yildizmy.controller;

import com.github.yildizmy.model.Employee;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // Indha rendu method ah add pannu 👇
    @GetMapping
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1L, "Sathish Kumar", "sathish@gmail.com", 1L));
        list.add(new Employee(2L, "Priya Devi", "priya@gmail.com", 2L));
        return list;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(3L);
        return employee;
    }

    // Already irukura code - id by employee
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return new Employee(id, "Test", "test@test.com", 1L);
    }
}
