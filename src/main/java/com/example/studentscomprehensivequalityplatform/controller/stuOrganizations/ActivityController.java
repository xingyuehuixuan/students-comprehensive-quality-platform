package com.example.studentscomprehensivequalityplatform.controller.stuOrganizations;

import com.example.studentscomprehensivequalityplatform.common.result.PageResult;
import com.example.studentscomprehensivequalityplatform.common.result.Result;
import com.example.studentscomprehensivequalityplatform.pojo.dto.PublishActivityDTO;
import com.example.studentscomprehensivequalityplatform.pojo.dto.PublishedActivityPageDTO;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Activities;
import com.example.studentscomprehensivequalityplatform.service.stuOrganizations.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("stuOrganizationsActivityController")
@RequestMapping("/stuOrganization/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    /**
     * 已发布活动分页查询
     * @param publishedActivityPageDTO
     * @return
     */
    @GetMapping("/publishedActivitiesPage")
    public Result<PageResult> publishedActivitiesPage(PublishedActivityPageDTO publishedActivityPageDTO){
        PageResult pageResult = activityService.publishedActivitiesPage(publishedActivityPageDTO);
        return Result.success(pageResult);
    }

    /**
     * 发布活动
     * @param publishActivityDTO
     * @return
     */
    @PostMapping("/publishActivity")
    public Result publishActivity(@RequestBody PublishActivityDTO publishActivityDTO){
        activityService.publishActivity(publishActivityDTO);
        return Result.success();
    }

    /**
     * 修改活动
     * @param activities
     * @return
     */
    @PutMapping("/updateActivity")
    public Result updateActivity(@RequestBody Activities activities){
        activityService.updateActivity(activities);
        return Result.success();
    }
}
