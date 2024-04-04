package com.example.studentscomprehensivequalityplatform.service.students.impl;

import com.example.studentscomprehensivequalityplatform.common.context.BaseContext;
import com.example.studentscomprehensivequalityplatform.mapper.CollegeMapper;
import com.example.studentscomprehensivequalityplatform.mapper.MajorMapper;
import com.example.studentscomprehensivequalityplatform.mapper.StudentMapper;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Students;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentsPersonalVO;
import com.example.studentscomprehensivequalityplatform.service.students.PersonalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private MajorMapper majorMapper;
    /**
     * 根据ID查询学生信息
     * @return
     */
    @Override
    public StudentsPersonalVO getById() {
        Students students = studentMapper.getStudentsById(Math.toIntExact(BaseContext.getCurrentId()));
        String collegeName = collegeMapper.getNameById(students.getCollegeId());
        String majorName = majorMapper.getNameById(students.getMajorId());
        StudentsPersonalVO studentsPersonalVO = new StudentsPersonalVO();
        BeanUtils.copyProperties(students, studentsPersonalVO);
        studentsPersonalVO.setCollege(collegeName);
        studentsPersonalVO.setMajor(majorName);
        return studentsPersonalVO;
    }
}
