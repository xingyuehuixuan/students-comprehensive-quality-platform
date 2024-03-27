package com.example.studentscomprehensivequalityplatform.service.students;

import com.example.studentscomprehensivequalityplatform.pojo.dto.LoginDTO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentNameVO;

public interface CommonService {

    /**
     * 根据学生id查询姓名
     * @param id
     * @return
     */
    StudentNameVO getById(Integer id);

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    Integer login(LoginDTO loginDTO);
}
