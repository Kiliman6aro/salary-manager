package ua.pp.hophey.payroll.transaction.employee;

import org.junit.jupiter.api.Test;
import ua.pp.hophey.payroll.PayrollDatabase;
import ua.pp.hophey.payroll.entity.Employee;
import ua.pp.hophey.payroll.payment.classification.CommissionClassification;
import ua.pp.hophey.payroll.payment.classification.PaymentClassification;
import ua.pp.hophey.payroll.payment.method.HoldMethod;
import ua.pp.hophey.payroll.payment.method.PaymentMethod;
import ua.pp.hophey.payroll.schedule.BiweeklySchedule;
import ua.pp.hophey.payroll.schedule.PaymentSchedule;
import ua.pp.hophey.payroll.transaction.employee.AddCommissionedEmployee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddCommissionedEmployeeTest {

    @Test
    public void testExecuteAddCommissionedEmployee(){
        int id = 1;
        AddCommissionedEmployee transaction = new AddCommissionedEmployee(id, "Bob", "Home", 1500.00, 2.0);
        transaction.execute();

        Employee employee = PayrollDatabase.getEmployee(id);
        assertEquals("Bob", employee.getName(),"Employee should be added to the database");
        PaymentClassification pc = employee.getPaymentClassification();
        assertTrue((pc instanceof CommissionClassification), "Payment specification is not Salaried");
        PaymentSchedule ps = employee.getPaymentSchedule();
        assertTrue((ps instanceof BiweeklySchedule), "Payment schedule is not monthly");

        PaymentMethod pm = employee.getPaymentMethod();
        assertTrue((pm instanceof HoldMethod), "Payment method is not hold method.");
    }
}
