package com.example.studentscomprehensivequalityplatform.pojo.dto;

import lombok.Data;

@Data
public class SubmitAppealDTO {
    private String appealType;
    private String appealObject;
    private String description;
    private String appealDocument;
}
