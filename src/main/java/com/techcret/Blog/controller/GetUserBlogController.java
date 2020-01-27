package com.techcret.Blog.controller;


import com.techcret.Blog.Repository.GetUserBlogRepository;
import com.techcret.Blog.commandObject.GetUserBlogCo;
import com.techcret.Blog.model.GetUserBlog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "getBlog")
public class GetUserBlogController {


    private final GetUserBlogRepository getUserBlogRepository;

    public GetUserBlogController(GetUserBlogRepository getUserBlogRepository) {
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

        System.out.println(getUserBlogCo.getDescription());

        GetUserBlog getUserBlog=new GetUserBlog(getUserBlogCo);
        getUserBlogRepository.save(getUserBlog);

        return "/blog/index";


    }




}
