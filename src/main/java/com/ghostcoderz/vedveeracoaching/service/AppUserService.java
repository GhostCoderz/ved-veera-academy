package com.ghostcoderz.vedveeracoaching.service;

import com.ghostcoderz.vedveeracoaching.dao.AppUserDAO;
import com.ghostcoderz.vedveeracoaching.entity.AppUser;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

@Service
public class AppUserService {

    private final AppUserDAO appUserDAO;

    public AppUserService(AppUserDAO appUserDAO) {
        this.appUserDAO = appUserDAO;
    }

    public void addUserToSession(String username, HttpSession session){

        AppUser adminUser = findUserByUsername(username);
        session.setAttribute("user_id", adminUser.getApp_user_id());
        session.setAttribute("username", username);

    }

    public AppUser findUserById(long user_id) {
        return appUserDAO.findById(user_id);
    }

    public AppUser findUserByUsername(String username) {
        return appUserDAO.findByUsername(username);
    }

}
