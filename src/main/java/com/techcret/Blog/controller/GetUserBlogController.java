package com.techcret.Blog.controller;


import com.techcret.Blog.Repository.GetUserBlogRepository;
import com.techcret.Blog.Repository.UserRepository;
import com.techcret.Blog.commandObject.GetUserBlogCo;
import com.techcret.Blog.model.GetUserBlog;
import com.techcret.Blog.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "getBlog")
public class GetUserBlogController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetUserBlogController.class);






    private final GetUserBlogRepository getUserBlogRepository;
    private final UserRepository userRepository;

    public GetUserBlogController(UserRepository userRepository, GetUserBlogRepository getUserBlogRepository) {


        this.userRepository = userRepository;
        this.getUserBlogRepository = getUserBlogRepository;

    }

    @GetMapping(value = "create")
    public String create()
    {
        return "/blog/GetUserBlogForm";
    }




    @PostMapping(value = "create")
    public String save(GetUserBlogCo getUserBlogCo)

    {
        String localStorage;
        localStorage=getUserBlogCo.getUserTableId();
        System.out.println(localStorage+"< --local storage value");

        User user =userRepository.findUsersByEmail(localStorage);
        GetUserBlog getUserBlog=new GetUserBlog(getUserBlogCo,user);
        getUserBlogRepository.save(getUserBlog);

        return "/blog/index";


    }




}
