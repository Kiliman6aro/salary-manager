package ua.pp.hophey.payroll.transaction.employee;

import ua.pp.hophey.payroll.payment.classification.CommissionClassification;
import ua.pp.hophey.payroll.payment.classification.PaymentClassification;
import ua.pp.hophey.payroll.schedule.BiweeklySchedule;
import ua.pp.hophey.payroll.schedule.PaymentSchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction{

    private final double salary;

    private final double commissionRate;
    public AddCommissionedEmployee(int id, String name, String address, double salary, double commissionRate) {
        super(id, name, address);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    protected PaymentClassification makeClassification() {
        return new CommissionClassification(salary, commissionRate);
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new BiweeklySchedule();
    }
}
