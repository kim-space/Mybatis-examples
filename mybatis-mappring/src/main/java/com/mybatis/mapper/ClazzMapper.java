package com.mybatis.mapper;

import com.mybatis.po.Clazz;
import com.mybatis.po.Student;

import java.util.List;

public interface ClazzMapper {

    int insertClazz(Clazz clazz);

    Clazz getClazz(Integer id);

    Clazz getClazz2(Integer id);
}
