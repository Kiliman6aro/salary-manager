package ua.pp.hophey.payroll.payment.classification;

public class CommissionClassification implements PaymentClassification{

    private final double salary;

    private final double commissionRate;

    public CommissionClassification(double salary, double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
    }
}

