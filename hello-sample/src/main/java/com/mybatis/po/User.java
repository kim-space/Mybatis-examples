package com.mybatis.po;

import com.mybatis.enums.Sex;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Builder
@Alias("user")
public class User {
    private Long id;
    private String userName;
    private String cnname;
    private Date birthday;
    private String mibile;
    private Sex sex;
    private String email;
    private String note;


}
