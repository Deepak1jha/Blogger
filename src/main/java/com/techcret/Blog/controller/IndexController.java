package com.techcret.Blog.controller;


import com.techcret.Blog.Repository.GetUserBlogRepository;
import com.techcret.Blog.Repository.UserRepository;
import com.techcret.Blog.commandObject.IndexCo;
import com.techcret.Blog.model.GetUserBlog;
import com.techcret.Blog.model.User;
import com.techcret.Blog.valueObject.GetUserBlogVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/")

public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    private final UserRepository userRepository;
    private final GetUserBlogRepository getUserBlogRepository;
    public Long myUserId;


    public IndexController(UserRepository userRepository, GetUserBlogRepository getUserBlogRepository) {
        this.userRepository = userRepository;
        this.getUserBlogRepository = getUserBlogRepository;
    }


    @GetMapping(value = "/login")
    public String create(@RequestParam Optional<String> error) {
        //return "/blog/index";
        LOGGER.debug("Getting login page, error={}", error);

        return "/blog/Auth/login";

    }


    @PostMapping(value = "create")
    public String save(IndexCo indexCo, RedirectAttributes redirectAttributes) {
        String email = indexCo.getEmail();
        boolean isUserExist = userRepository.existsByEmail(email);


        if (isUserExist) {

            User user = userRepository.findByEmail(email);
            myUserId = user.getId();
            redirectAttributes.addAttribute("userId", user);


            return "redirect:/displayUserBlogs";


        } else {
            return "redirect:/userNotFound";
        }

    }


    @GetMapping(value = "userNotFound")
    public String notfound(Model model) {

        String notFound = "User Not Found";
        model.addAttribute("notFound", notFound);
        return "/blog/DisplayUserData/displayUserBlogs";


    }


    @GetMapping(value = "displayUserBlogs")
    public String list1(Model model, @RequestParam String userId) throws NullPointerException {

        long userUrlId = Long.parseLong(userId);
        User user = userRepository.findUsersById(userUrlId);

        Iterable<GetUserBlog> iterable = user.getGetUserBlog();
        List<GetUserBlog> getUserBlogList = user.getGetUserBlog();
        List<GetUserBlogVO> arrayList = new ArrayList<>();

        for (GetUserBlog getUserBlog : getUserBlogList) {
            arrayList.add(new GetUserBlogVO(getUserBlog));
        }

        model.addAttribute("arrayList", arrayList);

        return "/blog/DisplayUserData/displayUserBlogs";
    }
}
