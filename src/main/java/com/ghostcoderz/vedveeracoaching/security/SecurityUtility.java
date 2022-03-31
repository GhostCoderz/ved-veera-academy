package com.ghostcoderz.vedveeracoaching.security;

import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@NoArgsConstructor
public final class SecurityUtility {


    public static String getCurrentUserLogin() {
        SecurityContext securityContext = (SecurityContext) SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        try {

            if (authentication != null) {
                MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
                return userDetails.getUsername();
            }
            return null;

        } catch (Exception e) {
            System.out.println("Error in finding user in the session");
            e.printStackTrace();
            return null;
        }
    }
}
