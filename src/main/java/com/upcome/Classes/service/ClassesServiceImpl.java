package com.upcome.Classes.service;

import com.upcome.Classes.Mapper.ClassesMapper;
import com.upcome.Classes.entity.Classes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * user: 张文龙
 * desc: 班级模块service层接口实现类
 * Time: 2021-02-03 14:57
 */

@Transactional
@Service("ClassesServiceImpl")
public class ClassesServiceImpl implements  IClassesService{

    @Autowired
    @Qualifier("ClassesMapper")
    ClassesMapper mapper;

    Logger log= Logger.getLogger(ClassesServiceImpl.class);

    /**
     * 2021-02-03 z.w.l add
     * 班级模块service层：查询全部班级信息方法
     */
    @Override
    public List<Classes> SelectAllClasses() {

        List<Classes> clasList = null;
        try {
            clasList = mapper.SelectAllClasses();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("班级模块service层：查询全部班级信息方法==出现异常=="+e);
        }
        return clasList;
    }
}
