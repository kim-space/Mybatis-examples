package com.mybatis.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@Builder
@Alias("blog")
public class Blog {

    private Long id;
    private String title;
    private String content;

    public Blog() {
    }

    public Blog(Long id, String title,String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
