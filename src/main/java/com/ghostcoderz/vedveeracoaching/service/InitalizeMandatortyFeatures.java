package com.ghostcoderz.vedveeracoaching.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public final class InitalizeMandatortyFeatures {
    private final UserService userService;

    public InitalizeMandatortyFeatures(UserService userService) {
        this.userService = userService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void addAdminUser() {
        userService.saveAdminUser();
    }

    public UserService userService() {
        return userService;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (InitalizeMandatortyFeatures) obj;
        return Objects.equals(this.userService, that.userService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userService);
    }

    @Override
    public String toString() {
        return "InitalizeMandatortyFeatures[" +
                "userService=" + userService + ']';
    }


}
