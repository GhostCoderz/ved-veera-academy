package com.ghostcoderz.vedveeracoaching.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

    @GetMapping("/login")
    public ModelAndView displayLoginPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @GetMapping("/login/error")
    public ModelAndView displayLoginErrorPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("invalidLogin");
        return model;
    }

}
