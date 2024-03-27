package com.example.studentscomprehensivequalityplatform.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;

@Mapper
public interface StuOrganizationActivityMapper {

    /**
     * 插入学生组织和活动关系
     *
     * @param id
     * @param orgId
     * @param createTime
     */
    @Insert("insert into stu_organization_activities (org_id, activity_id, create_time) VALUES " +
            "(#{orgId}, #{id}, #{createTime})")
    void insert(Integer id, Integer orgId, LocalDateTime createTime);
}
