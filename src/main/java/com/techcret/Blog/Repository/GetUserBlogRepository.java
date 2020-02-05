package com.techcret.Blog.Repository;

import com.techcret.Blog.model.GetUserBlog;
import com.techcret.Blog.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GetUserBlogRepository extends CrudRepository<GetUserBlog, Integer> {
    public List<GetUserBlog> findAllById(Integer i);

    List<GetUserBlog> findAllByUser(User user);

    List<GetUserBlog> findAllByIdLike(Integer iii);

    Optional<GetUserBlog> findById(Integer ii);


}
