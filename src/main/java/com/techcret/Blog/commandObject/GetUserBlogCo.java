package com.techcret.Blog.commandObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetUserBlogCo {

    private final Logger LOG = LoggerFactory.getLogger(GetUserBlogCo.class);
    private String title;
    private String description;
    private String inputMessage;
    private String userTableId;


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

    public String getUserTableId() {
        return userTableId;
    }

    public void setUserTableId(String userTableId) {
        this.userTableId = userTableId;
    }
}
