package com.example.studentscomprehensivequalityplatform.mapper;

import com.example.studentscomprehensivequalityplatform.pojo.dto.ActivityPageQueryDTO;
import com.example.studentscomprehensivequalityplatform.pojo.dto.PublishedActivityPageDTO;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Activities;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ActivityMapper {

    /**
     * 分页查询
     * @param activityPageQueryDTO
     * @return
     */
    Page<Activities> pageQuery(ActivityPageQueryDTO activityPageQueryDTO);

    /**
     *根据ID查询活动信息
     * @param id
     * @return
     */
    @Select("select * from activities where id = #{id}")
    Activities getById(Integer id);

    /**
     * 已报活动分页查询
     * @param activityPageQueryDTO
     * @return
     */
    Page<Activities> registeredPageQuery(ActivityPageQueryDTO activityPageQueryDTO, Integer id);

    /**
     * 已发布活动分页查询
     * @param publishedActivityPageDTO
     * @return
     */
    Page<Activities> publishedActivitiesPage(PublishedActivityPageDTO publishedActivityPageDTO, Integer id);

    /**
     * 发布活动
     * @param activities
     */
    void publishActivity(Activities activities);

    /**
     * 修改活动
     * @param activities
     */
    void updateActivity(Activities activities);
}
