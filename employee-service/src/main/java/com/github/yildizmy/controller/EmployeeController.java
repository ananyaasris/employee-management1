package com.github.yildizmy.controller;

import com.github.yildizmy.model.Employee;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public List<Employee> getAllEmployees() {
        // Constructor: Employee(id, departmentId, name, age, email)
        return List.of(
            new Employee(1L, 1L, "Sathish Kumar", 25, "sathish@gmail.com"),
            new Employee(2L, 2L, "Priya Devi", 24, "priya@gmail.com")
        );
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(3L);
        return employee;
    }
    @GetMapping("/emp")
    public String home() {
        return "<h1>👨‍💼 WELCOME TO EMPLOYEE SERVICE ha ha ha ha  🚀</h1>";
    }

    @GetMapping("/welcome")
    public String hello() {   // ✅ Renamed from home() to hello()
        return "<h1>👨‍💼 This is Ananyaa  eeeeeeeeee🚀</h1>";
    }
}
