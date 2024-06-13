package org.codelap_spring_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @RequestMapping("/")
//    @CrossOrigin(origins = {"http://localhost:3001","http://192.168.0.23:3000"},methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
    public String home() {
        return "redirect:/boarder";
    }
}