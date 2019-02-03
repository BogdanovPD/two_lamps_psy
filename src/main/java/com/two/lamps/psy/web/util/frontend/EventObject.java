package com.two.lamps.psy.web.util.frontend;

public class EventObject {

    private static final String TEMPLATE = "{\n" +
            "\t\t\t\t\ttitle: '%s',\n" +
            "\t\t\t\t\tstart: %s,\n" +
            "\t\t\t\t\tend: %s,\n" +
            "\t\t\t\t\tallDay: false,\n" +
            "\t\t\t\t\tclassName: '%s'\n" +
            "\t\t\t\t}";

    private String title;
    private EventDateObject start;
    private EventDateObject end;
    private String className;

    public EventObject(String title, EventDateObject start, EventDateObject end, String className) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.className = className;
    }

    public String getEvent() {
        return String.format(TEMPLATE, title, start.getEventDate(), end.getEventDate(), className);
    }
}
