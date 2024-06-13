package org.codelap_spring_project.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.codelap_spring_project.domain.Boarder;
import org.codelap_spring_project.domain.BoarderMain;

import java.util.List;

@Mapper
public interface BoarderMapper {

    void save(Boarder boarder);

    Boarder findById(Long id);

    List<BoarderMain> findAll(@Param("startRow") Integer startRow, @Param("endRow") Integer endRow);

    void update(Boarder boarder);

    int totalPage();

    List<Boarder> findByNameAndPrice(@Param("itemName") String itemName, @Param("price") Integer price);
}
