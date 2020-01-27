package com.techcret.Blog.Repository;

import com.techcret.Blog.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Integer> {


}
