package com.upcome.Student.service;

import com.upcome.Student.Mapper.StudentMapper;
import com.upcome.Student.entity.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * user: 张文龙
 * desc: 学生模块service层 接口实现类
 * Time: 2021-02-02 11:37
 */
@Transactional
@Service("StudentServiceImpl")
public class StudentServiceImpl implements IStudentService{

    //引入Mapper 接口
    @Autowired
    @Qualifier("StudentMapper")
    StudentMapper mapper;

    //引入log4j
    static Logger log=Logger.getLogger(StudentServiceImpl.class.getName());

    /**
     * 2021-02-02 z.w.l add
     * 1. 查询全部学生信息
     */
    @Override
    public List<Student> selectAllStudent() {
        log.info("-------- 学生模块service层 selectAllStudent查询全部信息方法--------");
        List<Student> StuListAll = null;

        try {
            StuListAll = mapper.selectAllStudent();
        } catch (Exception e) {
            log.error("学生模块service层 selectAllStudent查询全部信息方法==出现异常=="+e);
            e.printStackTrace();
        }
        return StuListAll;
    }

    /**
     * 2021-02-02 z.w.l add
     * 学生模块：删除学生方法
     */
    public int deleteStudentById(Student stu) {
        int res=0;
        try {
            res= mapper.deleteStudentById(stu);
        } catch (Exception e) {
            log.error("学生模块service层：deleteStudentById方法==出现异常=="+e);
            e.printStackTrace();
        }
        return res;
    }

    /**
     *2021-02-03 z.w.l add
     * 学生模块：接收学生信息方法
     */
    @Override
    public int AddStudent(Student stu) {
        int res=0;
        try {
            res=mapper.AddStudent(stu);
        } catch (Exception e) {
            log.error("学生模块：接收学生信息方法==出现异常=="+e);
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 2021-02-03 z.w.l add
     * 学生模块service层：进入修改学生信息页面
     */
    @Override
    public Student SeleStudentById(Student stu) {
        Student studentById=null;

        try {
            studentById =mapper.SeleStudentById(stu);
        } catch (Exception e) {
            log.error("学生模块service层：进入修改学生信息页面==出现异常=="+e);
            e.printStackTrace();
        }

        return studentById;
    }

    /**
     * 2021-02-04 z.w.l add
     * 学生模块service层：接收修改数据
     * @param stu
     */
    @Override
    public int UpdateStuSub(Student stu) {
        int res=0;
        try {
            res = mapper.UpdateStuSub(stu);
        } catch (Exception e) {
            log.error("学生模块service层：接收修改数据 UpdateStuSub==出现异常=="+e);
            e.printStackTrace();
        }

        return res;
    }

}
