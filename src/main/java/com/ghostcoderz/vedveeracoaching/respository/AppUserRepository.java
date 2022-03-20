package com.ghostcoderz.vedveeracoaching.respository;

import com.ghostcoderz.vedveeracoaching.entity.AppUser;
import com.ghostcoderz.vedveeracoaching.entity.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByName(String name);
}
