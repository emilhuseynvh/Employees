package com.exercise.services;

import com.exercise.models.Department;
import com.exercise.repositories.DepartmentRepository;

import java.util.List;

public class DepartmentService {
    private final DepartmentRepository repository = new DepartmentRepository();

    public List<Department> getAllDepartments() throws Exception {
        return repository.getAllDepartments();
    }

    public Boolean addDepartment(Department department) throws Exception {
        return repository.insertDepartment(department);
    }

    public Boolean updateDepartment(Department department) throws Exception {
        return repository.updateDepartment(department);
    }

    public Boolean deleteDepartment(int id) throws Exception {
        return repository.deleteDepartment(id);
    }
}
