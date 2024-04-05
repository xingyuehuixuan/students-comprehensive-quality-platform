package com.example.studentscomprehensivequalityplatform.mapper;

import com.example.studentscomprehensivequalityplatform.pojo.entity.Appeal;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentAppealQueryVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AppealMapper {

    /**
     * 申诉查询
     * @param stuId
     * @return
     */
    @Select("select stu_id, create_time as appeal_time, appeal_type, appeal_object, handler, handle_phase, handle_result" +
            " from appeal where stu_id = #{stuId}")
    List<StudentAppealQueryVO> appealQuery(Integer stuId);

    /**
     * 根据ID查询申诉
     * @param id
     * @return
     */
    @Select("select * from appeal where id = #{id}")
    Appeal getById(Integer id);

    /**
     * 提交申诉
     * @param appeal
     */
    @Insert("insert into appeal(stu_id, stu_name, college_name, stu_number, major_name, appeal_type, appeal_object, " +
            "description, appeal_document, create_time, handler, handle_phase, handle_result, reject_reason, handle_time) " +
            "values (#{stuId}, #{stuName}, #{collegeName}, #{stuNumber}, #{majorName}, #{appealType}, #{appealObject}, " +
            "#{description}, #{appealDocument}, #{createTime}, #{handler}, #{handlePhase}, #{handleResult}, " +
            "#{rejectReason}, #{handleTime})")
    void insert(Appeal appeal);
}
