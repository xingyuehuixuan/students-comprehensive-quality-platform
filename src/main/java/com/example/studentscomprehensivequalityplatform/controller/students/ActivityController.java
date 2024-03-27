package com.example.studentscomprehensivequalityplatform.controller.students;

import com.example.studentscomprehensivequalityplatform.common.result.PageResult;
import com.example.studentscomprehensivequalityplatform.common.result.Result;
import com.example.studentscomprehensivequalityplatform.pojo.dto.*;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Activities;
import com.example.studentscomprehensivequalityplatform.pojo.vo.RegisteredStudentsVO;
import com.example.studentscomprehensivequalityplatform.service.students.ActivityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students/activities")
@Slf4j
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    /**
     * 活动广场分页查询
     * @param activityPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result<PageResult> page(ActivityPageQueryDTO activityPageQueryDTO){
        log.info("分页查询：{}", activityPageQueryDTO);
        PageResult pageResult =activityService.pageQuery(activityPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 已报活动分页查询
     * @param registeredActivityPageQueryDTO
     * @return
     */
    @GetMapping("/registeredPage")
    public Result<PageResult> registeredPage(RegisteredActivityPageQueryDTO registeredActivityPageQueryDTO){
        PageResult pageResult = activityService.registeredPageQuery(registeredActivityPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 已报名人员名单分页查询
     * @param activityId
     * @return
     */
    @GetMapping("/registeredStudentsPage")
    public Result<RegisteredStudentsVO> registeredStudentsPage(Integer activityId){
        RegisteredStudentsVO registeredStudentsVO = activityService.registeredStudentPageQuery(activityId);
        return Result.success(registeredStudentsVO);
    }

    /**
     *根据ID查询活动信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Activities> getById(@PathVariable Integer id){
        Activities activities = activityService.getById(id);
        return Result.success(activities);
    }

    /**
     * 学生报名活动
     * @param studentSignUpActivityDTO
     * @return
     */
    @PostMapping("/enrollActivity")
    public Result signUp(@RequestBody StudentSignUpActivityDTO studentSignUpActivityDTO){
        activityService.signUp(studentSignUpActivityDTO);
        return Result.success();
    }

    /**
     * 学生取消报名
     * @param studentsCancelRegistrationDTO
     * @return
     */
    @DeleteMapping("/cancelRegistration")
    public Result deleteById(@RequestBody StudentsCancelRegistrationDTO studentsCancelRegistrationDTO){
        activityService.deleteById(studentsCancelRegistrationDTO);
        return Result.success();
    }
}
