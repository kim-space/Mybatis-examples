package com.mybatis.mapper;

import com.mybatis.po.Blog;

public interface BlogMapper {

    int insertBlog(Blog blog);

    Blog findOneBlog(Long id);
}
