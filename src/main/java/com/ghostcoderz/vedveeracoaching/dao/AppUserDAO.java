package com.ghostcoderz.vedveeracoaching.dao;

import com.ghostcoderz.vedveeracoaching.entity.AppUser;
import com.ghostcoderz.vedveeracoaching.respository.AppUserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AppUserDAO {

    private final AppUserRepository appUserRepository;

    public AppUserDAO(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser findById(long user_id) {
        return appUserRepository.findById(user_id)
                .orElseThrow(() -> new UsernameNotFoundException
                        ("User with id not found : " + user_id));
    }

    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException
                        ("User with username not found : " + username));
    }

}
