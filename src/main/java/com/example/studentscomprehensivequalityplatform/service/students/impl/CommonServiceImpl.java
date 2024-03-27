package com.example.studentscomprehensivequalityplatform.service.students.impl;

import com.example.studentscomprehensivequalityplatform.common.constant.MessageConstant;
import com.example.studentscomprehensivequalityplatform.common.exception.AccountNotFoundException;
import com.example.studentscomprehensivequalityplatform.common.exception.PasswordErrorException;
import com.example.studentscomprehensivequalityplatform.mapper.StudentMapper;
import com.example.studentscomprehensivequalityplatform.pojo.dto.LoginDTO;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Students;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentNameVO;
import com.example.studentscomprehensivequalityplatform.service.students.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据学生id查询姓名
     * @param id
     * @return
     */
    @Override
    public StudentNameVO getById(Integer id) {
        StudentNameVO studentNameVO = studentMapper.getNameById(id);
        return studentNameVO;
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
        Students students = studentMapper.getByAccountNumber(accountNumber);
        if (students == null){
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        //对前端传过来的明文密码进行md5加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(students.getPassword())) {
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        return students.getId();
    }
}
