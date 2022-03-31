package com.ghostcoderz.vedveeracoaching.respository;

import com.ghostcoderz.vedveeracoaching.entity.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.InvalidJpaQueryMethodException;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {

    Optional<SecurityUser> findByUserName(String userName);

}
