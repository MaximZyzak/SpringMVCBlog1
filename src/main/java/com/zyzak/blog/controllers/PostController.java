package com.zyzak.blog.controllers;

import com.zyzak.blog.dao.CommentDAO;
import com.zyzak.blog.dao.PostDAO;
import com.zyzak.blog.dao.UserDAO;
import com.zyzak.blog.dao.User_postDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostController {
    private final PostDAO postDAO;

    private final UserDAO userDAO;

    private final User_postDAO user_postDAO;

    private final CommentDAO commentDAO;

    @Autowired
    public PostController(PostDAO postDAO, UserDAO userDAO, User_postDAO user_postDAO, CommentDAO commentDAO) {
        this.postDAO = postDAO;
        this.userDAO = userDAO;
        this.user_postDAO = user_postDAO;
        this.commentDAO = commentDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("posts",postDAO.posts());
        model.addAttribute("comments",commentDAO.comments());
        model.addAttribute("user_post",user_postDAO.user_post());
        model.addAttribute("users",userDAO.users());
        return "posts/allPost";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("post",postDAO.getById(id));
        return "posts/post";
    }


}
