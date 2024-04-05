package com.example.studentscomprehensivequalityplatform.service.students.impl;

import com.example.studentscomprehensivequalityplatform.common.constant.StatusConstant;
import com.example.studentscomprehensivequalityplatform.common.context.BaseContext;
import com.example.studentscomprehensivequalityplatform.mapper.AppealMapper;
import com.example.studentscomprehensivequalityplatform.mapper.CollegeMapper;
import com.example.studentscomprehensivequalityplatform.mapper.MajorMapper;
import com.example.studentscomprehensivequalityplatform.mapper.StudentMapper;
import com.example.studentscomprehensivequalityplatform.pojo.dto.StudentUpdateDTO;
import com.example.studentscomprehensivequalityplatform.pojo.dto.SubmitAppealDTO;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Appeal;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Students;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentAppealQueryVO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentNameVO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentsPersonalVO;
import com.example.studentscomprehensivequalityplatform.service.students.PersonalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class PersonalServiceImpl implements PersonalService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private CollegeMapper collegeMapper;
    @Autowired
    private MajorMapper majorMapper;
    @Autowired
    private AppealMapper appealMapper;

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
        studentsPersonalVO.setPassword("******");
        return studentsPersonalVO;
    }

    /**
     * 修改学生信息
     * @param studentUpdateDTO
     */
    @Override
    public void update(StudentUpdateDTO studentUpdateDTO) {
        if (Objects.equals(studentUpdateDTO.getPassword(), "******")){
            studentUpdateDTO.setPassword(null);
        }
        Integer collegeId = collegeMapper.getIdByName(studentUpdateDTO.getCollege());
        Integer majorId = majorMapper.getIdByName(studentUpdateDTO.getMajor());
        studentUpdateDTO.setId(Math.toIntExact(BaseContext.getCurrentId()));
        Students students = new Students();
        BeanUtils.copyProperties(studentUpdateDTO, students);
        students.setCollegeId(collegeId);
        students.setMajorId(majorId);
        students.setUpdateTime(LocalDateTime.now());
        studentMapper.update(students);
    }

    /**
     * 申诉查询
     * @return
     */
    @Override
    public List<StudentAppealQueryVO> appealQuery() {
        Integer stuId = Math.toIntExact(BaseContext.getCurrentId());
        List<StudentAppealQueryVO> list = appealMapper.appealQuery(stuId);
        return list;
    }

    /**
     * 根据ID查询申诉
     * @param id
     * @return
     */
    @Override
    public Appeal appealQueryById(Integer id) {
        Appeal appeal = appealMapper.getById(id);
        return appeal;
    }

    /**
     * 提交申诉
     * @param submitAppealDTO
     * @return
     */
    @Override
    public void submitAppeal(SubmitAppealDTO submitAppealDTO) {
        Integer stuId = Math.toIntExact(BaseContext.getCurrentId());
        StudentNameVO studentNameVO = studentMapper.getNameById(stuId);
        String stuName = studentNameVO.getStudentName();
        Integer collegeId = studentMapper.getCollegeId(stuId);
        String collegeName = collegeMapper.getNameById(collegeId);
        Integer majorId = studentMapper.getMajorId(stuId);
        String majorName = majorMapper.getNameById(majorId);
        String studentNumber = studentMapper.getStudentNumber(stuId);
        LocalDateTime createTime = LocalDateTime.now();
        Appeal appeal = Appeal.builder()
                .stuId(stuId)
                .stuName(stuName)
                .collegeName(collegeName)
                .majorName(majorName)
                .stuNumber(studentNumber)
                .createTime(createTime)
                .handlePhase(StatusConstant.TO_BE_HANDLED)
                .handleResult(StatusConstant.TO_BE_HANDLED)
                .build();
        BeanUtils.copyProperties(submitAppealDTO, appeal);
        appealMapper.insert(appeal);
    }
}
