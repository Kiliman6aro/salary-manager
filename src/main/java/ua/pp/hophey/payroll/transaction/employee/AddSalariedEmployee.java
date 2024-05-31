package ua.pp.hophey.payroll.transaction.employee;

import ua.pp.hophey.payroll.payment.classification.PaymentClassification;
import ua.pp.hophey.payroll.payment.classification.SalariedClassification;
import ua.pp.hophey.payroll.schedule.MonthlySchedule;
import ua.pp.hophey.payroll.schedule.PaymentSchedule;

public class AddSalariedEmployee extends AddEmployeeTransaction{

    private double salary;

    public AddSalariedEmployee(int id, String name, String address, double salary) {
        super(id, name, address);
        this.salary = salary;
    }

    @Override
    protected PaymentClassification makeClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new MonthlySchedule();
    }

}
