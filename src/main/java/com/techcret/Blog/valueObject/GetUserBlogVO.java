package com.techcret.Blog.valueObject;

import com.techcret.Blog.model.GetUserBlog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class GetUserBlogVO {
    private final Logger LOG = LoggerFactory.getLogger(GetUserBlogVO.class);


    private LocalDateTime createdDateTime;
    private String title;
    private String description;
    private String inputMessage;


    public GetUserBlogVO() {
    }

    public GetUserBlogVO(GetUserBlog getUserBlog) {

        this.createdDateTime = getUserBlog.getCreatedDateTime();
        this.title = getUserBlog.getTitle();
        this.description = getUserBlog.getDescription();
        this.inputMessage = getUserBlog.getInputMessage();

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
}
