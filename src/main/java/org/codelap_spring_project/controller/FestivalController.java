package org.codelap_spring_project.controller;

import org.codelap_spring_project.domain.Festival;
import org.codelap_spring_project.repository.mybatis.FestivalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/festival")
public class FestivalController {
    private final FestivalMapper festivalMapper;

    @Autowired
    public FestivalController(FestivalMapper festivalMapper){this.festivalMapper = festivalMapper;}

    @GetMapping
    public List<Festival> festivalListGet(Model model){
        List<Festival> festival;
        festival = festivalMapper.findAllFestivalth();
        model.addAttribute("festivalList", festival);
        System.out.println(festival+":::::::::::::::");

        return festival;

     }


}
