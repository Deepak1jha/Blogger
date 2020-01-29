package com.techcret.Blog.controller;

import com.techcret.Blog.Repository.UserRepository;
import com.techcret.Blog.commandObject.UserCo;
import com.techcret.Blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "userData")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @GetMapping(value = "create")
    public String create() {
         return "/blog/signUp";
    }

    @PostMapping(value = "create")
    public String save(UserCo userCo) {

        User userInc=new User(userCo);
        userRepository.save(userInc);
        return "redirect:displayUserBlogs";
    }



    @GetMapping(value = "displayUserBlogs")
    public String list1(Model model){
        String enterRecord="Enter Your Records. No ";
        model.addAttribute("enterRecord", enterRecord);
        return "/blog/displayUserBlogs";
    }

}
