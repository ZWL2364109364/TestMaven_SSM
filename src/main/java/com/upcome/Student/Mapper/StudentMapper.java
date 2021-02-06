package com.upcome.Student.Mapper;

import com.upcome.Classes.entity.Classes;
import com.upcome.Student.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * user: 张文龙
 * desc: 学生模块 持久层接口
 * Time: 2021-02-02 11:54
 */


@Repository("StudentMapper")
public interface StudentMapper {

    /**
     *1. 查询全部学生信息方法
     */
    public List<Student> selectAllStudent();


    /**
     * 2021-02-02 z.w.l add
     * 学生模块：删除学生方法
     */
    int deleteStudentById(@Param("stu") Student stu);


    /**
     *2021-02-03 z.w.l add
     * 学生模块：获取班级所有信息 用于添加学生
     */
    List<Classes> getClassesAll();


    /**
     *2021-02-03 z.w.l add
     * 学生模块：接收学生信息方法
     */
    int AddStudent(@Param("stu") Student stu);

    /**
     * 2021-02-03 z.w.l add
     * 学生模块：进入修改学生信息页面
     */
    Student SeleStudentById(@Param("stu") Student stu);

    /**
     * 2021-02-04 z.w.l add
     * 学生模块service层：接收修改数据
     * @param stu
     */
    int UpdateStuSub(@Param("stu") Student stu);
}
