//@GetMapping
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
