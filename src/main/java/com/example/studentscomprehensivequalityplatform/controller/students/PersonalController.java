package com.example.studentscomprehensivequalityplatform.controller.students;

import com.example.studentscomprehensivequalityplatform.common.context.BaseContext;
import com.example.studentscomprehensivequalityplatform.common.result.Result;
import com.example.studentscomprehensivequalityplatform.pojo.dto.StudentUpdateDTO;
import com.example.studentscomprehensivequalityplatform.pojo.dto.SubmitAppealDTO;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Appeal;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentAppealQueryVO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentsPersonalVO;
import com.example.studentscomprehensivequalityplatform.service.students.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/personal")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    /**
     * 根据ID查询学生信息
     * @return
     */
    @GetMapping
    @Cacheable(cacheNames = "studentCache", key = "#result.data.id")
    public Result<StudentsPersonalVO> getById(){
        StudentsPersonalVO studentsPersonalVO = personalService.getById();
        return Result.success(studentsPersonalVO);
    }

    /**
     * 修改学生信息
     * @param studentUpdateDTO
     * @return
     */
    @PutMapping("/update")
    @CacheEvict(cacheNames = "studentCache", key = "#studentUpdateDTO.id")
    public Result update(@RequestBody StudentUpdateDTO studentUpdateDTO){
        personalService.update(studentUpdateDTO);
        return Result.success();
    }

    /**
     * 申诉查询
     * @return
     */
    @GetMapping("/appealQuery")
    @Cacheable(cacheNames = "studentAppealCache", key = "#result.data.get(0).stuId")
    public Result<List<StudentAppealQueryVO>> appealQuery(){
        List<StudentAppealQueryVO> list = personalService.appealQuery();
        return Result.success(list);
    }

    /**
     * 根据ID查询申诉
     * @param id
     * @return
     */
    @GetMapping("/appealQueryById")
    @Cacheable(cacheNames = "appealCache", key = "#id")
    public Result<Appeal> appealQueryById(Integer id){
        Appeal appeal = personalService.appealQueryById(id);
        return Result.success(appeal);
    }

    /**
     * 提交申诉
     * @param submitAppealDTO
     * @return
     */
    @PostMapping("/submitAppeal")
    @CacheEvict(cacheNames = "studentAppealCache", allEntries = true)
    public Result submitAppeal(@RequestBody SubmitAppealDTO submitAppealDTO){
        personalService.submitAppeal(submitAppealDTO);
        return Result.success();
    }
}
