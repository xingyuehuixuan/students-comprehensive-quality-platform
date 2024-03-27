package com.example.studentscomprehensivequalityplatform.mapper;

import com.example.studentscomprehensivequalityplatform.pojo.entity.StudentsActivities;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentActivityMapper {
    /**
     *插入学生报名活动
     * @param studentsActivities
     */
    @Insert("insert into students_activities(activity_id, student_id, create_time) " +
            "values (#{activityId}, #{studentId}, #{createTime})")
    void insert(StudentsActivities studentsActivities);

    /**
     * 根据学生ID查询
     * @param studentId
     * @return
     */
    @Select("select activity_id from students_activities where student_id = #{studentId}")
    List<Integer> getById(Integer studentId);

    /**
     * 根据学生ID和活动ID删除
     * @param activityId
     * @param studentId
     */
    @Delete("delete from students_activities where student_id = #{studentId} and activity_id = #{activityId}")
    void deleteById(Integer activityId, Integer studentId);
}
