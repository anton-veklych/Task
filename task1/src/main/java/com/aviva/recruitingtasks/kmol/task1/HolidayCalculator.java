package com.aviva.recruitingtasks.kmol.task1;

import com.aviva.recruitingtasks.kmol.task1.model.Employee;
import com.aviva.recruitingtasks.kmol.task1.model.Holiday;
import com.aviva.recruitingtasks.kmol.task1.sampledata.MonthException;
import com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaEmployees;
import com.aviva.recruitingtasks.kmol.task1.sampledata.SampleAvivaHolidays;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HolidayCalculator {

    private  List<Employee> employees;
    private  List<Holiday> holidays;
    private Map<Month, Integer> monthsMap;

    public HolidayCalculator(List<Employee> employees, List<Holiday> holidays) {
        this.employees = employees;
        this.holidays = holidays;
    }

    public List<Employee> getWorkingEmployees(LocalDate dateFrom, LocalDate dateTo) {
        holidays = SampleAvivaHolidays.AVIVA_HOLIDAYS;
        employees = SampleAvivaEmployees.AVIVA_EMPLOYEES;
        List<Employee> tempList = new ArrayList<>();
        List<Employee> getEmployeeList = new ArrayList<>();
        LocalDate holidayDateFrom;
        LocalDate holidayDateTo;

        for (int i = 0; i < holidays.size(); i++) {
            holidayDateFrom = holidays.get(i).getDateFrom();
            holidayDateTo = holidays.get(i).getDateTo();
            if((holidayDateFrom.isEqual(dateFrom) | holidayDateFrom.isAfter(dateFrom)) & (holidayDateFrom.isEqual(dateTo) | holidayDateFrom.isBefore(dateTo))){
                tempList.add(holidays.get(i).getEmployee());
            }else{
                if((holidayDateTo.isEqual(dateFrom) | holidayDateTo.isAfter(dateFrom)) & (holidayDateTo.isEqual(dateTo) | holidayDateTo.isBefore(dateTo))){
                    tempList.add(holidays.get(i).getEmployee());
                }
            }
        }

        for (int i = 0; i < employees.size(); i++) {
            if(!tempList.contains(employees.get(i))) {
                getEmployeeList.add(employees.get(i));
            }
        }
        //throw new UnsupportedOperationException();
        return getEmployeeList;
    }

    public Month getHolidayMonth(int year) throws MonthException{
        holidays = SampleAvivaHolidays.AVIVA_HOLIDAYS;
        monthsMap = new HashMap<>();
        Month month = Month.JANUARY;
        int temp = 0;
        for (int i = 1; i < 13; i++) {
            monthsMap.put(Month.of(i), 0);
        }

        for (int i = 0; i < holidays.size(); i++) {
            if(holidays.get(i).getDateFrom().getYear() == year){
                temp = monthsMap.get(holidays.get(i).getDateFrom().getMonth());
                monthsMap.put(holidays.get(i).getDateFrom().getMonth(), temp+1);
            }
            if((holidays.get(i).getDateTo().getYear() == year) & (holidays.get(i).getDateTo().getMonth() != holidays.get(i).getDateFrom().getMonth())){
                temp = monthsMap.get(holidays.get(i).getDateTo().getMonth());
                monthsMap.put(holidays.get(i).getDateTo().getMonth(), temp+1);
            }
        }
        temp = 0;
        for (Map.Entry<Month, Integer> entry : monthsMap.entrySet()){
            if(entry.getValue() > temp){
                temp = entry.getValue();
                month = entry.getKey();
            }else {
                if((entry.getValue() == temp) & (entry.getKey().getValue() < month.getValue())){
                    month = entry.getKey();
                }
            }

        }
        if(monthsMap.get(month) == 0){
            throw new MonthException("In this year not holidays");
        }
        //throw new UnsupportedOperationException();
        return month;
    }

}
