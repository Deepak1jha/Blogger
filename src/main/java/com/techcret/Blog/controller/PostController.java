package com.techcret.Blog.controller;

import com.techcret.Blog.Repository.PostRepository;
import com.techcret.Blog.commandObject.PostCo;
import com.techcret.Blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "blogSave")
public class PostController
{
   private final PostRepository postRepository;


    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping(value = "create")
    public String create()
    {
        return "/blog/getPost";
    }





    @PostMapping(value = "create")
    public String save(PostCo postCo)
    {


        System.out.println(postCo.getPostTitle()+"Post Controller CLass");
        System.out.println(postRepository.count());

        Post postInc=new Post(postCo);
        postRepository.save(postInc);


        return "redirect:/blog/index";
        //return "/blog/signUp";





    }

      @GetMapping(value = "indexx")
    public String list1(Model model){

          return "redirect:/blog/index";
    }



}
