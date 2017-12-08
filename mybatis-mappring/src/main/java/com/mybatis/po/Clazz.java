package com.mybatis.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Alias("clazz")
public class Clazz {
    private Integer id;
    private String code;
    private String name;
    private List<Student> students;
}
