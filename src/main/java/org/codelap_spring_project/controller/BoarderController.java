package org.codelap_spring_project.controller;

import org.codelap_spring_project.domain.BoarderMain;
import org.codelap_spring_project.repository.mybatis.BoarderMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3001",allowCredentials = "true",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/boarder")
public class BoarderController {

    private final BoarderMapper boarderMapper;

    @Autowired
    public BoarderController(BoarderMapper boarderMapper) {
        this.boarderMapper = boarderMapper;
    }


    @GetMapping(value={"/svboardmain?page","/svboardmain","svboardmain/"})
    public Map<String, Object> list(Model model, @RequestParam(required = false, defaultValue ="1") String page,
                                    @RequestParam(required = false, defaultValue = "1") String user_id) {
        int currentPage = 1;
        if(page != null) {
//            System.out.println("::::::::::::insert" + page);
             currentPage= Integer.parseInt(page);
        }
        int totalPosts = boarderMapper.totalPage();
//        System.out.println(totalPosts);
        int postPerPage = 9;
        int totalPages=  (int)Math.ceil((double)totalPosts/postPerPage);
//        System.out.println(":::::::"+totalPages);
        int startRow = (currentPage -1) * postPerPage +1;
        int endRow = currentPage  * postPerPage;

        List<BoarderMain> boarders;
        boarders = boarderMapper.findAll(startRow, endRow);
        List<List<String>> boarderList = new ArrayList<>();

        for (BoarderMain boarder : boarders) {
            String[] board = new String[9]; // 적절한 크기로 변경해야 함
            board[0] = boarder.getBoarder_code();
            board[1] = boarder.getTitle();// 예시로 한 개의 요소만 담음
            board[2] = boarder.getAuthor();
            board[3] = boarder.getCreated_at();
            board[4] = boarder.getViews();
            board[5] = boarder.getLikes();
            board[6] = boarder.getContent();
            board[7] = boarder.getImage_name();
            board[8] = boarder.getComments_count();
            boarderList.add(Arrays.asList(board));
        }
        System.out.println(boarderList);

        final int MAX_PAGE_LIMIT = 5;
        int startPage = (totalPages - currentPage) < MAX_PAGE_LIMIT ? totalPages - MAX_PAGE_LIMIT + 1 : currentPage;
        if(totalPages<MAX_PAGE_LIMIT){startPage=1;}
        int endPage = Math.min(startPage + MAX_PAGE_LIMIT -1, totalPages);

//
        model.addAttribute("items", boarders);
        Map<String, Object> data = new HashMap<>();
        data.put("board", boarderList); // 배열 형태의 데이터 추가
        data.put("currentPage", currentPage);
        data.put("endPage", endPage);
        data.put("maxPageNumber", MAX_PAGE_LIMIT);
        data.put("startPage", startPage);
        data.put("totalPage", totalPages);
        data.put("userId", "admin");

        return data;
    }

    @GetMapping("/svboarddetail/{id}")
    public String addForm(@PathVariable String id) {

        return "abc";
    }

    @PostMapping("/add")
    public String addItem(@Valid @ModelAttribute org.codelap_spring_project.domain.Boarder boarder, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addForm";
        }
        this.boarderMapper.save(boarder);
        return "redirect:/items";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        org.codelap_spring_project.domain.Boarder boarder = this.boarderMapper.findById(itemId);
        model.addAttribute("item", boarder);
        return "editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String editItem(@PathVariable Long itemId, @Valid @ModelAttribute org.codelap_spring_project.domain.Boarder boarder, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editForm";
        }
//        item.setId(itemId);
        this.boarderMapper.update(boarder);
        return "redirect:/items";
    }

//    @GetMapping("/{itemId}")
//    public String itemDetail(@PathVariable Long itemId, Model model) {
//        Item item = itemMapper.findById(itemId);
//        model.addAttribute("item", item);
//        return "item";
//    }
}
