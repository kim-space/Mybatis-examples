package com.mybatis.mapper;

import com.mybatis.po.Clazz;
import com.mybatis.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class ClazzMapperTest {

    SqlSession session;
    ClazzMapper mapper;

    @Before
    public void setupo() throws IOException {
        String  resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        session = build.openSession();
        mapper = session.getMapper(ClazzMapper.class);
    }

    @Test
    public void insertClazz() throws Exception {
        Clazz clazz = Clazz.builder()
                .name("三年八班")
                .code("33388888888")
                .build();
        mapper.insertClazz(clazz);
        session.commit();
        System.out.println(clazz);
    }

    @Test
    public void getClzz() throws Exception {
        Clazz clzz = mapper.getClazz(1);
        System.out.println(clzz);
    }

    @Test
    public void findClazzStudents(){
        Clazz clazz2 = mapper.getClazz2(1);
        System.out.println(clazz2);
    }

}