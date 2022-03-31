package com.ghostcoderz.vedveeracoaching.controller;

import com.ghostcoderz.vedveeracoaching.entity.ContactUs;
import com.ghostcoderz.vedveeracoaching.util.email.EmailSender;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static com.ghostcoderz.vedveeracoaching.util.CommonUtility.generateModeAndView;

@RestController
public class HomeController {

    private final EmailSender emailSender;

    public HomeController(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @GetMapping("/")
    public ModelAndView displayHomepage(){
        return generateModeAndView("index");
    }

    @GetMapping("/contact-us")
    public ModelAndView displayContactUsPage(){
        return generateModeAndView("contactUs");
    }

    @PostMapping(value = "/contact-us", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public ModelAndView displayContactUsPage( ContactUs contactUs){

        emailSender.sendTemplateContactEmail(
                contactUs.getFullName(),
                contactUs.getEmail(),
                contactUs.getMessage(),
                contactUs.getCourse(),
                contactUs.getContactNum());

        return generateModeAndView("contactUs");
    }


    @GetMapping("/about")
    public ModelAndView displayAboutUsPage(){
        return generateModeAndView("aboutUs");
    }

}
