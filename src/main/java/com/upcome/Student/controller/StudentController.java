package com.upcome.Student.controller;

import com.upcome.Classes.entity.Classes;
import com.upcome.Classes.service.IClassesService;
import com.upcome.Student.entity.Student;
import com.upcome.Student.service.IStudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;


/**
 * user: 张文龙
 * desc: 学生模块 C层  测试修改
 * Time: 2021-02-01 15:58
 */
@Controller
@RequestMapping("Student")
public class StudentController {

    //引入service层
    @Autowired
    @Qualifier("StudentServiceImpl")
    IStudentService service;

    //引入班级service层
    @Autowired
    @Qualifier("ClassesServiceImpl")
    IClassesService ClassesService;



    //引入log日志
    static Logger log=Logger.getLogger(StudentController.class.getName());
    private PrintWriter printWriter;
    private PrintWriter printWriter1;

    /**
     * 2021-02-02 z.w.l add
     * 1. 查询全部学生信息
     */
    @RequestMapping(value = "selectAllStudent",method = RequestMethod.GET)
    public ModelAndView selectAllStudent(){
        log.info("--------学生模块C层：查询全部学生信息方法 selectAllStudent--------");

        ModelAndView mv=new ModelAndView();
        try {

            List<Student> AllStu=service.selectAllStudent();

                log.info("学生模块C层：selectAllStudent==查询数据为=="+AllStu.toString());
                mv.addObject("StuList",AllStu);
                mv.setViewName("Student/StudJsp");

        } catch (Exception e) {
            log.error("学生模块C层：查询全部学生信息方法 selectAllStudent"+e);
            log.info("学生模块C层：selectAllStudent==获取数据失败==");
            mv.setViewName("error/Exception");
            e.printStackTrace();
        }
        return mv;

    }


    /**
     * 2021-02-02 z.w.l add
     * 学生模块：删除学生方法
     */
    @RequestMapping(value = "deleteStudentById",method = RequestMethod.DELETE)
    public void  deleteStudentById(Student stu, HttpServletResponse response){
        log.info("--------学生模块C层：删除学生方法 deleteStudentById--------");

        int res=0;
        PrintWriter wri=null;
        try {
            wri =response.getWriter();

            if(stu!=null && stu.Stu_Id!=0){
                log.info("学生模块：删除学生方法 deleteStudentById==信息获取成功=="+stu.toString());
                res=service.deleteStudentById(stu);

            }else{
                log.info("学生模块：删除学生方法 deleteStudentById==信息获取失败=="+stu);
                res=0;
            }
        } catch (Exception e) {
            log.error("学生模块：删除学生方法 deleteStudentById==出现异常=="+e);
            res=0;
            e.printStackTrace();
        }
        wri.write(res+"");
        wri.flush();
        wri.close();

    }


    /**
     * 2021-02-03 z.w.l add
     * 学生模块：跳转添加页面
     */
    @RequestMapping(value = "StuAddPage",method = RequestMethod.GET)
    public ModelAndView StuAddPage(){
        log.info("--------学生模块：跳转添加页面 StuAddPage--------");

        ModelAndView Mv=new ModelAndView();

        try {
            //1. 查询全部班级信息
            List<Classes> ClasList=ClassesService.SelectAllClasses();
            log.info("学生模块：跳转添加页面 StuAddPage==获取班级信息=="+ClasList.toString());

            //2. 将班级信息加入作用域中
            Mv.addObject("ListClas",ClasList);
            Mv.setViewName("Student/StudAdd");

        } catch (Exception e) {
            log.error("学生模块：跳转添加页面 StuAddPage==出现异常=="+e);
            Mv.setViewName("error/Exception");
            e.printStackTrace();
        }

        return Mv;
    }

    /**
     *2021-02-03 z.w.l add
     * 学生模块：接收学生信息方法
     */
    @RequestMapping(value = "addStudent" , method = RequestMethod.POST)
    public String addStudent(Student stu){
        log.info("--------学生模块：接收学生信息方法--------");

        String Stures="";
        try {
            if(stu!=null){
                log.info("学生模块：接收学生信息方法==获得数据成功=="+stu.toString());
                int res =service.AddStudent(stu);
                if(res!=0){
                    log.info("学生模块：接收学生信息方法==获得添加成功=="+res);
                    Stures="redirect:/Student/selectAllStudent";
                 }else{
                    log.info("学生模块：接收学生信息方法==获得添加失败=="+res);
                    Stures="error/Exception";
                }
            }else{
                log.info("学生模块：接收学生信息方法==获得数据失败=="+stu);
                Stures="error/Exception";
            }
        } catch (Exception e) {
            log.error("学生模块：接收学生信息方法==出现异常=="+e);
            Stures="error/Exception";
            e.printStackTrace();
        }
        return Stures;
    }


    /**
     * 2021-02-03 z.w.l add
     * 学生模块：进入修改学生信息页面
     */
    @RequestMapping(value = "updateStudentPage" ,method = RequestMethod.GET)
    public ModelAndView updateStudentPage(Student stu){
        log.info("--------学生模块：进入修改学生信息页面--------");

        ModelAndView Mv=new ModelAndView();

        try {
            if(stu!=null && stu.getStu_Id()!=0){
                log.info("学生模块：进入修改学生信息页面==获取信息成功=="+stu.toString());
                Student StuById=service.SeleStudentById(stu);

                List<Classes> listCla=ClassesService.SelectAllClasses();

                if(StuById!=null && listCla!=null && listCla.size()!=0){
                    log.info("学生模块：进入修改学生信息页面==根基Id查询信息成功=="+StuById.toString());
                    log.info("学生模块：进入修改学生信息页面==全部班级信息查询成功=="+listCla.toString());
                    Mv.setViewName("Student/StuUpdate");
                    Mv.addObject("stuS",StuById);
                    Mv.addObject("clasList",listCla);
                }else{
                    log.info("学生模块：进入修改学生信息页面==查询数据失败==");
                    Mv.setViewName("error/Exception");
                }
            }else{
                log.info("学生模块：进入修改学生信息页面==获取信息失败=="+stu);
                Mv.setViewName("error/Exception");
            }
        } catch (Exception e) {
            log.error("学生模块：进入修改学生信息页面==出现异常=="+e);
            Mv.setViewName("error/Exception");
            e.printStackTrace();
        }

        return Mv;
    }

    /**
     * 2021-02-04 z.w.l add
     * 学生模块：接收修改数据
     */
    @RequestMapping(value = "updateStudentSub",method = RequestMethod.PUT)
    public void  updateStudentSub(Student stu,HttpServletResponse response){
        log.info("--------学生模块：接收修改数据 updateStudentSub--------");

        int res;
        PrintWriter wri=null;
        try {
            wri  = response.getWriter();

            if(stu!=null){
                log.info("学生模块：接收修改数据 updateStudentSub==获取数据成功=="+stu.toString());
                res=service.UpdateStuSub(stu);
            }else{
               res=0;
                log.info("学生模块：接收修改数据 updateStudentSub==获取数据失败=="+stu);
            }
        } catch (Exception e) {
            log.error("学生模块：接收修改数据 updateStudentSub==获取数据失败=="+e);
            res=0;
            e.printStackTrace();
        }
        wri.write(res+"");
        wri.flush();
        wri.close();

    }



}
