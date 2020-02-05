package com.techcret.Blog.Repository;

import com.techcret.Blog.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role,Integer> {
    Optional<Role> findByName(String name);

    Integer countByName(String name);
}
