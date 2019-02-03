package com.two.lamps.psy.web.util.frontend;

import com.two.lamps.psy.web.model.Consultation;

import java.time.LocalDateTime;

public class EventObjectInformationCollector {

    public static EventObject getEventObject(Consultation consultation, String title) {
        LocalDateTime dateTime = consultation.getDate();
        EventDateObject startDate = new EventDateObject(dateTime.getYear(), dateTime.getMonth().getValue(),
                dateTime.getDayOfMonth(), dateTime.getHour(), dateTime.getMinute());
        EventDateObject endDate = new EventDateObject(dateTime.getYear(), dateTime.getMonth().getValue(),
                dateTime.getDayOfMonth(), dateTime.getHour() + consultation.getService().getDurationHours(),
                dateTime.getMinute());
        String className = getClassName(consultation);
        EventObject eventObject = new EventObject(title, startDate, endDate, className);
        return eventObject;
    }

    private static String getClassName(Consultation consultation) {
        boolean remote = consultation.getService().isRemote();
        boolean isFullyPaid = consultation.isFullyPaid();
        boolean isPast = consultation.getDate().plusHours(consultation.getService().getDurationHours())
                .compareTo(LocalDateTime.now()) < 0;
        if (isPast) {
            if (isFullyPaid) {
                return EventConstants.FULLY_PAID_STYLE;
            }
            return EventConstants.NOT_PAID_STYLE;
        }
        if (remote) {
            return EventConstants.REMOTE_STYLE;
        }
        return EventConstants.PLANNED_STYLE;
    }

}
