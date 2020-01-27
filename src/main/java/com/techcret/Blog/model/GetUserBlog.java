package com.techcret.Blog.model;


import com.techcret.Blog.commandObject.GetUserBlogCo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
//@Table(name ="blog")
public class GetUserBlog {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private LocalDateTime createdDateTime;
    private String title;
    private String description;
    private String inputMessage;
    private String uuid;



@JoinColumn(name = "user")
@ManyToOne
private User user;






    public GetUserBlog()
    {}

    public GetUserBlog(GetUserBlogCo getUserBlogCo)
    {


        this.title=getUserBlogCo.getTitle();
        this.description=getUserBlogCo.getDescription();
        this.inputMessage=getUserBlogCo.getInputMessage();
        this.createdDateTime=LocalDateTime.now();
        this.uuid=UUID.randomUUID().toString();
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

    @Override
    public String toString() {
        return "GetUserBlog{" +
                "id=" + id +
                ", createdDateTime=" + createdDateTime +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", inputMessage='" + inputMessage + '\'' +
                ", user=" + user +
                '}';
    }
}