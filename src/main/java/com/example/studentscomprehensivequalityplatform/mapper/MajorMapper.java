package com.example.studentscomprehensivequalityplatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MajorMapper {

    /**
     * 根据ID查询专业名称
     * @param majorId
     * @return
     */
    @Select("select name from major where id = #{majorId}")
    String getNameById(Integer majorId);

    /**
     * 根据名称查询ID
     * @param major
     * @return
     */
    @Select("select id from major where name = #{major}")
    Integer getIdByName(String major);
}
