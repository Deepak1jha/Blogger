package com.techcret.Blog.Service;

import com.techcret.Blog.Repository.RoleRepository;
import com.techcret.Blog.Repository.UserRepository;
import com.techcret.Blog.model.Role;
import com.techcret.Blog.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BootStrapService implements InitializingBean {

    private final Logger LOG = LoggerFactory.getLogger(BootStrapService.class);


    @Autowired
    public RoleRepository roleRepository;


    @Override
    public void afterPropertiesSet() throws Exception {
        createRole();
        LOG.info("...Bootstrapping completed");
    }

    private void createRole() {
        List<String> roleList = Arrays.asList("ROLE_ADMIN", "ROLE_USER");
        for (String roleName : roleList) {
            if (roleRepository.countByName(roleName) == 0) {
                roleRepository.save(new Role(roleName));
            }
        }
    }


}
