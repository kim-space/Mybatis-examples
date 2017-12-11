package com.mybatis.mapper;

import com.mybatis.enums.Sex;
import com.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.*;

public class UserMapperTest {

    private SqlSession session;
    private UserMapper userMapper;

    @Before
    public void setup() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    @Test
    public void getUser() throws Exception {
        User user = userMapper.getUser(2L);
        System.out.println(user);
    }

    @Test
    public void insertUser() throws Exception {
        User build = User.builder()
                .userName("kim")
                .cnname("cn")
                .birthday(new Date())
                .email("bchsdbibcdsjb@dd.com")
                .mibile("132145326")
                .sex(Sex.MALE)
                .note("hello").build();
        int i = userMapper.insertUser(build);
        session.commit();
        System.out.println(i);

    }

    @Test
    public void deleteUser() throws Exception {
    }

}