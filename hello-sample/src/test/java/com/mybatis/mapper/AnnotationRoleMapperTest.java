package com.mybatis.mapper;

import com.mybatis.po.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class AnnotationRoleMapperTest {

    private SqlSession session;

    @Before
    public void setup() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        Configuration configuration = sqlSessionFactory.getConfiguration();
        configuration.addMapper(AnnotationRoleMapper.class);
        session = sqlSessionFactory.openSession();
    }

    @Test
    public void getRole() throws Exception {
        AnnotationRoleMapper mapper = session.getMapper(AnnotationRoleMapper.class);
        Role role = mapper.getRole(1L);
        System.out.println(role);
    }

}