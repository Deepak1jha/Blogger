package com.techcret.Blog.controller;

import com.techcret.Blog.Repository.UserRepository;
import com.techcret.Blog.commandObject.UserCo;
import com.techcret.Blog.model.Post;
import com.techcret.Blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "userData")
public class UserController {


    private final UserRepository userRepository;

    public UserController(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }


    @GetMapping(value = "create")
    public String create()
    {


       //User ur= userRepository.deleteUserByEmail("pdf");
        //System.out.println("System");

        return "/blog/signUp";

    }


    @PostMapping(value = "create")
    public String save(UserCo userCo)
    {
        /*System.out.println(userCo.getEmail());

        User userInc=new User(userCo);
        userRepository.save(userInc);


        //return "redirect:/blog/getPost";
        return "redirect:/blog/signUp";*/

        //System.out.println(userRepository.findUserByEmail("deepak"));


        System.out.println("userCo.getEmail()");




        User userInc=new User(userCo);


        userRepository.save(userInc);







        //return "redirect:/blog/GetUserBlogForm";
        return "/blog/index";



 }

 @GetMapping(value = "indexx")
    public String list1(Model model){




        return "redirect:/blog/displayUserBlogs";
    }

}
