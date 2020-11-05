package com.zyzak.blog.controllers;

import com.zyzak.blog.dao.UserDAO;
import com.zyzak.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final UserDAO userDAO;

    @Autowired
    public MainController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String index(){
        if (User.nick_name_s.equals("") && User.password_S.equals("")){
            return "/user/login";
        }
        else{
            System.out.println(User.nick_name_s);
            System.out.println(User.password_S);
            return "main";
        }
    }

    @PostMapping("/")
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
