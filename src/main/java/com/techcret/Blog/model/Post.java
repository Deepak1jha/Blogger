package com.techcret.Blog.model;

import com.techcret.Blog.commandObject.PostCo;
import com.techcret.Blog.commandObject.UserCo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer postId;


    private String postTitle;
    private String postDescription;
    private LocalDateTime postCreatedDate;
    private String postAuthorName;
    private String authorEmail;
    private String postMessage;



    public Post()
    {}

    public Post(PostCo postCo)
    {
        this.postTitle=postCo.getPostTitle();
        this.postDescription=postCo.getPostDescription();
        this.postMessage=postCo.getPostMessage();
        this.postCreatedDate=LocalDateTime.now();


    }

    public String getPostMessage() {
        return postMessage;
    }

    public void setPostMessage(String postMessage) {
        this.postMessage = postMessage;
    }





    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public LocalDateTime getPostCreatedDate() {
        return postCreatedDate;
    }

    public void setPostCreatedDate(LocalDateTime postCreatedDate) {
        this.postCreatedDate = postCreatedDate;
    }

    public String getPostAuthorName() {
        return postAuthorName;
    }

    public void setPostAuthorName(String postAuthorName) {
        this.postAuthorName = postAuthorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }
}
