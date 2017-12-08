package com.mybatis.mapper;

import com.mybatis.po.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static org.junit.Assert.*;

public class BlogMapperTest {

    SqlSession session;
    BlogMapper mapper;

    @Before
    public void setupo() throws IOException {
        String  resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        session = build.openSession();
        mapper = session.getMapper(BlogMapper.class);
    }

    @Test
    public void insertBlog() throws Exception {
        Blog blog = Blog.builder()
                .title("AAAA")
                .content(UUID.randomUUID().toString())
                .build();
        mapper.insertBlog(blog);
        session.commit();
        System.out.println(blog);
    }

    @Test
    public void findOneBlog() throws Exception {
        Blog oneBlog = mapper.findOneBlog(1L);
        System.out.println(oneBlog);

    }

}