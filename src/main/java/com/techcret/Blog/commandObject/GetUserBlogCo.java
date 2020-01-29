package com.techcret.Blog.commandObject;

public class GetUserBlogCo {
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
