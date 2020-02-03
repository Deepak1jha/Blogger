package com.techcret.Blog.model;

import com.techcret.Blog.commandObject.UserCo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer userId;

    @OneToMany(mappedBy = "user")
    private List<GetUserBlog> getUserBlog=new ArrayList<>();
    private String userName;


//    @ManyToMany
//    Set<Role> roleSet;

    @ManyToMany
    @JoinTable(
            name = "user_role"
           // joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            //inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
            )
    Set<Role> roleSet;



   // @Column(nullable = true,unique = true)
    private String email;

   // @Column(nullable = true,unique = true)
    private String phoneNumber;

    private String password;

    private String uuid;

    private String userRole;

    public User() {}

    public User(UserCo userCo){

        this.userName=userCo.getUserName();
        this.email=userCo.getEmail();
        this.phoneNumber=userCo.getPhoneNumber();
        uuid= UUID.randomUUID().toString();
        this.password=userCo.getPassword();
        this.userRole=userCo.getUserRole();
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<GetUserBlog> getGetUserBlog() {
        return getUserBlog;
    }

    public void setGetUserBlog(List<GetUserBlog> getUserBlog) {
        this.getUserBlog = getUserBlog;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", getUserBlog=" + getUserBlog +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
