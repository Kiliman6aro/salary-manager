package ua.pp.hophey.payroll.payment.classification;

public class HourlyClassification implements PaymentClassification{
    private final double rate;

    public HourlyClassification(double rate) {
        this.rate = rate;
    }
}
