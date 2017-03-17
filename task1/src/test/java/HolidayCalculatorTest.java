import com.aviva.recruitingtasks.kmol.task1.HolidayCalculator;
import com.aviva.recruitingtasks.kmol.task1.model.Employee;
import com.aviva.recruitingtasks.kmol.task1.sampledata.MonthException;
import com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaEmployees;
import com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaHolidays;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class HolidayCalculatorTest {
    Employee JOHN = new Employee("JOHN");
    Employee ANNA = new Employee("ANNA");
    Employee ROB = new Employee("ROB");
    Employee LUCAS = new Employee("LUCAS");

    HolidayCalculator calculator = new HolidayCalculator(SampleAvivaEmployees.AVIVA_EMPLOYEES, SampleAvivaHolidays.AVIVA_HOLIDAYS);
    List<Employee> employeeList;
    Month month;

    @Test
    public void getWorkingEmployeesTest(){

        employeeList = new ArrayList<>();
        employeeList.add(JOHN);
        employeeList.add(ANNA);
        employeeList.add(ROB);
        employeeList.add(LUCAS);
        assertEquals(employeeList, calculator.getWorkingEmployees(LocalDate.of(2016, Month.JANUARY, 1), LocalDate.of(2016, Month.DECEMBER, 31)));

        employeeList = new ArrayList<>();
        employeeList.add(LUCAS);
        assertEquals(employeeList, calculator.getWorkingEmployees(LocalDate.of(2017, Month.JANUARY, 1), LocalDate.of(2017, Month.DECEMBER, 31)));

        employeeList = new ArrayList<>();
        employeeList.add(ANNA);
        employeeList.add(LUCAS);
        assertEquals(employeeList, calculator.getWorkingEmployees(LocalDate.of(2017, Month.AUGUST, 8), LocalDate.of(2017, Month.AUGUST, 12)));

        employeeList = new ArrayList<>();
        employeeList.add(LUCAS);
        assertEquals(employeeList, calculator.getWorkingEmployees(LocalDate.of(2017, Month.JULY, 13), LocalDate.of(2017, Month.AUGUST, 1)));

    }

    @Test
    public void getHolidayMonthTest(){
        month = Month.AUGUST;
        assertEquals(month, calculator.getHolidayMonth(2017));

    }

    @Test(expected = MonthException.class)
    public void getHolidayMonthExceptionTest(){

        calculator.getHolidayMonth(2010);

    }

}
