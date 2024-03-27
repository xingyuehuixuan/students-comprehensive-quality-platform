package com.example.studentscomprehensivequalityplatform.service.stuOrganizations;

import com.example.studentscomprehensivequalityplatform.common.result.PageResult;
import com.example.studentscomprehensivequalityplatform.pojo.dto.StuOrganizationMemberPageDTO;
import com.example.studentscomprehensivequalityplatform.pojo.entity.StuOrganization;

public interface OrganizationService {

    /**
     * 根据学生组织id查询学生组织信息
     * @param id
     * @return
     */
    StuOrganization getById(Integer id);

    /**
     * 修改学生组织信息
     * @param stuOrganization
     */
    void updateStuOrganization(StuOrganization stuOrganization);

    /**
     * 学生组织成员分页查询
     * @param stuOrganizationMemberPageDTO
     * @return
     */
    PageResult organizationMemberPage(StuOrganizationMemberPageDTO stuOrganizationMemberPageDTO);
}
