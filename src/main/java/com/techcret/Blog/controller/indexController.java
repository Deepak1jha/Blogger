package com.techcret.Blog.controller;


import com.techcret.Blog.Repository.GetUserBlogRepository;
import com.techcret.Blog.Repository.UserRepository;
import com.techcret.Blog.commandObject.GetUserBlogCo;
import com.techcret.Blog.commandObject.IndexCo;
import com.techcret.Blog.model.GetUserBlog;
import com.techcret.Blog.valueObject.GetUserBlogVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")

public class indexController {

    private final UserRepository userRepository;
    private final GetUserBlogRepository getUserBlogRepository;

    public boolean isUserExist;

    public indexController(UserRepository userRepository, GetUserBlogRepository getUserBlogRepository) {
        this.userRepository = userRepository;
        this.getUserBlogRepository = getUserBlogRepository;
    }


    @GetMapping(value = "")
    public String create()
    {
        return "/blog/index";

    }


    @PostMapping(value = "create")
    public String save(IndexCo indexCo) {
        String email = indexCo.getEmail();


        isUserExist=userRepository.existsByEmail(email);


        System.out.println("User exits ? ="+isUserExist);

           if (isUserExist==true)
              {

                 return "redirect:/displayUserBlogs";

              }
           else
           return "/blog/userNotExist";


    }



    @GetMapping(value = "displayUserBlogs")
    public String list1(Model model){

        Iterable<GetUserBlog> iterable =  getUserBlogRepository.findAll();
        List<GetUserBlog> getUserBlogList = (List<GetUserBlog>) getUserBlogRepository.findAll();
        List<GetUserBlogVO> arrayList = new ArrayList<>();
        System.out.println(arrayList.size()+"ArrayList Size");


        for(GetUserBlog getUserBlog: getUserBlogList)
        {

            arrayList.add(new GetUserBlogVO(getUserBlog));


        }

        model.addAttribute("arrayList",arrayList);
        return "/blog/displayUserBlogs";



    }













}
