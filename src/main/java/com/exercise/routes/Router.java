package com.exercise.routes;

import com.exercise.models.Employee;
import com.exercise.models.Department;
import com.exercise.services.EmployeeService;
import com.exercise.services.DepartmentService;

import java.util.Scanner;

public class Router {
    private final EmployeeService employeeService = new EmployeeService();
    private final DepartmentService departmentService = new DepartmentService();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n--- Menü ---");
            System.out.println("1. Bütün əməkdaşları göstər");
            System.out.println("2. ID-yə görə əməkdaşı seç");
            System.out.println("3. Əməkdaş əlavə et");
            System.out.println("4. Əməkdaşı yenilə");
            System.out.println("5. Əməkdaşı sil");
            System.out.println("6. Departament əlavə et");
            System.out.println("7. Departamenti yenilə");
            System.out.println("8. Departamenti sil");
            System.out.println("9. Bütün departamentləri göstər");
            System.out.println("10. Departamentə görə əməkdaşları göstər");
            System.out.println("0. Çıx");

            System.out.print("Seçiminizi edin: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showAllEmployees();
                case 2 -> getEmployeeById();
                case 3 -> addEmployee();
                case 4 -> updateEmployee();
                case 5 -> deleteEmployee();
                case 6 -> addDepartment();
                case 7 -> updateDepartment();
                case 8 -> deleteDepartment();
                case 9 -> showAllDepartments();
                case 10 -> showEmployeesByDepartment();
                case 0 -> {
                    System.out.println("Proqramdan çıxılır...");
                    System.exit(0);
                }
                default -> System.out.println("Yanlış seçim, yenidən cəhd edin.");
            }
        }
    }
    private void showAllEmployees() {
        try {
            employeeService.getAllEmployees().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Xəta baş verdi: " + e.getMessage());
        }
    }

    private void getEmployeeById() {
        System.out.print("Əməkdaşın ID-sini daxil edin: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            Employee employee = employeeService.getEmployeeById(id);
            if (employee != null) {
                System.out.println(employee);
            } else {
                System.out.println("Belə bir əməkdaş tapılmadı.");
            }
        } catch (Exception e) {
            System.out.println("Xəta baş verdi: " + e.getMessage());
        }
    }

    private void addEmployee() {
        System.out.print("Adını daxil edin: ");
        String name = scanner.nextLine();
        System.out.print("Maaşı daxil edin: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Departament id'sini daxil edin: ");
        int departmentId = scanner.nextInt();
        try {
            Employee newEmployee = new Employee(name, salary, departmentId);
            boolean isAdded = employeeService.addEmployee(newEmployee);
            if (isAdded) {
                System.out.println("Əməkdaş uğurla əlavə edildi.");
            } else {
                System.out.println("Əməkdaşı əlavə etmək mümkün olmadı.");
            }
        } catch (Exception e) {
            System.out.println("Xəta baş verdi: " + e.getMessage());
        }
    }

    private void updateEmployee() {
        System.out.print("Yenilənəcək əməkdaşın ID-sini daxil edin: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Yeni adını daxil edin: ");
        String name = scanner.nextLine();
        System.out.print("Yeni maaşı daxil edin: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Yeni departament id daxil edin: ");
        int departmentId = scanner.nextInt();
        try {
            Employee updatedEmployee = new Employee(id, name, salary, departmentId);
            boolean isUpdated = employeeService.updateEmployee(updatedEmployee);
            if (isUpdated) {
                System.out.println("Əməkdaş uğurla yeniləndi.");
            } else {
                System.out.println("Əməkdaşı yeniləmək mümkün olmadı.");
            }
        } catch (Exception e) {
            System.out.println("Xəta baş verdi: " + e.getMessage());
        }
    }

    private void deleteEmployee() {
        System.out.print("Silinəcək əməkdaşın ID-sini daxil edin: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            boolean isDeleted = employeeService.deleteEmployee(id);
            if (isDeleted) {
                System.out.println("Əməkdaş uğurla silindi.");
            } else {
                System.out.println("Əməkdaşı silmək mümkün olmadı.");
            }
        } catch (Exception e) {
            System.out.println("Xəta baş verdi: " + e.getMessage());
        }
    }

    private void addDepartment() {
        System.out.print("Departamentin adını daxil edin: ");
        String name = scanner.nextLine();
        System.out.print("Departament müdiri adını daxil edin: ");
        String manager = scanner.nextLine();

        try {
            Department newDepartment = new Department(name, manager);
            boolean isAdded = departmentService.addDepartment(newDepartment);
            if (isAdded) {
                System.out.println("Departament uğurla əlavə edildi.");
            } else {
                System.out.println("Departamenti əlavə etmək mümkün olmadı.");
            }
        } catch (Exception e) {
            System.out.println("Xəta baş verdi: " + e.getMessage());
        }
    }

    private void updateDepartment() {
        System.out.print("Yenilənəcək departamentin id'sini daxil edin: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Yeni müdiri daxil edin: ");
        String manager = scanner.nextLine();
        try {
            Department updatedDepartment = new Department(id, manager);
            boolean isUpdated = departmentService.updateDepartment(updatedDepartment);
            if (isUpdated) {
                System.out.println("Departament uğurla yeniləndi.");
            } else {
                System.out.println("Departamenti yeniləmək mümkün olmadı.");
            }
        } catch (Exception e) {
            System.out.println("Xəta baş verdi: " + e.getMessage());
        }
    }

    private void deleteDepartment() {
        System.out.print("Silinəcək departamentin id'sini daxil edin: ");
        int id = scanner.nextInt();
        try {
            boolean isDeleted = departmentService.deleteDepartment(id);
            if (isDeleted) {
                System.out.println("Departament uğurla silindi.");
            } else {
                System.out.println("Departamenti silmək mümkün olmadı.");
            }
        } catch (Exception e) {
            System.out.println("Xəta baş verdi: " + e.getMessage());
        }
    }

    private void showAllDepartments() {
        try {
            departmentService.getAllDepartments().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Xəta baş verdi: " + e.getMessage());
        }
    }

    private void showEmployeesByDepartment() {
        System.out.print("Departamentin id'sini daxil edin: ");
        String departmentName = scanner.nextLine();
        try {
            employeeService.getEmployeesByDepartment(departmentName).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Xəta baş verdi: " + e.getMessage());
        }
    }
}
