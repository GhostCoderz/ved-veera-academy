package com.ghostcoderz.vedveeracoaching.controller;

import com.ghostcoderz.vedveeracoaching.entity.SecurityUser;
import com.ghostcoderz.vedveeracoaching.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView displayHomepage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    @GetMapping("/addAdminUser")
    public SecurityUser addAdminUser(){
        return userService.saveAdminUser();
    }

    @GetMapping("/contact-us")
    public ModelAndView displayContactUsPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("contactUs");
        return model;
    }

    @GetMapping("/about")
    public ModelAndView displayAboutUsPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("aboutUs");
        return model;
    }

//    @GetMapping("/user")
//    public String user() {
//        return ("<h1>Welcome SecurityUser</h1>");
//    }
//
//    @GetMapping("/admin")
//    public String admin() {
//        return ("<h1>Welcome Admin</h1>");
//    }

}
