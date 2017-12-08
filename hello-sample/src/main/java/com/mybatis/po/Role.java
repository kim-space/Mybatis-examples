package com.mybatis.po;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("role")
public class Role {
    private Long Id;
    private String roleName;
    private String note;
}
