package com.example.studentscomprehensivequalityplatform.pojo.dto;

import lombok.Data;

@Data
public class ActivityPageQueryDTO {
    private Integer page;
    private Integer pageSize;
    private String orgName;
    private String activityName;
}
