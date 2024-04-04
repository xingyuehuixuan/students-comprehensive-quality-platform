package com.example.studentscomprehensivequalityplatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CollegeMapper {

    /**
     * 根据ID查询学院名称
     * @param collegeId
     * @return
     */
    @Select("select name from college where id = #{collegeId}")
    String getNameById(Integer collegeId);

    /**
     * 根据名称查询ID
     * @param college
     * @return
     */
    @Select("select id from college where name = #{college}")
    Integer getIdByName(String college);
}
