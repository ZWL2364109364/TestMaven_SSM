package com.upcome.Student.service;

import com.upcome.Student.entity.Student;

import java.util.List;

/**
 * user: 张文龙
 * desc: 学生模块service层接口
 * Time: 2021-02-02 11:31
 */
public interface IStudentService {

    /**
     * 2021-02-02 z.w.l add
     * 1. 查询全部学生信息
     */
    List<Student> selectAllStudent();


    /**
     * 2021-02-02 z.w.l add
     * 学生模块：删除学生方法
     * @param stu
     */
    int deleteStudentById(Student stu);

    /**
     *2021-02-03 z.w.l add
     * 学生模块：接收学生信息方法
     * @param stu
     */
    int AddStudent(Student stu);

    /**
     * 2021-02-03 z.w.l add
     * 学生模块：进入修改学生信息页面
     */
    Student SeleStudentById(Student stu);

    /**
     * 2021-02-04 z.w.l add
     * 学生模块：接收修改数据
     * @param stu
     */
    int UpdateStuSub(Student stu);
}
