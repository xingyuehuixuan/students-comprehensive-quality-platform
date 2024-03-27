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
public class StuOrganization {
    private Integer id;
    private String accountNumber;
    private String password;
    private String orgName;
    private String affiliateUnit;
    private String principal;
    private Integer level;
    private String adviser;
    private String orgProfile;
    private LocalDateTime updateTime;
    private String email;
}
