package com.example.studentscomprehensivequalityplatform.controller.stuOrganizations;

import com.example.studentscomprehensivequalityplatform.common.result.PageResult;
import com.example.studentscomprehensivequalityplatform.common.result.Result;
import com.example.studentscomprehensivequalityplatform.pojo.dto.StuOrganizationMemberPageDTO;
import com.example.studentscomprehensivequalityplatform.pojo.entity.StuOrganization;
import com.example.studentscomprehensivequalityplatform.service.stuOrganizations.OrganizationService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stuOrganization/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    /**
     * 根据Id查询学生组织信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<StuOrganization> getById(@PathVariable Integer id){
        StuOrganization stuOrganization = organizationService.getById(id);
        return Result.success(stuOrganization);
    }

    /**
     * 修改学生组织信息
     * @param stuOrganization
     * @return
     */
    @PutMapping("/updateStuOrganization")
    public Result updateStuOrganization(@RequestBody StuOrganization stuOrganization){
        organizationService.updateStuOrganization(stuOrganization);
        return Result.success();
    }

    /**
     * 学生组织成员分页查询
     * @param stuOrganizationMemberPageDTO
     * @return
     */
    @GetMapping("/organizationMemberPage")
    public Result<PageResult> organizationMemberPage(StuOrganizationMemberPageDTO stuOrganizationMemberPageDTO){
        PageResult pageResult = organizationService.organizationMemberPage(stuOrganizationMemberPageDTO);
        return Result.success(pageResult);
    }


}
