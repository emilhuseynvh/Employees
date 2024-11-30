package com.exercise.repositories;

import com.exercise.models.Employee;
import com.exercise.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    public List<Employee> getAllEmployees() throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM employees";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        List<Employee> employees = new ArrayList<>();
        while (resultSet.next()) {
            employees.add(new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("salary"),
                    resultSet.getInt("department_id")
            ));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return employees;
    }

    public Employee getById(int id) throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM employees WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        Employee employee = null;

        if (resultSet.next()) {
            employee = new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("salary"),
                    resultSet.getInt("department_id")
            );
        }

        resultSet.close();
        statement.close();
        connection.close();

        return employee;
    }

    public Boolean insertEmployee(Employee employee) throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO employees (name, salary, department_id) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, employee.getName());
        statement.setDouble(2, employee.getSalary());
        statement.setInt(3, employee.getDepartmentId());

        var processStatus = statement.executeUpdate();

        statement.close();
        connection.close();

        return processStatus == 0 ? Boolean.FALSE : Boolean.TRUE;

    }

    public Boolean updateEmployee(Employee employee) throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE employees SET name = ?, salary = ?, department_id = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, employee.getName());
        statement.setDouble(2, employee.getSalary());
        statement.setInt(3, employee.getDepartmentId());
        statement.setInt(4, employee.getId());

        var processStatus = statement.executeUpdate();

        statement.close();
        connection.close();
        return processStatus == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public Boolean deleteEmployee(int id) throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM employees WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        var processStatus = statement.executeUpdate();

        statement.close();
        connection.close();
        return processStatus == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public List<Employee> getEmployeesByDepartment(String departmentName) throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM employees WHERE department_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, departmentName);
        ResultSet resultSet = statement.executeQuery();

        List<Employee> employees = new ArrayList<>();
        while (resultSet.next()) {
            employees.add(new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("salary"),
                    resultSet.getInt("department_id")
            ));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return employees;
    }
}
