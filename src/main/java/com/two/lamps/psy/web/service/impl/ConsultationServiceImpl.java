package com.two.lamps.psy.web.service.impl;

import com.two.lamps.psy.web.model.Consultation;
import com.two.lamps.psy.web.repository.ConsultationDao;
import com.two.lamps.psy.web.service.ifc.ConsultationService;
import com.two.lamps.psy.web.util.frontend.EventDateObject;
import com.two.lamps.psy.web.util.frontend.EventObject;
import com.two.lamps.psy.web.util.frontend.EventObjectInformationCollector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    private ConsultationDao consultationDao;

    @Autowired
    public ConsultationServiceImpl(ConsultationDao consultationDao) {
        this.consultationDao = consultationDao;
    }

    @Override
    public void save(Consultation consultation) {
        consultationDao.save(consultation);
    }

    @Override
    public void delete(Consultation consultation) {
        consultationDao.delete(consultation);
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationDao.findAll();
    }

    @Override
    public EventObject getClientEventObject(Consultation consultation) {
        String template = "%s (%s)";
        String title = String.format(template, consultation.getService().getName(),
                consultation.getEmployee().getSurnameAndInitials());
        return EventObjectInformationCollector.getEventObject(consultation, title);
    }

    @Override
    public EventObject getEmployeeEventObject(Consultation consultation) {
        String template = "%s";
        String title = String.format(template, consultation.getClient().getSurnameAndInitials());
        return EventObjectInformationCollector.getEventObject(consultation, title);
    }

    @Override
    public Set<EventObject> getClientEventObjects(Iterable<Consultation> consultations) {
        Set<EventObject> eventObjects = new HashSet<>();
        consultations.forEach(c -> {
            eventObjects.add(getClientEventObject(c));
        });
        return eventObjects;
    }

    @Override
    public Set<EventObject> getEmployeeEventObjects(Iterable<Consultation> consultations) {
        Set<EventObject> eventObjects = new HashSet<>();
        consultations.forEach(c -> {
            eventObjects.add(getEmployeeEventObject(c));
        });
        return eventObjects;
    }
}
