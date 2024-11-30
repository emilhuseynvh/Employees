package com.exercise.services;

import com.exercise.models.Employee;
import com.exercise.repositories.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private final EmployeeRepository repository = new EmployeeRepository();

    public List<Employee> getAllEmployees() throws Exception {
        return repository.getAllEmployees();
    }

    public Employee getEmployeeById(int id) throws Exception {
        return repository.getById(id);
    }

    public Boolean addEmployee(Employee employee) throws Exception {
        return repository.insertEmployee(employee);
    }

    public Boolean updateEmployee(Employee employee) throws Exception {
        return repository.updateEmployee(employee);
    }

    public Boolean deleteEmployee(int id) throws Exception {
        return repository.deleteEmployee(id);
    }

    public List<Employee> getEmployeesByDepartment(String departmentName) throws Exception {
        return repository.getEmployeesByDepartment(departmentName);
    }
}

