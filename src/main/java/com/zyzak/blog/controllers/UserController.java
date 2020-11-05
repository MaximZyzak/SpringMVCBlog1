package com.zyzak.blog.controllers;


import com.zyzak.blog.dao.UserDAO;
import com.zyzak.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserDAO userDAO;

   /* @Value("${user.nickname}")
    private String nickname;

    @Value("${user.password}")
    private String password;*/

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/login")
    public String login(){
        return "/user/login";
    }

    /*@PostMapping("/login")
    public String loginUserC(@ModelAttribute("user") User user){
         User u = userDAO.login(user);
         if (u!=null){
             System.out.println(u.getNick_name());
             System.out.println(u.getPassword());
         }

        return("redirect:main");
    }*/

    @PostMapping("/login")
    public String loginUserM(@ModelAttribute("user") User user){
        User u = userDAO.login(user);
        if (u!=null){
            System.out.println(u.getNick_name());
            System.out.println(u.getPassword());
            System.out.println(u.getUser_id());

            User.nick_name_s = u.getNick_name();
            User.password_S = u.getPassword();
            User.user_id_s = u.getUser_id();
        }
        return("redirect:/");
    }
}
