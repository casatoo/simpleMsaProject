package com.mskim.security.service;

import com.mskim.security.dto.LoginDTO;
import com.mskim.security.entity.UserEntity;
import com.mskim.security.repo.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    @Resource
    UserRepository userRepository;

    public UserEntity loginProcess(LoginDTO loginDTO) {

        return userRepository.findById(1).get();
    }
}
