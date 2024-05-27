package ua.pp.hophey.payroll.transaction;

import ua.pp.hophey.payroll.PayrollDatabase;
import ua.pp.hophey.payroll.entity.Employee;
import ua.pp.hophey.payroll.payment.classification.PaymentClassification;
import ua.pp.hophey.payroll.payment.method.HoldMethod;
import ua.pp.hophey.payroll.payment.method.PaymentMethod;
import ua.pp.hophey.payroll.schedule.PaymentSchedule;

public abstract class AddEmployeeTransaction implements Transaction{
    private int id;
    private String name;

    private String address;

    public AddEmployeeTransaction(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    protected abstract PaymentClassification makeClassification();

    protected abstract PaymentSchedule makeSchedule();


    public void execute() {
        PaymentClassification pc = makeClassification();
        PaymentSchedule ps = makeSchedule();
        PaymentMethod pm = new HoldMethod();
        Employee employee = new Employee(id, name, address);
        employee.setPaymentClassification(pc);
        employee.setPaymentMethod(pm);
        employee.setPaymentSchedule(ps);
        PayrollDatabase.addEmployee(employee);
    }
}
