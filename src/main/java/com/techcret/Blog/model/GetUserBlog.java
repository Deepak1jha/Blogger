package com.techcret.Blog.model;

import com.techcret.Blog.commandObject.GetUserBlogCo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Entity
public class GetUserBlog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDateTime createdDateTime;
    private String title;
    private String description;
    private String inputMessage;
    private String uuid;


    @JoinColumn(name = "user")
    @ManyToOne
    private User user;


    public GetUserBlog(GetUserBlogCo getUserBlogCo, User user) {


        this.title = getUserBlogCo.getTitle();
        this.description = getUserBlogCo.getDescription();
        this.inputMessage = getUserBlogCo.getInputMessage();
        this.createdDateTime = LocalDateTime.now();
        this.uuid = UUID.randomUUID().toString();
        this.user = user;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInputMessage() {
        return inputMessage;
    }

    public void setInputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


}
