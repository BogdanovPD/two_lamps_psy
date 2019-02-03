package com.two.lamps.psy.web.service.ifc;

import com.two.lamps.psy.web.model.Consultation;
import com.two.lamps.psy.web.util.frontend.EventObject;

import java.util.List;
import java.util.Set;

public interface ConsultationService {

    void save(Consultation consultation);
    void delete(Consultation consultation);
    List<Consultation> getAllConsultations();

    EventObject getClientEventObject(Consultation consultation);
    EventObject getEmployeeEventObject(Consultation consultation);
    Set<EventObject> getClientEventObjects(Iterable<Consultation> consultations);
    Set<EventObject> getEmployeeEventObjects(Iterable<Consultation> consultations);

}
