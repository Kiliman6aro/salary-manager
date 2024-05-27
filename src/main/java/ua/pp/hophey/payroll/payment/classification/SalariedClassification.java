package ua.pp.hophey.payroll.payment.classification;

public class SalariedClassification implements PaymentClassification{
    private double salary;

    public SalariedClassification(double salary) {
        this.salary = salary;
    }
}
