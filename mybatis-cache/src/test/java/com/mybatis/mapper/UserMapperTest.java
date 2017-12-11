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


/**
 * 一级缓存是sqlsession级别的缓存。在操作数据库时需要构造sqlSession对象，在对象中有一个数据结构（HashMap）用于存储缓存数据。不同的sqlSession之间的缓存数据区域（HashMap）是互相不影响的
 * 二级缓存是mapper级别的缓存，多个sqlsession去操作同一个mapper的sql语句。多个session可以共用二级缓存，即跨session
 *
 *
 *
 *
 */


public class UserMapperTest {


    SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
    private UserMapper userMapper;

    @Before
    public void setup() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    // 在一个 sqlSession 中，对 User 表根据id进行两次查询
    @Test
    public void CacheLevel1Test() throws Exception {
        //第一次查询，发出sql语句，并将查询的结果放入缓存中
        User user = userMapper.getUser(2L);
        System.out.println(user);
        //第二次查询，由于是同一个sqlSession,会在缓存中查找查询结果
        //如果有，则直接从缓存中取出来，不和数据库进行交互
        User user2 = userMapper.getUser(2L);
        System.out.println(user2);
    }

    //同样是对user表进行两次查询，只不过两次查询之间进行了一次update操作
    @Test
    public void CacheLevel1Test2() throws Exception {
        //第一次查询，发出sql语句，并将查询的结果放入缓存中
        User user = userMapper.getUser(2L);
        System.out.println(user);
        //第二步进行了一次更新操作，sqlSession.commit()
        user.setSex(Sex.FEMALE);
        userMapper.updateUser(user);
        session.commit();
        //第二次查询，由于是同一个sqlSession.commit(),会清空缓存信息
        User user2 = userMapper.getUser(2L);
        System.out.println(user2);
    }


    //测试二级缓存和sqlSession 无关
    @Test
    public void CacheLevel2Test(){
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user = userMapper.getUser(2L);
        System.out.println(user);
        session.close();
        User user2 = userMapper2.getUser(2L);
        System.out.println(user2);
        sqlSession2.close();
    }

    //测试执行 commit() 操作，二级缓存数据清空
    @Test
    public void CacheLevel2Test2(){
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);

        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);

        //第一次查询，发出sql语句，并将查询的结果放入缓存中
        User user = userMapper.getUser(2L);
        System.out.println(user);
        session.close();

        //执行更新操作，commit()
        user.setSex(Sex.MALE);
        userMapper3.updateUser(user);
        sqlSession3.commit();

        //第二次查询，由于上次更新操作，缓存数据已经清空（防止数据脏读），这里必须再次发出sql语句
        User user2 = userMapper2.getUser(2L);
        System.out.println(user2);
        sqlSession2.close();


    }

}