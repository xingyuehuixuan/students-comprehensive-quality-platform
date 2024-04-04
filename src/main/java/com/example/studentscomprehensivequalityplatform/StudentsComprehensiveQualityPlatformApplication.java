package com.example.studentscomprehensivequalityplatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableTransactionManagement
public class StudentsComprehensiveQualityPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsComprehensiveQualityPlatformApplication.class, args);
    }

}
