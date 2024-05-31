package ua.pp.hophey.payroll.transaction;

import ua.pp.hophey.payroll.payment.classification.HourlyClassification;
import ua.pp.hophey.payroll.payment.classification.PaymentClassification;
import ua.pp.hophey.payroll.schedule.PaymentSchedule;
import ua.pp.hophey.payroll.schedule.WeeklySchedule;

public class AddHorlyEmployee extends AddEmployeeTransaction{

    private final double rate;

    public AddHorlyEmployee(int id, String name, String address, double rate) {
        super(id, name, address);
        this.rate = rate;
    }

    @Override
    protected PaymentClassification makeClassification() {
        return new HourlyClassification(rate);
    }

    @Override
    protected PaymentSchedule makeSchedule() {
        return new WeeklySchedule();
    }
}
