package com.mskim.security.service;

import com.mskim.security.dto.LoginDTO;
import com.mskim.security.entity.UserEntity;

public interface LoginService {

    UserEntity loginProcess(LoginDTO loginDTO);
}
