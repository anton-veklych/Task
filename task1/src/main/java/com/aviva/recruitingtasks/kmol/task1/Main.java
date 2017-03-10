package com.aviva.recruitingtasks.kmol.task1;

import com.aviva.recruitingtasks.kmol.task1.model.Employee;
import com.aviva.recruitingtasks.kmol.task1.sampledata.MonthException;
import com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaEmployees;
import com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaHolidays;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HolidayCalculator calculator = new HolidayCalculator(SampleAvivaEmployees.AVIVA_EMPLOYEES, SampleAvivaHolidays.AVIVA_HOLIDAYS);

        List<Employee> employeeList = calculator.getWorkingEmployees(LocalDate.of(2017, Month.AUGUST, 8), LocalDate.of(2017, Month.AUGUST, 12));
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i).getName());
        }

        try {
            System.out.println(calculator.getHolidayMonth(2017));
        }catch (MonthException e){
            e.printStackTrace();
        }
    }

}
