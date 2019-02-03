package com.two.lamps.psy.web.util.frontend;

public class EventDateObject {

    private static final String TEMPLATE = "new Date(%s, %s, %s, %s, 0)";

    private int year;
    private int month;
    private int day;
    private int hours;
    private int minutes;

    public EventDateObject(int year, int month, int day, int hours, int minutes) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = hours;
        this.minutes = minutes;
    }

    public String getEventDate() {
        return String.format(TEMPLATE, year, month - 1, day, hours, minutes);
    }

}
