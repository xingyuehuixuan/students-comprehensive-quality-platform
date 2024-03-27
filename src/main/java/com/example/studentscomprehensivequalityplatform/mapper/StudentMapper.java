package com.example.studentscomprehensivequalityplatform.mapper;

import com.example.studentscomprehensivequalityplatform.pojo.dto.StuOrganizationMemberPageDTO;
import com.example.studentscomprehensivequalityplatform.pojo.entity.Students;
import com.example.studentscomprehensivequalityplatform.pojo.vo.RegisteredStudentsVO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StuOrganizationMemberVO;
import com.example.studentscomprehensivequalityplatform.pojo.vo.StudentNameVO;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {

    /**
     * 根据活动id查询报名人员名单
     * @param activityId
     * @return
     */
    RegisteredStudentsVO getById(Integer activityId);

    /**
     * 根据学生id查询姓名
     * @param id
     * @return
     */
    @Select("select id, name as studentName from students where id = #{id}")
    StudentNameVO getNameById(Integer id);

    /**
     * 学生组织成员分页查询
     * @param stuOrganizationMemberPageDTO
     * @return
     */
    Page<StuOrganizationMemberVO> organizationMemberPage(StuOrganizationMemberPageDTO stuOrganizationMemberPageDTO);

    /**
     *根据账号查询学生信息
     * @param accountNumber
     * @return
     */
    @Select("select * from students where account_number = #{accountNumber}")
    Students getByAccountNumber(String accountNumber);
}
