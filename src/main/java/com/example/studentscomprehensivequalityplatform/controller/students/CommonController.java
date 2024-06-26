package com.example.studentscomprehensivequalityplatform.controller.students;

import com.example.studentscomprehensivequalityplatform.common.constant.JwtClaimsConstant;
import com.example.studentscomprehensivequalityplatform.common.context.BaseContext;
import com.example.studentscomprehensivequalityplatform.common.properties.JwtProperties;
import com.example.studentscomprehensivequalityplatform.common.result.Result;
import com.example.studentscomprehensivequalityplatform.common.utils.JwtUtil;
import com.example.studentscomprehensivequalityplatform.pojo.dto.LoginDTO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.LoginVO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentNameVO;
import com.example.studentscomprehensivequalityplatform.service.students.ActivityService;
import com.example.studentscomprehensivequalityplatform.service.students.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController("studentsCommonController")
@RequestMapping("/students/common")
public class CommonController {
    @Autowired
    private CommonService commonService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 根据学生id查询姓名
     * @return
     */
    @GetMapping("/studentName")
    @Cacheable(cacheNames = "studentNameCache", key = "#result.data.id")
    public Result<StudentNameVO> getById(){
        StudentNameVO studentNameVO = commonService.getById(Math.toIntExact(BaseContext.getCurrentId()));
        return Result.success(studentNameVO);
    }

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody LoginDTO loginDTO){
        Integer id = commonService.login(loginDTO);
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.STU_ID, id);
        String token = JwtUtil.createJWT(jwtProperties.getStudentSecretKey(), jwtProperties.getStudentTtl(), claims);
        LoginVO loginVO = LoginVO.builder()
                .id(id)
                .token(token)
                .build();
        return Result.success(loginVO);
    }
}
