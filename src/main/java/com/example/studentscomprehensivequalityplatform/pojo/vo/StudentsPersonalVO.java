package com.example.studentscomprehensivequalityplatform.pojo.vo;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class StudentsPersonalVO {
    private Integer id;
    private String accountNumber;
    private String password;
    private String username;
    private String email;
    private String phone;
    private String name;
    private Integer gender;
    private Integer identityStatus;
    private String college;
    private String major;
    private String personalProfile;
    private Integer grade;
    private String studentNumber;
}
