package com.techcret.Blog.Repository;

import com.techcret.Blog.model.GetUserBlog;
import com.techcret.Blog.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GetUserBlogRepository extends CrudRepository<GetUserBlog,Integer> {
    public List<GetUserBlog> findAllById(Integer i);











}
