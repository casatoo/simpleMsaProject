package com.mskim.oauthsession.repository;

import com.mskim.oauthsession.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
