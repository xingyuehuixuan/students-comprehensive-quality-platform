package com.example.studentscomprehensivequalityplatform.service.students;

import com.example.studentscomprehensivequalityplatform.pojo.dto.StudentUpdateDTO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentsPersonalVO;

public interface PersonalService {

    /**
     * 根据ID查询学生信息
     * @return
     */
    StudentsPersonalVO getById();

    /**
     * 修改学生信息
     * @param studentUpdateDTO
     */
    void update(StudentUpdateDTO studentUpdateDTO);
}
