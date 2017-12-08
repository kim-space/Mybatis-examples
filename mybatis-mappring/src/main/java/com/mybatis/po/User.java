package com.mybatis.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Alias("User")
public class User {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Card card;
}
