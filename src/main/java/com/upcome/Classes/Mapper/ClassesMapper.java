package com.upcome.Classes.Mapper;

import com.upcome.Classes.entity.Classes;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * user: 张文龙
 * desc:
 * Time: 2021-02-03 14:58
 */

@Repository("ClassesMapper")
public interface ClassesMapper {

    /**
     * 2021-02-03 z.w.l add
     * 班级模块service层：查询全部班级信息方法
     */
    List<Classes> SelectAllClasses();
}
