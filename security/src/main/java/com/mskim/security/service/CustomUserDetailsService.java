package com.mskim.security.service;

import com.mskim.security.dto.CustomUserDetails;
import com.mskim.security.entity.UserEntity;
import com.mskim.security.repo.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {

        UserEntity userData = userRepository.findByLoginId(loginId);

        if(!ObjectUtils.isEmpty(userData)) {

            return new CustomUserDetails(userData);
        }

        return null;
    }
}
