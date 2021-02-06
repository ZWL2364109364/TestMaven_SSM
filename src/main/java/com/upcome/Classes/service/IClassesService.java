package com.upcome.Classes.service;

import com.upcome.Classes.entity.Classes;

import java.util.List;

/**
 * user: 张文龙
 * desc: 班级模块service层接口
 * Time: 2021-02-03 14:57
 */
public interface IClassesService {

    /**
     * 2021-02-03 z.w.l add
     * 查询全部班级信息方法
     */
    public List<Classes> SelectAllClasses();

}
