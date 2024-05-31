package ua.pp.hophey.payroll.transaction.employee;

import org.junit.jupiter.api.Test;
import ua.pp.hophey.payroll.PayrollDatabase;
import ua.pp.hophey.payroll.entity.Employee;
import ua.pp.hophey.payroll.payment.classification.PaymentClassification;
import ua.pp.hophey.payroll.payment.method.HoldMethod;
import ua.pp.hophey.payroll.payment.method.PaymentMethod;
import ua.pp.hophey.payroll.schedule.MonthlySchedule;
import ua.pp.hophey.payroll.schedule.PaymentSchedule;
import ua.pp.hophey.payroll.transaction.employee.AddEmployeeTransaction;
import ua.pp.hophey.payroll.transaction.employee.AddSalariedEmployee;
import ua.pp.hophey.payroll.payment.classification.SalariedClassification;

import static org.junit.jupiter.api.Assertions.*;

public class AddSalariedEmployeeTest {


    @Test
    public void testExecuteAddsEmployee() {

        int id = 1;
        AddEmployeeTransaction transaction = new AddSalariedEmployee(id, "Bob", "Home", 1000.00);
        transaction.execute();

        Employee employee = PayrollDatabase.getEmployee(id);
        assertEquals("Bob", employee.getName(),"Employee should be added to the database");
        PaymentClassification pc = employee.getPaymentClassification();
        assertTrue((pc instanceof SalariedClassification), "Payment specification is not Salaried");
        PaymentSchedule ps = employee.getPaymentSchedule();
        assertTrue((ps instanceof MonthlySchedule), "Payment schedule is not monthly");

        PaymentMethod pm = employee.getPaymentMethod();
        assertTrue((pm instanceof HoldMethod), "Payment method is not hold method.");
    }
}
