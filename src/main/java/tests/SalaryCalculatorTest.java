package tests;

import com.example.hrfaraonapp.utils.SalaryCalculator;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class SalaryCalculatorTest {
    @Test
    public void should_calculate_good_netto() {
        // data
        double exampleSalary = 4000;
        double expectedSalary = 2660.956;

        //when
        SalaryCalculator calculator = new SalaryCalculator(exampleSalary);

        double result = calculator.getNetto();

        //then

        assertEquals(expectedSalary, result);
    }
    @Test
    public void pension_insurance_should_be_equal_390_4() {
        // data
        double exampleSalary = 4000;
        double pensionInsurance = 390.4;

        //when
        SalaryCalculator calculator = new SalaryCalculator(exampleSalary);

        double result = calculator.getPensionInsurance();

        //then

        assertEquals(pensionInsurance, result);
    }
}
