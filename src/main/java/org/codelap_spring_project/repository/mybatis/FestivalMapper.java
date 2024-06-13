package org.codelap_spring_project.repository.mybatis;

import org.codelap_spring_project.domain.Festival;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FestivalMapper {


    List<Festival> findAllFestival();

    List<Festival> findAllFestivalth();


}
