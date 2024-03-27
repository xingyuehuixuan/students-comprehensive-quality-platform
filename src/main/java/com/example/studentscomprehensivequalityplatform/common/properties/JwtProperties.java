package com.example.studentscomprehensivequalityplatform.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "scqp.jwt")
@Data
public class JwtProperties {
    private String studentSecretKey;
    private long studentTtl;
    private String studentTokenName;
    private String stuOrganizationSecretKey;
    private long stuOrganizationTtl;
    private String stuOrganizationTokenName;
    private String teacherSecretKey;
    private long teacherTtl;
    private String teacherTokenName;
}
