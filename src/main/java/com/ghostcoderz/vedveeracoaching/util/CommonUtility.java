package com.ghostcoderz.vedveeracoaching.util;

import com.ghostcoderz.vedveeracoaching.service.SecurityUserService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public record CommonUtility(SecurityUserService userService) {

    @EventListener(ApplicationReadyEvent.class)
    public void addAdminUser() {
        userService.saveAdminUser();
    }

    public static ModelAndView generateModeAndView(String viewName) {

        ModelAndView model = new ModelAndView();
        model.setViewName(viewName);
        return model;
    }

}
