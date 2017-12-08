package com.mybatis.mapper;

import ch.qos.logback.classic.spi.STEUtil;
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

public class StudentMapperTest {

    SqlSession session;
    ClazzMapper clazzMapper;
    StudentMapper studentMapper;

    @Before
    public void setupo() throws IOException {
        String  resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        session = build.openSession();
        clazzMapper = session.getMapper(ClazzMapper.class);
        studentMapper = session.getMapper(StudentMapper.class);

    }

    @Test
    public void insertStudent() throws Exception {
        Clazz clazz = clazzMapper.getClazz(1);
        Student student = Student.builder()
                .name("Sandy")
                .age(22)
                .sex("女")
                .clazz(clazz)
                .build();
        studentMapper.insertStudent(student);
        session.commit();
        System.out.println(student);
    }

    @Test
    public void getStudentInfo() throws Exception {
        Student studentInfo = studentMapper.getStudentInfo(1);
        System.out.println(studentInfo);
    }

    @Test
    public void getStudentInfo2(){
        Student studentInfo2 = studentMapper.getStudentInfo2(2);
        System.out.println(studentInfo2);
    }

    @Test
    public void getStudents(){
        List<Student> students = studentMapper.getStudents(1);
        students.forEach(System.out::println);
    }


}