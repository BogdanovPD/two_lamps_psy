package com.two.lamps.psy.web.config;

import com.two.lamps.psy.web.model.*;
import com.two.lamps.psy.web.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class TestDataInitializer {

    @Autowired
    private ClientDao clientDao;
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private ServiceDao serviceDao;
    @Autowired
    private SubscriptionDao subscriptionDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private ConsultationDao consultationDao;

    private void  init() {

        Position psychotherapist = new Position();
        psychotherapist.setName("Психотерапевт");
        positionDao.save(psychotherapist);
        Position psychiatrist = new Position();
        psychiatrist.setName("Психиатр");
        positionDao.save(psychiatrist);

        Service psychotherapistConsultation = new Service();
        psychotherapistConsultation.setName("Консультация психолога");
        psychotherapistConsultation.setCost(1800);
        psychotherapistConsultation.setDurationHours(1);
        serviceDao.save(psychotherapistConsultation);
        Service psychiatristConsultation = new Service();
        psychiatristConsultation.setName("Консультация психиатра");
        psychiatristConsultation.setCost(2000);
        psychiatristConsultation.setDurationHours(1);
        serviceDao.save(psychiatristConsultation);

        Subscription psychotherapistSubscription4 = new Subscription();
        psychotherapistSubscription4.setName("Абонемент на 4 консультации психолога");
        psychotherapistSubscription4.setNumber(4);
        psychotherapistSubscription4.setService(psychotherapistConsultation);
        subscriptionDao.save(psychotherapistSubscription4);

        Client firstClient = new Client();
        firstClient.setFirstName("Павел");
        firstClient.setSurname("Богданов");
        firstClient.setPatronymic("Дмитриевич");
        firstClient.setPassword("1234");
        firstClient.setPhoneNumber("+79111483513");
        firstClient.setLogin("Pavel777");
        firstClient.setRole(Client.ROLE);
        clientDao.save(firstClient);

        Client secondClient = new Client();
        secondClient.setFirstName("Богдан");
        secondClient.setSurname("Павлов");
        secondClient.setPatronymic("Дмитриевич");
        secondClient.setPassword("4321");
        secondClient.setPhoneNumber("+79111483513");
        secondClient.setLogin("Bogdan888");
        secondClient.setRole(Client.ROLE);
        clientDao.save(secondClient);

        Employee firstEmployee = new Employee();
        firstEmployee.setFirstName("Елизавета");
        firstEmployee.setSurname("Богданова");
        firstEmployee.setPassword("7587");
        firstEmployee.setPhoneNumber("+79111457587");
        firstEmployee.setLogin("Elizaaveeta");
        firstEmployee.setRole(Employee.ROLE);
        firstEmployee.setPosition(psychotherapist);
        firstEmployee.getClients().add(firstClient);
        firstEmployee.getClients().add(secondClient);
        employeeDao.save(firstEmployee);

        Consultation firstConsultation = new Consultation();
        firstConsultation.setEmployee(firstEmployee);
        firstConsultation.setClient(firstClient);
        firstConsultation.setService(psychotherapistConsultation);
        firstConsultation.setDate(LocalDateTime.now());
        consultationDao.save(firstConsultation);

        Consultation secondConsultation = new Consultation();
        secondConsultation.setEmployee(firstEmployee);
        secondConsultation.setClient(firstClient);
        secondConsultation.setService(psychotherapistConsultation);
        secondConsultation.setDate(LocalDateTime.now());
        consultationDao.save(secondConsultation);
    }
}
