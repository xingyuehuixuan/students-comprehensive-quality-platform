package com.example.studentscomprehensivequalityplatform.service.students;

import com.example.studentscomprehensivequalityplatform.pojo.dto.StudentUpdateDTO;
import com.example.studentscomprehensivequalityplatform.pojo.dto.SubmitAppealDTO;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Appeal;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentAppealQueryVO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentsPersonalVO;

import java.util.List;

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

    /**
     * 申诉查询
     * @return
     */
    List<StudentAppealQueryVO> appealQuery();

    /**
     * 根据ID查询申诉
     * @param id
     * @return
     */
    Appeal appealQueryById(Integer id);

    /**
     * 提交申诉
     * @param submitAppealDTO
     * @return
     */
    void submitAppeal(SubmitAppealDTO submitAppealDTO);
}
