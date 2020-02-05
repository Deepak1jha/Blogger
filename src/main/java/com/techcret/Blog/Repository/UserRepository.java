package com.techcret.Blog.Repository;

import com.techcret.Blog.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    boolean existsByEmail(String atr);

    Integer findDistinctByEmail(String rr);

    List<User> findAllByEmail(String strr);

    User findUserByEmail(String str);

    public List<User> findAllByEmailContaining(String strrr);

    public User deleteUserByEmail(String email);

    Optional<User> findUsersByEmail(String localStorageEmailId);
    // User findUsersByEmail(String localStorageEmailId);


    User findUsersById(Long i);

    User findByEmail(String emailid);


}
