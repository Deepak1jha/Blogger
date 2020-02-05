package com.techcret.Blog.Security;

import com.techcret.Blog.Repository.UserRepository;
import com.techcret.Blog.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final Logger LOG = LoggerFactory.getLogger(CustomUserDetailsService.class);


    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserPrincipal loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("User Name"+username);

        User user = userRepository.findUsersByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username or email : " + username)
                );
        System.out.println("User - " + user.getPhoneNumber());
        return UserPrincipal.create(user);
    }
}
