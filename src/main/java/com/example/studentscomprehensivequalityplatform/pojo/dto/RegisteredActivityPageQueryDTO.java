package com.example.studentscomprehensivequalityplatform.pojo.dto;

import lombok.Data;

@Data
public class RegisteredActivityPageQueryDTO {
    private Integer page;
    private Integer pageSize;
    private String orgName;
    private String activityName;
    private Integer studentId;
}
