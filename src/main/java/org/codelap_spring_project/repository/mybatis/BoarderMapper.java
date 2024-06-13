package org.codelap_spring_project.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.codelap_spring_project.domain.Boarder;
import org.codelap_spring_project.domain.BoarderMain;
import org.codelap_spring_project.domain.Comment;

import java.util.List;

@Mapper
public interface BoarderMapper {


    List<BoarderMain> findAll(@Param("startRow") Integer startRow, @Param("endRow") Integer endRow);
    int totalPage();

    List<Boarder> detailBoard(String id);

    List<Comment> detailBoardComment(String id);


    void save(Boarder boarder);
    Boarder findById(Long id);
    void update(Boarder boarder);
    List<Boarder> findByNameAndPrice(@Param("itemName") String itemName, @Param("price") Integer price);
}
