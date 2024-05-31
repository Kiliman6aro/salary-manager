package ua.pp.hophey.payroll;

import org.junit.jupiter.api.Test;
import ua.pp.hophey.payroll.entity.Employee;
import ua.pp.hophey.payroll.payment.classification.HourlyClassification;
import ua.pp.hophey.payroll.payment.classification.PaymentClassification;
import ua.pp.hophey.payroll.payment.classification.SalariedClassification;
import ua.pp.hophey.payroll.payment.method.HoldMethod;
import ua.pp.hophey.payroll.payment.method.PaymentMethod;
import ua.pp.hophey.payroll.schedule.MonthlySchedule;
import ua.pp.hophey.payroll.schedule.PaymentSchedule;
import ua.pp.hophey.payroll.schedule.WeeklySchedule;
import ua.pp.hophey.payroll.transaction.AddHorlyEmployee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddHourlyEmployeeTest {

    @Test
    public void testExecuteAddHourlyEmployee(){
        int id = 1;
        AddHorlyEmployee transaction = new AddHorlyEmployee(id, "Bob", "Home", 13.5);
        transaction.execute();

        Employee employee = PayrollDatabase.getEmployee(id);
        assertEquals("Bob", employee.getName(),"Employee should be added to the database");
        PaymentClassification pc = employee.getPaymentClassification();
        assertTrue((pc instanceof HourlyClassification), "Payment specification is not Salaried");
        PaymentSchedule ps = employee.getPaymentSchedule();
        assertTrue((ps instanceof WeeklySchedule), "Payment schedule is not monthly");

        PaymentMethod pm = employee.getPaymentMethod();
        assertTrue((pm instanceof HoldMethod), "Payment method is not hold method.");
    }
}
