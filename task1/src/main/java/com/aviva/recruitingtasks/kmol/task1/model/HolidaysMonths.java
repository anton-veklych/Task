package com.aviva.recruitingtasks.kmol.task1.model;


import java.time.Month;

public class HolidaysMonths {

    private Month month;

    private int countHolidays;

    public void setMonth(Month month) {
        this.month = month;
    }

    public void setCountHolidays(int countHolidays) {
        this.countHolidays = countHolidays;
    }

    public Month getMonth() {
        return month;
    }

    public int getCountHolidays() {
        return countHolidays;
    }
}
