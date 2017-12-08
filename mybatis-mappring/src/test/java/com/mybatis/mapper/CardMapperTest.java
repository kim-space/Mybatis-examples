package com.mybatis.mapper;

import com.mybatis.po.Card;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.*;

public class CardMapperTest {

    SqlSession session;
    CardMapper mapper;

    @Before
    public void setupo() throws IOException {
        String  resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        session = build.openSession();
         mapper = session.getMapper(CardMapper.class);
    }

    @Test
    public void insertCard(){
        Card build = Card.builder()
                .code("1234567890123456789")
                .build();
       mapper.insertCard(build);
        session.commit();
    }

    @Test
    public void getCard(){
        Card card = mapper.getCard(2);
        System.out.println(card);
    }

}