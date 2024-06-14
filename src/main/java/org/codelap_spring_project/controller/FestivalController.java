package org.codelap_spring_project.controller;

import org.codelap_spring_project.domain.BoarderMain;
import org.codelap_spring_project.domain.Festival;
import org.codelap_spring_project.repository.mybatis.FestivalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/festival")
public class FestivalController {
    private final FestivalMapper festivalMapper;

    @Autowired
    public FestivalController(FestivalMapper festivalMapper){this.festivalMapper = festivalMapper;}

    @GetMapping("/svfestivalselect")
    public Map<String, Object> festivalListGet(){
        List<Festival> festival;
        festival = festivalMapper.findAllFestival();
        Map<String, Object> result = new HashMap<>();
        result.put("festival",festival);
//        System.out.println(festival+":::::::::::::::");

        List<List<String>> boarderList = new ArrayList<>();

        for (Festival fes : festival) {
            String[] board = new String[11]; // 적절한 크기로 변경해야 함
            board[0] = fes.getFestivalid();
            board[1] = fes.getFestivalname();// 예시로 한 개의 요소만 담음
            board[2] = fes.getLocation();
            board[3] = fes.getStartdate();
            board[4] = fes.getEnddate();
            board[5] = fes.getDescription();
            board[6] = fes.getWebsite();
            board[7] = fes.getRoadaddress();
            board[8] = fes.getJibunaddress();
            board[9] = fes.getLatitude();
            board[10] = fes.getLongitude();
            boarderList.add(Arrays.asList(board));
        }
        result.put("festival", boarderList);

        return result;

     }


}
