package com.ghostcoderz.vedveeracoaching.controller;

import com.ghostcoderz.vedveeracoaching.service.AppUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

    @Mock
    private AppUserService appUserService;
    private ModelAndView modelAndView;
    private LoginController loginController;

    @BeforeEach
    void setUp() {
        this.modelAndView = new ModelAndView();
        this.loginController = new LoginController(appUserService);
    }

    @Test
    void displayLoginPage() {
        // Given
        ModelAndView expected = modelAndView;
        expected.setViewName("login");

        // When
        ModelAndView actual = loginController.displayLoginPage();

        // Then
        Assertions.assertEquals(expected.getModel(), actual.getModel());
        Assertions.assertEquals(expected.hasView(), actual.hasView());
        Assertions.assertEquals(expected.getViewName(), actual.getViewName());
    }

    @Test
    void displayLoginErrorPage() {
        // Given
        ModelAndView expected = modelAndView;
        expected.setViewName("invalidLogin");

        // When
        ModelAndView actual = loginController.displayLoginErrorPage();

        // Then
        Assertions.assertEquals(expected.getModel(), actual.getModel());
        Assertions.assertEquals(expected.hasView(), actual.hasView());
        Assertions.assertEquals(expected.getViewName(), actual.getViewName());
    }

    @Test
    void displayDashboard() {
        // Given
        ModelAndView expected = modelAndView;
        expected.setViewName("dashboard");

        // When
        HttpSession session = new MockHttpSession();
        ModelAndView actual = loginController.displayDashboard(session);

        // Then
        Assertions.assertEquals(expected.getModel(), actual.getModel());
        Assertions.assertEquals(expected.hasView(), actual.hasView());
        Assertions.assertEquals(expected.getViewName(), actual.getViewName());
    }
}