package com.two.lamps.psy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/calendar")
    public String calendar(Model model) {
        model.addAttribute("event", "{\n" +
                "\t\t\t\t\ttitle: 'Specialist name',\n" +
                "\t\t\t\t\tstart: new Date(2018, 9, 23, 13, 0),\n" +
                "\t\t\t\t\tend: new Date(2018, 9, 23, 14, 0),\n" +
                "\t\t\t\t\tallDay: false,\n" +
                "\t\t\t\t\tclassName: 'info'\n" +
                "\t\t\t\t}");
        return "fullcalendar";
    }

}
