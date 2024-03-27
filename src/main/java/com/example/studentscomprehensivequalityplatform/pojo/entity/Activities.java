package com.example.studentscomprehensivequalityplatform.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activities {
    private Integer id;
    private String activityName;
    private String signingCondition;
    private LocalDate signingStartTime;
    private LocalDate signingEndTime;
    private LocalDate activityStartTime;
    private LocalDate activityEndTime;
    private String orgName;
    private Integer activityLevel;
    private Integer participantNumber;
    private Integer status;
    private String activityProfile;
    private String activityDocument;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
