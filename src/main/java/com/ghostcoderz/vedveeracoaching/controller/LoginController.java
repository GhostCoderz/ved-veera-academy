package com.ghostcoderz.vedveeracoaching.controller;

import com.ghostcoderz.vedveeracoaching.security.SecurityUtility;
import com.ghostcoderz.vedveeracoaching.service.AppUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import static com.ghostcoderz.vedveeracoaching.util.CommonUtility.generateModeAndView;

@RestController
public class LoginController {

    private final AppUserService appUserService;

    public LoginController(AppUserService userService) {
        this.appUserService = userService;
    }

    @GetMapping("/login")
    public ModelAndView displayLoginPage(){
        return generateModeAndView("login");
    }

    @GetMapping("/login/error")
    public ModelAndView displayLoginErrorPage(){
        return generateModeAndView("invalidLogin");
    }

    @GetMapping("/dashboard")
    public ModelAndView displayDashboard(HttpSession session){

        //Adding User to Session
        String username = SecurityUtility.getCurrentUserLogin();
        appUserService.addUserToSession(username, session);

        return generateModeAndView("dashboard");

    }

}
