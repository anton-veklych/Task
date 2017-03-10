package com.aviva.recruitingtasks.kmol.task1.model;

import java.time.LocalDate;

public class Holiday {

    private Employee employee;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public Holiday(Employee employee, LocalDate dateFrom, LocalDate dateTo) {
        this.employee = employee;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Holiday holiday = (Holiday)o;

        if(dateFrom != null ? !dateFrom.equals(holiday.dateFrom) : holiday.dateFrom != null) return false;
        if(dateTo != null ? !dateTo.equals(holiday.dateTo) : holiday.dateTo != null) return false;
        return employee != null ? employee.equals(holiday.employee) : holiday.employee != null;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }
}
