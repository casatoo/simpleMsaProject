package com.mskim.security.service;

import com.mskim.security.dto.JoinDTO;
import com.mskim.security.entity.UserEntity;
import com.mskim.security.repo.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinServiceImpl implements JoinService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void joinProcess(JoinDTO joinDTO){

        UserEntity data = new UserEntity();

        data.setLoginId(joinDTO.getLoginId());
        data.setPassword(bCryptPasswordEncoder.encode(joinDTO.getPassword()));
        data.setRole("ROLE_USER");

        userRepository.save(data);

    }

}
