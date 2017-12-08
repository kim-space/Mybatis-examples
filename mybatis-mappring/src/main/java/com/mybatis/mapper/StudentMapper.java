package com.mybatis.mapper;

import com.mybatis.po.Student;

import java.util.List;

public interface StudentMapper {

    int insertStudent(Student student);

    Student getStudentInfo(Integer id);

    Student getStudentInfo2(Integer id);

    List<Student> getStudents(Integer clzzId);

}
