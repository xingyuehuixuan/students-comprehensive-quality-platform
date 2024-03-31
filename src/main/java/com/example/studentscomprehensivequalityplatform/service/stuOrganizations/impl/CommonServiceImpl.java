package com.example.studentscomprehensivequalityplatform.service.stuOrganizations.impl;

import com.example.studentscomprehensivequalityplatform.common.constant.MessageConstant;
import com.example.studentscomprehensivequalityplatform.common.exception.AccountNotFoundException;
import com.example.studentscomprehensivequalityplatform.common.exception.PasswordErrorException;
import com.example.studentscomprehensivequalityplatform.mapper.StuOrganizationMapper;
import com.example.studentscomprehensivequalityplatform.pojo.dto.LoginDTO;
import com.example.studentscomprehensivequalityplatform.pojo.entity.StuOrganization;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StuOrganizationNameVO;
import com.example.studentscomprehensivequalityplatform.service.stuOrganizations.CommonService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service("stuOrganizationsCommonServiceImpl")
public class CommonServiceImpl implements CommonService {

    @Autowired
    private StuOrganizationMapper stuOrganizationMapper;

    /**
     * 根据学生组织id查询名称
     * @param id
     * @return
     */
    @Override
    public StuOrganizationNameVO getById(Integer id) {
        StuOrganizationNameVO stuOrganizationNameVO = stuOrganizationMapper.getNameById(id);
        return stuOrganizationNameVO;
    }

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    @Override
    public Integer login(LoginDTO loginDTO) {
        String password = loginDTO.getPassword();
        String accountNumber = loginDTO.getAccountNumber();
        StuOrganization stuOrganization = stuOrganizationMapper.getByAccountNumber(accountNumber);
        if (stuOrganization == null){
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        //对前端传过来的明文密码进行md5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(stuOrganization.getPassword())){
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        return stuOrganization.getId();
    }
}
