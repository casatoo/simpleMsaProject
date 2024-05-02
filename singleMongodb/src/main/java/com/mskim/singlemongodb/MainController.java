package com.mskim.singlemongodb;

import com.mskim.singlemongodb.document.User;
import com.mskim.singlemongodb.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    @Resource
    UserRepository userRepository;

    @GetMapping("/")
    @ResponseBody
    public List<User> MainP() {

        List<User> userList = userRepository.findAll();

        return userList;
    }
}
