package com.mybatis.po;

import com.mybatis.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@Alias("user")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
    private Long id;
    private String userName;
    private String cnname;
    private Date birthday;
    private String mobile;
    private Sex sex;
    private String email;
    private String note;


}
