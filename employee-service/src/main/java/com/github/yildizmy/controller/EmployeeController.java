
package com.github.yildizmy.controller;

import com.github.yildizmy.model.Employee;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public List<Employee> getAllEmployees() {
        return List.of(
            new Employee(1L, "Sathish Kumar", "sathish@gmail.com", 1L),
            new Employee(2L, "Priya Devi", "priya@gmail.com", 2L)
        );
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(3L);
        return employee;
    }
}
