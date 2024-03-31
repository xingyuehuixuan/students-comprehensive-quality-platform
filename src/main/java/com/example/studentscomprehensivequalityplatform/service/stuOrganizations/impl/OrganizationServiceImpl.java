package com.example.studentscomprehensivequalityplatform.service.stuOrganizations.impl;

import com.example.studentscomprehensivequalityplatform.common.context.BaseContext;
import com.example.studentscomprehensivequalityplatform.common.result.PageResult;
import com.example.studentscomprehensivequalityplatform.common.result.Result;
import com.example.studentscomprehensivequalityplatform.mapper.StuOrganizationMapper;
import com.example.studentscomprehensivequalityplatform.mapper.StudentMapper;
import com.example.studentscomprehensivequalityplatform.pojo.dto.StuOrganizationMemberPageDTO;
import com.example.studentscomprehensivequalityplatform.pojo.entity.StuOrganization;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StuOrganizationMemberVO;
import com.example.studentscomprehensivequalityplatform.service.stuOrganizations.OrganizationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private StuOrganizationMapper stuOrganizationMapper;

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据id查询学生组织信息
     * @param id
     * @return
     */
    @Override
    public StuOrganization getById(Integer id) {
        StuOrganization stuOrganization = stuOrganizationMapper.getById(id);
        return stuOrganization;
    }

    /**
     * 修改学生组织信息
     * @param stuOrganization
     */
    @Override
    public void updateStuOrganization(StuOrganization stuOrganization) {
        stuOrganization.setUpdateTime(LocalDateTime.now());
        stuOrganization.setId(Math.toIntExact(BaseContext.getCurrentId()));
        stuOrganizationMapper.updateStuOrganization(stuOrganization);
    }

    /**
     * 学生组织成员分页查询
     * @param stuOrganizationMemberPageDTO
     * @return
     */
    @Override
    public PageResult organizationMemberPage(StuOrganizationMemberPageDTO stuOrganizationMemberPageDTO) {
        PageHelper.startPage(stuOrganizationMemberPageDTO.getPage(), stuOrganizationMemberPageDTO.getPageSize());
        Page<StuOrganizationMemberVO> page = studentMapper.organizationMemberPage(stuOrganizationMemberPageDTO,
                Math.toIntExact(BaseContext.getCurrentId()));
        return new PageResult(page.getTotal(), page.getResult());
    }
}
