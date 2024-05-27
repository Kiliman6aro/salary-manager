package ua.pp.hophey.payroll;

import ua.pp.hophey.payroll.entity.Employee;

import java.util.HashMap;

public class PayrollDatabase {
    private static HashMap<Integer, Employee> employees = new HashMap<>();

    public static void addEmployee(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    public static Employee getEmployee(int id) {
        return employees.get(id);
    }

    public static void clear() {
        employees.clear();
    }
}
