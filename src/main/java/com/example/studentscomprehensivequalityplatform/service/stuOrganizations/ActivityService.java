package com.example.studentscomprehensivequalityplatform.service.stuOrganizations;

import com.example.studentscomprehensivequalityplatform.common.result.PageResult;
import com.example.studentscomprehensivequalityplatform.pojo.dto.PublishActivityDTO;
import com.example.studentscomprehensivequalityplatform.pojo.dto.PublishedActivityPageDTO;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Activities;

public interface ActivityService {

    /**
     * 已发布活动分页查询
     * @param publishedActivityPageDTO
     * @return
     */
    PageResult publishedActivitiesPage(PublishedActivityPageDTO publishedActivityPageDTO);

    /**
     * 发布活动
     * @param publishActivityDTO
     */
    void publishActivity(PublishActivityDTO publishActivityDTO);

    /**
     * 修改活动
     * @param activities
     */
    void updateActivity(Activities activities);
}
