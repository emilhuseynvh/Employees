package com.exercise.repositories;

import com.exercise.models.Department;
import com.exercise.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    public List<Department> getAllDepartments() throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM departments";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        List<Department> departments = new ArrayList<>();
        while (resultSet.next()) {
            Department department = new Department(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("manager")
            );
            departments.add(department);
        }

        resultSet.close();
        statement.close();
        connection.close();

        return departments;
    }

    public Boolean insertDepartment(Department department) throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO departments (name, manager) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, department.getName());
        statement.setString(2, department.getManager());

        int processStatus = statement.executeUpdate();

        statement.close();
        connection.close();
        return processStatus == 0 ? Boolean.FALSE : Boolean.TRUE;
    }

    public Boolean updateDepartment(Department department) throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        String query = "UPDATE departments SET manager = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, department.getManager());
        statement.setInt(2, department.getId());

        var processStatus = statement.executeUpdate();

        statement.close();
        connection.close();
        return processStatus == 0 ? Boolean.FALSE: Boolean.TRUE;
    }

    public Boolean deleteDepartment(int id) throws Exception {
        Connection connection = DatabaseConnection.getConnection();
        String query = "DELETE FROM departments WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        var processStatus = statement.executeUpdate();

        statement.close();
        connection.close();
        return processStatus == 0 ? Boolean.FALSE: Boolean.TRUE;
    }
}
