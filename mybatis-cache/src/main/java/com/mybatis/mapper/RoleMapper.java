package com.mybatis.mapper;

import com.mybatis.params.RoleParam;
import com.mybatis.po.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleMapper {

    Role getRole(Long id);

    int insertRole(Role role);

    int deleteRole(Long id);

    List<Role> getRoleByMap(Map<String, String> params);

    List<Role> getRoleByMapAnnotation(@Param("roleName") String roleName, @Param("note") String noe);

    List<Role> getRoleByParams(RoleParam param);

}

