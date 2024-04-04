package com.example.studentscomprehensivequalityplatform.controller.stuOrganizations;

import com.example.studentscomprehensivequalityplatform.common.constant.JwtClaimsConstant;
import com.example.studentscomprehensivequalityplatform.common.constant.MessageConstant;
import com.example.studentscomprehensivequalityplatform.common.context.BaseContext;
import com.example.studentscomprehensivequalityplatform.common.properties.JwtProperties;
import com.example.studentscomprehensivequalityplatform.common.result.Result;
import com.example.studentscomprehensivequalityplatform.common.utils.AliOssUtil;
import com.example.studentscomprehensivequalityplatform.common.utils.JwtUtil;
import com.example.studentscomprehensivequalityplatform.pojo.dto.LoginDTO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.LoginVO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StuOrganizationNameVO;
import com.example.studentscomprehensivequalityplatform.service.stuOrganizations.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController("stuOrganizationsCommonController")
@RequestMapping("/stuOrganization/common")
public class CommonController {

    @Autowired
    private CommonService commonService;
    @Autowired
    private AliOssUtil aliOssUtil;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 根据学生组织id查询名称
     * @return
     */
    @GetMapping("/stuOrganizationName")
    @Cacheable(cacheNames = "stuOrganizationNameCache", key = "#result.data.id")
    public Result<StuOrganizationNameVO> getById(){
        StuOrganizationNameVO stuOrganizationNameVO = commonService.getById(Math.toIntExact(BaseContext.getCurrentId()));
        return Result.success(stuOrganizationNameVO);
    }

    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) {

        try {
            //原始文件名
            String originalFilename = file.getOriginalFilename();
            //截取原始文件名后缀
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            //构造新文件名称
            String objectName = UUID.randomUUID().toString() + extension;
            //文件请求路径
            String filePath = aliOssUtil.upload(file.getBytes(), objectName);
            return Result.success(filePath);

        } catch (IOException e) {
            return Result.error(MessageConstant.UPLOAD_FAILED);

        }
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
        claims.put(JwtClaimsConstant.STU_ORG_ID, id);
        String token = JwtUtil.createJWT(jwtProperties.getStuOrganizationSecretKey(),
                jwtProperties.getStuOrganizationTtl(), claims);
        LoginVO loginVO = LoginVO.builder()
                .id(id)
                .token(token)
                .build();
        return Result.success(loginVO);
    }
}
