package com.example.studentscomprehensivequalityplatform.service.stuOrganizations;

import com.example.studentscomprehensivequalityplatform.pojo.dto.LoginDTO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StuOrganizationNameVO;

public interface CommonService {

    /**
     * 根据学生组织id查询名称
     * @param id
     * @return
     */
    StuOrganizationNameVO getById(Integer id);

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    Integer login(LoginDTO loginDTO);
}
