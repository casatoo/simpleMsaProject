package com.mskim.security.service;

import com.mskim.security.dto.JoinDTO;
import org.springframework.stereotype.Service;

@Service
public interface JoinService {

    void joinProcess(JoinDTO joinDTO);

}
