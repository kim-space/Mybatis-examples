package com.mybatis.mapper;

import com.mybatis.po.Card;
import com.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class UserMapperTest {

    SqlSession session;
    UserMapper userMapper;
    CardMapper cardMapper;

    @Before
    public void setupo() throws IOException {
        String  resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        session = build.openSession();
        userMapper = session.getMapper(UserMapper.class);
        cardMapper = session.getMapper(CardMapper.class);
    }

    @Test
    public void insertUser() throws Exception {
        Card card = Card.builder()
                .code("000000000000000")
                .build();
        cardMapper.insertCard(card);
        User user = User.builder()
                .name("kim")
                .sex("男")
                .age(22)
                .card(card)
                .build();
        userMapper.insertUser(user);
        session.commit();

    }

    @Test
    public void getUser() throws Exception {
        User user = userMapper.getUser(2);
        System.out.println(user);
    }

}