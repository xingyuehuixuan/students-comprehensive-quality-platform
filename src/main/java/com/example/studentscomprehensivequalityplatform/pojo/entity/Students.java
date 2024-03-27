package com.example.studentscomprehensivequalityplatform.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Students {
    private Integer id;
    private String accountNumber;
    private String password;
    private String username;
    private String email;
    private String phone;
    private String name;
    private Integer gender;
    private Integer identityStatus;
    private Integer collegeId;
    private Integer majorId;
    private String personalProfile;
    private LocalDateTime updateTime;
    private String position;
    private Integer grade;
    private String studentNumber;
}
