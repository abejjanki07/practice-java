package com.att;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Employee emp1 = new Employee(1, "Promise", "IT", 40.0);
        Employee emp2 = new Employee(2, "John", "HR", 70.0);
        Employee emp3 = new Employee(3, "Peter", "Facility", 70.0);
        Employee emp4 = new Employee(4, "Tayo", "Facility", 30.0);
        List<Employee> employees = List.of(emp1, emp2, emp3, emp4);


        //  1. Print all employee names
        List<String> employeeNames = employees.stream().map(Employee::getName).toList();
        System.out.println("1. Print all employee names \n:" + employeeNames);

        //  2. Create a mapping of employee’s Id and Employee object.
        Map<Integer, Employee> employeeIdMap = employees.stream().collect(Collectors.toMap(Employee::getId, employee -> employee));
        System.out.println("2. Create a mapping of employee’s Id and Employee object. \n" + employeeIdMap);
        
        //  3. Create a mapping of employee’s Id and their names.
        Map<Integer, String> employeeIdNameMap = employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName));
        System.out.println("3. Create a mapping of employee’s Id and their names. \n" + employeeIdNameMap);

        //  4. Group employees by their departments.
        Map<String, List<Employee>> employeeByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDept));
        System.out.println("4. Group employees by their departments. \n" + employeeByDept);

        // 5. Find the employee with the maximum salary.
        Optional<Employee> maxSalariedEmployee = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("5. Find the employee with the maximum salary. \n" + maxSalariedEmployee);

        //  6. Find the employee with the minimum salary.
        Optional<Employee> minSalariedEmployee = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("6. Find the employee with the minimum salary. \n" + minSalariedEmployee);
    }
}