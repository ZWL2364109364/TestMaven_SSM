package com.upcome.Classes.entity;

/**
 * user: 张文龙
 * desc: 班级模块实体类
 * Time: 2021-02-02 17:05
 */
public class Classes {

    public int clas_Id;
    public String clas_Name;


    public Classes(int clas_Id, String clas_Name) {
        this.clas_Id = clas_Id;
        this.clas_Name = clas_Name;
    }

    public Classes() {
    }

    public int getClas_Id() {
        return clas_Id;
    }

    public String getClas_Name() {
        return clas_Name;
    }

    public void setClas_Id(int clas_Id) {
        this.clas_Id = clas_Id;
    }

    public void setClas_Name(String clas_Name) {
        this.clas_Name = clas_Name;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "clas_Id=" + clas_Id +
                ", clas_Name='" + clas_Name + '\'' +
                '}';
    }
}
