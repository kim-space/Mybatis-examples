package com.mybatis.mapper;

import com.mybatis.params.RoleParam;
import com.mybatis.po.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
        paramMap.put("roleName","superAdmin");
        paramMap.put("note","管理员");
        List<Role> roleByMap = mapper.getRoleByMap(paramMap);
        roleByMap.forEach(System.out::println);
    }


    @Test
    public void findRole(){
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        RoleParam param = new RoleParam();
        param.setRoleName("admin");
        param.setNote("管理员");
        List<Role> roles = mapper.findRole(param);
        roles.forEach(System.out::println);
    }

    @Test
    public void findRoles(){
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        List<String> names = new ArrayList<>();
        names.add("admin");
        names.add("superAdmin");
        List<Role> roles = mapper.findRoles(names);
        roles.forEach(System.out::println);
    }


    @Test
    public void batchInsert(){
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        Role role = new Role();
        role.setRoleName("vip");
        role.setNote("会员");
        Role role2 = new Role();
        role2.setRoleName("vip2");
        role2.setNote("会员");
        Role role3 = new Role();
        role3.setRoleName("vip3");
        role3.setNote("会员");
        List roles = new ArrayList();
        roles.add(role);
        roles.add(role2);
        roles.add(role3);
        int i = mapper.insertRoles(roles);
        session.commit();
        System.out.println(i);
    }
}