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
}
