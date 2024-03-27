package com.example.studentscomprehensivequalityplatform.service.students.impl;

import com.example.studentscomprehensivequalityplatform.common.constant.MessageConstant;
import com.example.studentscomprehensivequalityplatform.common.constant.StatusConstant;
import com.example.studentscomprehensivequalityplatform.common.exception.ActivitySignUpFailedException;
import com.example.studentscomprehensivequalityplatform.common.exception.CancelRegistrationFailedException;
import com.example.studentscomprehensivequalityplatform.common.result.PageResult;
import com.example.studentscomprehensivequalityplatform.mapper.ActivityMapper;
import com.example.studentscomprehensivequalityplatform.mapper.StudentActivityMapper;
import com.example.studentscomprehensivequalityplatform.mapper.StudentMapper;
import com.example.studentscomprehensivequalityplatform.pojo.dto.*;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Activities;
import com.example.studentscomprehensivequalityplatform.pojo.entity.StudentsActivities;
import com.example.studentscomprehensivequalityplatform.pojo.vo.RegisteredStudentsVO;
import com.example.studentscomprehensivequalityplatform.service.students.ActivityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class  ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private StudentActivityMapper studentActivityMapper;

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页查询
     * @param activityPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(ActivityPageQueryDTO activityPageQueryDTO) {
        PageHelper.startPage(activityPageQueryDTO.getPage(), activityPageQueryDTO.getPageSize());
        Page<Activities> page = activityMapper.pageQuery(activityPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 已报活动分页查询
     * @param registeredActivityPageQueryDTO
     * @return
     */
    @Override
    public PageResult registeredPageQuery(RegisteredActivityPageQueryDTO registeredActivityPageQueryDTO) {
        PageHelper.startPage(registeredActivityPageQueryDTO.getPage(), registeredActivityPageQueryDTO.getPageSize());
        Page<Activities> page = activityMapper.registeredPageQuery(registeredActivityPageQueryDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 已报名人员名单查询
     * @param activityId
     * @return
     */
    @Override
    public RegisteredStudentsVO registeredStudentPageQuery(Integer activityId) {
        Activities activities = activityMapper.getById(activityId);
        if (Objects.equals(activities.getStatus(), StatusConstant.PREPARATORY_PHASE)){
            return null;
        }
        RegisteredStudentsVO registeredStudentsVO = studentMapper.getById(activityId);
        return registeredStudentsVO;
    }

    /**
     * 根据ID查询活动信息
     * @param id
     * @return
     */
    @Override
    public Activities getById(Integer id) {
        Activities activities = activityMapper.getById(id);
        return activities;
    }

    /**
     * 学生报名活动
     * @param studentSignUpActivityDTO
     */
    @Override
    public void signUp(StudentSignUpActivityDTO studentSignUpActivityDTO) {
        Activities activities = activityMapper.getById(studentSignUpActivityDTO.getActivityId());
        if (!Objects.equals(activities.getStatus(), StatusConstant.SIGNUP_PHASE)){
            throw new ActivitySignUpFailedException(MessageConstant.NOT_IN_SIGNUP_STAGE);
        }
        StudentsActivities studentsActivities = new StudentsActivities();
        BeanUtils.copyProperties(studentSignUpActivityDTO,studentsActivities);
        studentsActivities.setCreateTime(LocalDateTime.now());
        studentActivityMapper.insert(studentsActivities);
    }


    /**
     *学生取消报名
     * @param studentsCancelRegistrationDTO
     */
    @Override
    public void deleteById(StudentsCancelRegistrationDTO studentsCancelRegistrationDTO) {
        Activities activities = activityMapper.getById(studentsCancelRegistrationDTO.getActivityId());
        if (!Objects.equals(activities.getStatus(), StatusConstant.SIGNUP_PHASE)){
            throw new CancelRegistrationFailedException(MessageConstant.NOT_IN_SIGNUP_STAGE);
        }
        studentActivityMapper.deleteById(studentsCancelRegistrationDTO.getActivityId(),
                studentsCancelRegistrationDTO.getStudentId());
    }


}
