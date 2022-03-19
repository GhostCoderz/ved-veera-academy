package com.ghostcoderz.vedveeracoaching.security;

import com.ghostcoderz.vedveeracoaching.entity.SecurityUser;
import com.ghostcoderz.vedveeracoaching.respository.SecurityUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final SecurityUserRepository userRepository;

    public MyUserDetailsService(SecurityUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SecurityUser> user = userRepository.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("SecurityUser not found : " + username));

        return user.map(MyUserDetails::new).get();
    }

}
