package com.two.lamps.psy.web.controller;

import com.two.lamps.psy.web.model.Consultation;
import com.two.lamps.psy.web.service.ifc.ClientService;
import com.two.lamps.psy.web.service.ifc.ConsultationService;
import com.two.lamps.psy.web.util.frontend.EventObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class ClientController {

    private ClientService clientService;
    private ConsultationService consultationService;

    @Autowired
    public ClientController(ClientService clientService, ConsultationService consultationService) {
        this.clientService = clientService;
        this.consultationService = consultationService;
    }

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/calendar")
    public String calendar(Model model) {
        List<Consultation> consultations = consultationService.getAllConsultations();
        Set<EventObject> eventObjects = consultationService.getClientEventObjects(consultations);
        //System.out.println(eventObjects);
        model.addAttribute("events",
                eventObjects.iterator().next().getEvent());
//        model.addAttribute("event", "{\n" +
//                "\t\t\t\t\ttitle: 'Specialist name',\n" +
//                "\t\t\t\t\tstart: new Date(2018, 9, 23, 13, 0),\n" +
//                "\t\t\t\t\tend: new Date(2018, 9, 23, 14, 0),\n" +
//                "\t\t\t\t\tallDay: false,\n" +
//                "\t\t\t\t\tclassName: 'info'\n" +
//                "\t\t\t\t}");
        return "fullcalendar";
    }

}
