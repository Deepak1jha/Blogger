package com.techcret.Blog.controller;


import com.techcret.Blog.Repository.GetUserBlogRepository;
import com.techcret.Blog.Repository.UserRepository;
import com.techcret.Blog.commandObject.GetUserBlogCo;
import com.techcret.Blog.commandObject.IndexCo;
import com.techcret.Blog.model.GetUserBlog;
import com.techcret.Blog.model.User;
import com.techcret.Blog.valueObject.GetUserBlogVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(value = "/")

public class IndexController {

    private final UserRepository userRepository;
    private final GetUserBlogRepository getUserBlogRepository;
    public Integer myUserId;


    public IndexController(UserRepository userRepository, GetUserBlogRepository getUserBlogRepository) {
        this.userRepository = userRepository;
        this.getUserBlogRepository = getUserBlogRepository;
    }


    @GetMapping(value = "")
    public String create() {
        return "/blog/index";

    }


    @PostMapping(value = "create")
    public String save(IndexCo indexCo, RedirectAttributes redirectAttributes)
    {
        String email = indexCo.getEmail();
        boolean isUserExist = userRepository.existsByEmail(email);


        if (isUserExist) {

            User user = userRepository.findUsersByEmail(email);
            myUserId = user.getUserId();
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
        return "/blog/displayUserBlogs";


    }


    @GetMapping(value = "displayUserBlogs")
    public String list1(Model model, @RequestParam String userId) throws NullPointerException {

        int userUrlId = Integer.parseInt(userId);
        User user=userRepository.findUsersByUserId(userUrlId);

        Iterable<GetUserBlog> iterable = user.getGetUserBlog();
        List<GetUserBlog> getUserBlogList =user.getGetUserBlog();
        List<GetUserBlogVO> arrayList = new ArrayList<>();

        for (GetUserBlog getUserBlog : getUserBlogList) {
            arrayList.add(new GetUserBlogVO(getUserBlog));
        }

        model.addAttribute("arrayList", arrayList);

        return "/blog/displayUserBlogs";
    }
}
