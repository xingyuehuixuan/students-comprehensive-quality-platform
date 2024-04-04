package com.example.studentscomprehensivequalityplatform.pojo.dto;

import lombok.Data;

@Data
public class StudentUpdateDTO {
    private String username;
    private String email;
    private String password;
    private String phone;
    private String college;
    private String major;
    private String personalProfile;
}
