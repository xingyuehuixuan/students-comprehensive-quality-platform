package com.example.studentscomprehensivequalityplatform.service.stuOrganizations.impl;

import com.example.studentscomprehensivequalityplatform.common.constant.StatusConstant;
import com.example.studentscomprehensivequalityplatform.common.result.PageResult;
import com.example.studentscomprehensivequalityplatform.mapper.ActivityMapper;
import com.example.studentscomprehensivequalityplatform.mapper.StuOrganizationActivityMapper;
import com.example.studentscomprehensivequalityplatform.pojo.dto.PublishActivityDTO;
import com.example.studentscomprehensivequalityplatform.pojo.dto.PublishedActivityPageDTO;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Activities;
import com.example.studentscomprehensivequalityplatform.service.stuOrganizations.ActivityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private StuOrganizationActivityMapper stuOrganizationActivityMapper;

    /**
     * 已发布活动分页查询
     * @param publishedActivityPageDTO
     * @return
     */
    @Override
    public PageResult publishedActivitiesPage(PublishedActivityPageDTO publishedActivityPageDTO) {
        PageHelper.startPage(publishedActivityPageDTO.getPage(), publishedActivityPageDTO.getPageSize());
        Page<Activities> page = activityMapper.publishedActivitiesPage(publishedActivityPageDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 发布活动
     * @param publishActivityDTO
     */
    @Override
    public void publishActivity(PublishActivityDTO publishActivityDTO) {
        Activities activities = new Activities();
        BeanUtils.copyProperties(publishActivityDTO, activities);
        activities.setStatus(StatusConstant.PREPARATORY_PHASE);
        activities.setCreateTime(LocalDateTime.now());
        activities.setUpdateTime(LocalDateTime.now());
        activityMapper.publishActivity(activities);
        Integer id = activities.getId();
        stuOrganizationActivityMapper.insert(id, publishActivityDTO.getOrgId(), activities.getCreateTime());
    }

    /**
     * 修改活动
     * @param activities
     */
    @Override
    public void updateActivity(Activities activities) {
        activities.setUpdateTime(LocalDateTime.now());
        activityMapper.updateActivity(activities);
    }
}
