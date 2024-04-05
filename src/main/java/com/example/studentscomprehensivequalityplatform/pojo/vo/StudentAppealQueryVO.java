package com.example.studentscomprehensivequalityplatform.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentAppealQueryVO {
    private Integer stuId;
    private LocalDateTime appealTime;
    private String appealType;
    private String appealObject;
    private String handler;
    private Integer handlePhase;
    private Integer handleResult;
}
