package com.zyzak.blog.controllers;

import com.zyzak.blog.dao.CommentDAO;
import com.zyzak.blog.dao.PostDAO;
import com.zyzak.blog.dao.UserDAO;
import com.zyzak.blog.dao.User_postDAO;
import com.zyzak.blog.models.Comment;
import com.zyzak.blog.models.Post;
import com.zyzak.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
        model.addAttribute("cur_user",User.user_id_s);
        return "posts/allPost";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("post",postDAO.getById(id));
        model.addAttribute("comments",commentDAO.comments());
        model.addAttribute("cur_user",User.user_id_s);
        return "posts/post";
    }

    @PostMapping("/{id}")
    public String addComment(@PathVariable("id") int id,
                             @ModelAttribute("comment") Comment comm){
        System.out.println(comm.getComment_text());
        System.out.println(User.user_id_s);
        commentDAO.addComm(comm, User.user_id_s);
        return("redirect:/posts/"+id);
    }

    @GetMapping("/addPost")
    public String add(){
        return "posts/createPost";
    }

    @PostMapping("/addPost")
    public String addPost(@ModelAttribute("post") Post post){
        postDAO.add(post);
        Post p = postDAO.getPostLastId();
        user_postDAO.add(User.user_id_s,p.getPost_id());
        return("redirect:/posts");
    }

    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable("id") int id){
        postDAO.delete(id);
        return("redirect:/posts");
    }

    @GetMapping("/updatePost/{id}")
    public String update(@PathVariable("id")int id, Model model){
        model.addAttribute("post",postDAO.getById(id));
        return "posts/editPost";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute("post") Post post){
        postDAO.update(post);
        return("redirect:/posts");
    }

    @GetMapping("/deleteComm/{id}")
    public String deleteComm(@PathVariable("id") int id){
        commentDAO.deleteComm(id);
        return("redirect:/posts");
    }


    @PostMapping("/updateComm/{id}")
    public String updateComm(@PathVariable("id")int id,
                          @ModelAttribute("comment") Comment comment){
        commentDAO.updateComm(comment);
        return("redirect:/posts/"+id);
    }

}
