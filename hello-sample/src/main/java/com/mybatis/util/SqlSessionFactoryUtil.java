package com.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {

    private static volatile SqlSessionFactory sqlSessionFactory = null;

    private static final Class CLASS_LOCK = SqlSessionFactoryUtil.class;

    private SqlSessionFactoryUtil() {

    }

    public static SqlSessionFactory initSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        if (sqlSessionFactory == null) {
            synchronized (CLASS_LOCK) {
                if (sqlSessionFactory == null) {
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
                }
                return sqlSessionFactory;
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSqlSession() throws IOException {
        if (sqlSessionFactory == null){
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}

