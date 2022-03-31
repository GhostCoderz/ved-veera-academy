package com.ghostcoderz.vedveeracoaching.service;

import com.ghostcoderz.vedveeracoaching.entity.AppUser;
import com.ghostcoderz.vedveeracoaching.entity.SecurityUser;
import com.ghostcoderz.vedveeracoaching.respository.SecurityUserRepository;
import com.ghostcoderz.vedveeracoaching.security.SecurityConfiguration;
import com.ghostcoderz.vedveeracoaching.entity.Role;
import com.ghostcoderz.vedveeracoaching.util.constant.APP_ROLE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Configuration
@Service
public class SecurityUserService {

    private final SecurityUserRepository securityUserRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    public SecurityUserService(SecurityUserRepository securityUserRepository) {
        this.securityUserRepository = securityUserRepository;
        this.passwordEncoder = (BCryptPasswordEncoder) SecurityConfiguration.getPasswordEncoder();
    }

    public void saveAdminUser(){
        String encodedPassword = passwordEncoder.encode("pass");
        List<Role> roles = List.of(new Role(APP_ROLE.ADMIN), new Role(APP_ROLE.USER));
        SecurityUser user = new SecurityUser("admin", encodedPassword , true, roles );
        logger.info("Added Admin User to the Security Users Table");
        saveUser(user);
    }

    public void saveUser( SecurityUser user){
        long secure_id = user.getSecure_id();
        String userName = user.getUserName();

        user.setAppUser(new AppUser(secure_id, userName));
        securityUserRepository.save(user);
    }

}
