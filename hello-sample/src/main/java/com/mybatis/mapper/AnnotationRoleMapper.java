package com.mybatis.mapper;

import com.mybatis.po.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface AnnotationRoleMapper {

    @Select("select id,roleName,note from t_role where id=#{id}")
    Role getRole(Long id);
}

