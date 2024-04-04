package com.example.studentscomprehensivequalityplatform.controller.students;

import com.example.studentscomprehensivequalityplatform.common.context.BaseContext;
import com.example.studentscomprehensivequalityplatform.common.result.Result;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentsPersonalVO;
import com.example.studentscomprehensivequalityplatform.service.students.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
