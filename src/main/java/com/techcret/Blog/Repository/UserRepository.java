package com.techcret.Blog.Repository;

import com.techcret.Blog.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository <User,Integer>{

   boolean existsByEmail(String atr);
   //List<User> findAllBy
   //Integer findUserByEmail(String str);
   Integer  findDistinctByEmail(String rr);
   List<User> findAllByEmail(String strr);
   User findUserByEmail(String str);
   //List<User> findUsersByEmailAndGetUserBlogAndUserId(String strr);
   public List<User> findAllByEmailContaining(String strrr);
   public User deleteUserByEmail(String email);


}
