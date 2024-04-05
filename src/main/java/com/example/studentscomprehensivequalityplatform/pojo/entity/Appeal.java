package com.example.studentscomprehensivequalityplatform.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appeal {
    private Integer id;
    private Integer stuId;
    private String stuName;
    private String collegeName;
    private String stuNumber;
    private String majorName;
    private String appealType;
    private String appealObject;
    private String description;
    private String appealDocument;
    private LocalDateTime createTime;
    private String handler;
    private Integer handlePhase;
    private Integer handleResult;
    private String rejectReason;
    private LocalDateTime handleTime;
}
