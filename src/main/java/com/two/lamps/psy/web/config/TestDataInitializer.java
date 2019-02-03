package com.two.lamps.psy.web.config;

import com.two.lamps.psy.web.model.*;
import com.two.lamps.psy.web.repository.*;
import com.two.lamps.psy.web.service.ifc.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class TestDataInitializer {

    @Autowired
    private ClientService clientService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ConsultationService consultationService;

    private void  init() {

        Position psychotherapist = new Position();
        psychotherapist.setName("Психотерапевт");
        positionService.save(psychotherapist);
        Position psychiatrist = new Position();
        psychiatrist.setName("Психиатр");
        positionService.save(psychiatrist);

        Service psychotherapistConsultation = new Service();
        psychotherapistConsultation.setName("Консультация психолога");
        psychotherapistConsultation.setCost(1800);
        psychotherapistConsultation.setDurationHours(1);
        serviceService.save(psychotherapistConsultation);
        Service psychiatristConsultation = new Service();
        psychiatristConsultation.setName("Консультация психиатра");
        psychiatristConsultation.setCost(2000);
        psychiatristConsultation.setDurationHours(1);
        serviceService.save(psychiatristConsultation);

        Subscription psychotherapistSubscription4 = new Subscription();
        psychotherapistSubscription4.setName("Абонемент на 4 консультации психолога");
        psychotherapistSubscription4.setNumber(4);
        psychotherapistSubscription4.setService(psychotherapistConsultation);
        subscriptionService.save(psychotherapistSubscription4);

        Client firstClient = new Client();
        firstClient.setFirstName("Павел");
        firstClient.setSurname("Богданов");
        firstClient.setPatronymic("Дмитриевич");
        firstClient.setPassword("1234");
        firstClient.setPhoneNumber("+79111483513");
        firstClient.setLogin("Pavel777");
        firstClient.setRole(Client.ROLE);
        clientService.save(firstClient);

        Client secondClient = new Client();
        secondClient.setFirstName("Богдан");
        secondClient.setSurname("Павлов");
        secondClient.setPatronymic("Дмитриевич");
        secondClient.setPassword("4321");
        secondClient.setPhoneNumber("+79111483513");
        secondClient.setLogin("Bogdan888");
        secondClient.setRole(Client.ROLE);
        clientService.save(secondClient);

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
        employeeService.save(firstEmployee);

        Consultation firstConsultation = new Consultation();
        firstConsultation.setEmployee(firstEmployee);
        firstConsultation.setClient(firstClient);
        firstConsultation.setService(psychotherapistConsultation);
        firstConsultation.setDate(LocalDateTime.of(2018, 11, 27, 20, 0));
        consultationService.save(firstConsultation);

        Consultation secondConsultation = new Consultation();
        secondConsultation.setEmployee(firstEmployee);
        secondConsultation.setClient(firstClient);
        secondConsultation.setService(psychotherapistConsultation);
        secondConsultation.setDate(LocalDateTime.of(2018, 11, 27, 21, 0));
        consultationService.save(secondConsultation);
    }
}
