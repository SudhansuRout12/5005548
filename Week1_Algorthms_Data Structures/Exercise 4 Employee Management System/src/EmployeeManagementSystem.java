
import java.util.Arrays;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee(id=" + employeeId + ", name=" + name + ", position=" + position + ", salary=" + salary + ")";
    }
}

public class EmployeeManagementSystem {

    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Employee array is full. Cannot add more employees.");
        }
    }

    // Search for an employee by ID
    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public boolean deleteEmployeeById(int employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId == employeeId) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete == -1) {
            return false;
        }
        for (int i = indexToDelete; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null; // Clear the last element
        size--;
        return true;
    }

    public static void main(String[] args) {
        // Create an employee management system with a capacity of 5 employees
        EmployeeManagementSystem ems = new EmployeeManagementSystem(5);

        // Add employees
        ems.addEmployee(new Employee(1, "Alice Johnson", "Software Engineer", 75000));
        ems.addEmployee(new Employee(2, "Bob Smith", "Project Manager", 85000));
        ems.addEmployee(new Employee(3, "Charlie Brown", "Analyst", 70000));
        ems.addEmployee(new Employee(4, "Diana Prince", "UX Designer", 72000));
        ems.addEmployee(new Employee(5, "Eve Adams", "HR Manager", 68000));

        // Traverse and print all employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Search for an employee by ID
        System.out.println("\nSearching for Employee with ID 3:");
        Employee searchedEmployee = ems.searchEmployeeById(3);
        System.out.println(searchedEmployee != null ? searchedEmployee : "Employee not found.");

        // Delete an employee by ID
        System.out.println("\nDeleting Employee with ID 2:");
        boolean isDeleted = ems.deleteEmployeeById(2);
        System.out.println(isDeleted ? "Employee deleted successfully." : "Employee not found.");

        // Traverse and print all employees after deletion
        System.out.println("\nAll Employees after deletion:");
        ems.traverseEmployees();
    }
}
