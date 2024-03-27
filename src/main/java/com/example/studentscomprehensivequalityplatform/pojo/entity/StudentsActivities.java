package com.example.studentscomprehensivequalityplatform.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentsActivities {
    private Integer id;
    private Integer activityId;
    private Integer studentId;
    private LocalDateTime createTime;
}
