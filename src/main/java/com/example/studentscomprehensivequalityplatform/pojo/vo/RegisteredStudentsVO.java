package com.example.studentscomprehensivequalityplatform.pojo.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegisteredStudentsVO {
    private Integer id;
    private String studentNumber;
    private String studentName;
    private String collegeName;
    private String majorName;
    private Integer grade;
    private Integer gender;
    private LocalDateTime signingTime;
}
