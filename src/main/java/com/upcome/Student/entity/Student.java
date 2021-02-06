package com.upcome.Student.entity;

import com.upcome.Classes.entity.Classes;

/**
 * user: 张文龙
 * desc: 学生模块实体类
 * Time: 2021-02-02 11:43
 */
public class Student {

    public int Stu_Id;
    public String Stu_Name;
    public String  Stu_Sex;
    public String Stu_Age;
    public Classes classes;

    public Student() {
    }

    public Student(int stu_Id, String stu_Name, String stu_Sex, String stu_Age, Classes classes) {
        Stu_Id = stu_Id;
        Stu_Name = stu_Name;
        Stu_Sex = stu_Sex;
        Stu_Age = stu_Age;
        this.classes = classes;
    }


    public int getStu_Id() {
        return Stu_Id;
    }

    public String getStu_Name() {
        return Stu_Name;
    }

    public String getStu_Sex() {
        return Stu_Sex;
    }

    public String getStu_Age() {
        return Stu_Age;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setStu_Id(int stu_Id) {
        Stu_Id = stu_Id;
    }

    public void setStu_Name(String stu_Name) {
        Stu_Name = stu_Name;
    }

    public void setStu_Sex(String stu_Sex) {
        Stu_Sex = stu_Sex;
    }

    public void setStu_Age(String stu_Age) {
        Stu_Age = stu_Age;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }


    @Override
    public String toString() {
        String claStr="";
        if(classes!=null){
            claStr= classes.toString();
        }
        return "Student{" +
                "Stu_Id=" + Stu_Id +
                ", Stu_Name='" + Stu_Name + '\'' +
                ", Stu_Sex='" + Stu_Sex + '\'' +
                ", Stu_Age='" + Stu_Age + '\'' +
                ", classes=" + claStr +
                '}';
    }
}


