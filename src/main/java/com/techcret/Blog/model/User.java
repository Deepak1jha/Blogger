package com.techcret.Blog.model;

import com.techcret.Blog.commandObject.UserCo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<GetUserBlog> getUserBlog = new ArrayList<>();
    private String userName;


//    @ManyToMany
//    Set<Role> roleSet;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    Set<Role> roleSet;


    // @Column(nullable = true,unique = true)
    private String email;

    // @Column(nullable = true,unique = true)
    private String phoneNumber;

    private String password;

    private String uuid;

  //  private String userRole;

    public User(UserCo userCo,Role role) {

        this.userName = userCo.getUserName();
        this.email = userCo.getEmail();
        this.phoneNumber = userCo.getPhoneNumber();
        this.uuid = UUID.randomUUID().toString();
        this.password = userCo.getPassword();
        //this.userRole = userCo.getUserRole();
        Set<Role> roleSet = this.getRoleSet();
        if (roleSet == null)
            roleSet = new HashSet<>();
        roleSet.add(role);
        this.setRoleSet(roleSet);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", getUserBlog=" + getUserBlog +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
