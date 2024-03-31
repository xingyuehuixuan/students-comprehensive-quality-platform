package com.example.studentscomprehensivequalityplatform.pojo.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PublishActivityDTO {
    private String activityName;
    private String signingCondition;
    private LocalDate signingStartTime;
    private LocalDate signingEndTime;
    private LocalDate activityStartTime;
    private LocalDate activityEndTime;
    private String orgName;
    private Integer activityLevel;
    private Integer participantNumber;
    private String activityProfile;
    private String activityDocument;

}
