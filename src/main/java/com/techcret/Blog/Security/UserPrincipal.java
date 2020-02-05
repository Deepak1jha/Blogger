package com.techcret.Blog.Security;

import com.techcret.Blog.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private final Logger LOG = LoggerFactory.getLogger(UserPrincipal.class);

    private String id;

    private String username;

    private String password;

    private Collection<? extends GrantedAuthority> authorities;   //** ask **


    public UserPrincipal(String uuid, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = uuid;
        this.username = username;                                       //** ASK ?**
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(User user) {

        System.out.println("User==>>"+user.getRoleSet());
        List<GrantedAuthority> authorities = user.getRoleSet().stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return new UserPrincipal(
                user.getUuid(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    public String getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
