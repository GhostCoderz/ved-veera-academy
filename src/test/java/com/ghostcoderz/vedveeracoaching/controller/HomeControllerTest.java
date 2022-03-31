package com.ghostcoderz.vedveeracoaching.controller;

import com.ghostcoderz.vedveeracoaching.util.email.EmailSender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@ExtendWith(MockitoExtension.class)
class HomeControllerTest {

    @Mock
    private EmailSender emailSender;
    private ModelAndView modelAndView;
    private HomeController homeController;

    @BeforeEach
    void setUp() {
        this.modelAndView = new ModelAndView();
        this.homeController = new HomeController(emailSender);
    }

    @Test
    void doesDisplayHomepageReturnIndexView() {
        // Given
        ModelAndView expected = modelAndView;
        expected.setViewName("index");

        // When
        ModelAndView actual = homeController.displayHomepage();

        // Then
        Assertions.assertEquals(expected.getModel(), actual.getModel());
        Assertions.assertEquals(expected.hasView(), actual.hasView());
        Assertions.assertEquals(expected.getViewName(), actual.getViewName());
    }

    @Test
    @GetMapping("/contact-us")
    void doesDisplayContactUsPageReturnContactUsView(){
        // Given
        ModelAndView expected = modelAndView;
        expected.setViewName("contactUs");

        // When
        ModelAndView actual = homeController.displayContactUsPage();

        // Then
        Assertions.assertEquals(expected.getModel(), actual.getModel());
        Assertions.assertEquals(expected.hasView(), actual.hasView());
        Assertions.assertEquals(expected.getViewName(), actual.getViewName());
    }

    @Test
    void doesDisplayAboutUsPageReturnAboutUsView (){
        // Given
        ModelAndView expected = modelAndView;
        expected.setViewName("aboutUs");

        // When
        ModelAndView actual = homeController.displayAboutUsPage();

        // Then
        Assertions.assertEquals(expected.getModel(), actual.getModel());
        Assertions.assertEquals(expected.hasView(), actual.hasView());
        Assertions.assertEquals(expected.getViewName(), actual.getViewName());
    }

}