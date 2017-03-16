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

        List<Employee> tempList = new ArrayList<>();
        List<Employee> getEmployeeList = new ArrayList<>();
        LocalDate holidayDateFrom;
        LocalDate holidayDateTo;

        for (Holiday holiday : holidays) {
            holidayDateFrom = holiday.getDateFrom();
            holidayDateTo = holiday.getDateTo();
            if((holidayDateFrom.isEqual(dateFrom) | holidayDateFrom.isAfter(dateFrom)) & (holidayDateFrom.isEqual(dateTo) | holidayDateFrom.isBefore(dateTo))){
                tempList.add(holiday.getEmployee());
            }else{
                if((holidayDateTo.isEqual(dateFrom) | holidayDateTo.isAfter(dateFrom)) & (holidayDateTo.isEqual(dateTo) | holidayDateTo.isBefore(dateTo))){
                    tempList.add(holiday.getEmployee());
                }
            }
        }

        for (Employee employee : employees) {
            if(!tempList.contains(employee)) {
                getEmployeeList.add(employee);
            }
        }

        return getEmployeeList;
    }

    public Month getHolidayMonth(int year) throws MonthException{

        monthsMap = new HashMap<>();
        Month month = Month.JANUARY;
        int temp = 0;
        for (int i = 1; i < 13; i++) {
            monthsMap.put(Month.of(i), 0);
        }

        for (Holiday holiday : holidays) {
            if(holiday.getDateFrom().getYear() == year){
                temp = monthsMap.get(holiday.getDateFrom().getMonth());
                monthsMap.put(holiday.getDateFrom().getMonth(), temp+1);
            }
            if((holiday.getDateTo().getYear() == year) & (holiday.getDateTo().getMonth() != holiday.getDateFrom().getMonth())){
                temp = monthsMap.get(holiday.getDateTo().getMonth());
                monthsMap.put(holiday.getDateTo().getMonth(), temp+1);
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

        return month;
    }

}
