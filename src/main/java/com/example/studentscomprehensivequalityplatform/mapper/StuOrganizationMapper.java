package com.example.studentscomprehensivequalityplatform.mapper;

import com.example.studentscomprehensivequalityplatform.pojo.entity.StuOrganization;
import com.example.studentscomprehensivequalityplatform.pojo.vo.RegisteredStudentsVO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StuOrganizationNameVO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentNameVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StuOrganizationMapper {

    /**
     * 根据学生组织id查询名称
     * @param id
     * @return
     */
    @Select("select id, org_name as stuOrganizationName from stu_organization where id = #{id}")
    StuOrganizationNameVO getNameById(Integer id);

    /**
     * 根据学生组织id查询学生组织信息
     * @param id
     * @return
     */
    @Select("select * from stu_organization where id = #{id}")
    StuOrganization getById(Integer id);

    /**
     * 修改学生组织信息
     * @param stuOrganization
     */
    void updateStuOrganization(StuOrganization stuOrganization);

    /**
     * 根据账号查询学生组织信息
     * @param accountNumber
     * @return
     */
    @Select("select * from stu_organization where account_number = #{accountNumber}")
    StuOrganization getByAccountNumber(String accountNumber);
}
