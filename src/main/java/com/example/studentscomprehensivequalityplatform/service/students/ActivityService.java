package com.example.studentscomprehensivequalityplatform.service.students;

import com.example.studentscomprehensivequalityplatform.common.result.PageResult;
import com.example.studentscomprehensivequalityplatform.pojo.dto.*;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Activities;
import com.example.studentscomprehensivequalityplatform.pojo.vo.RegisteredStudentsVO;

public interface ActivityService {

    /**
     *分页查询
     * @param activityPageQueryDTO
     * @return
     */
    PageResult pageQuery(ActivityPageQueryDTO activityPageQueryDTO);

    /**
     *根据ID查询活动信息
     * @param id
     * @return
     */
    Activities getById(Integer id);

    /**
     * 学生报名活动
     * @param activityId
     */
    void signUp(Integer activityId);

    /**
     * 已报活动分页查询
     * @param activityPageQueryDTO
     * @return
     */
    PageResult registeredPageQuery(ActivityPageQueryDTO activityPageQueryDTO);

    /**
     * 学生取消报名
     * @param activityId
     */
    void deleteById(Integer activityId);

    /**
     * 已报名人员名单分页查询
     * @param activityId
     * @return
     */
    RegisteredStudentsVO registeredStudentPageQuery(Integer activityId);
}
