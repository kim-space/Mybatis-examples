package com.mybatis.mapper;

import com.mybatis.po.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class RoleMapperTest {

    private SqlSession session;

    @Before
    public void setup() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }


    @Test
    public void getRole() throws Exception {
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        Role role = mapper.getRole(1L);
        System.out.println(role);
    }

    @Test
    public void insertRole(){
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        Role role = new Role();
        role.setRoleName("superAdmin");
        role.setNote("超级管理员");
        int i = mapper.insertRole(role);
        session.commit();
        System.out.println(i);
    }

    @Test
    public void deleteRole(){
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        int i = mapper.deleteRole(1L);
        session.commit();
        System.out.println(i);
    }

    @Test
    public void getRoleByMap(){
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        HashMap<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("roleName","admin");
        paramMap.put("note","管理员");
        List<Role> roleByMap = mapper.getRoleByMap(paramMap);
        roleByMap.forEach(System.out::println);
    }

}