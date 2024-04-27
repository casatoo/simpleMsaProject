package com.mskim.security.repo;

import com.mskim.security.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    boolean existsByLoginId(String loginId);

    UserEntity findByLoginId(String loginId);

}
