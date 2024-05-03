package com.mskim.singlemongodb;

import com.mskim.singlemongodb.document.User;
import com.mskim.singlemongodb.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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

    @GetMapping("/save/user")
    @ResponseBody
    public List<User> saveUser() {

        User user = new User();
        user.setData("2389");

        userRepository.save(user);

        List<User> userList = userRepository.findAll();

        return userList;
    }

    @GetMapping("/find/user/data")
    @ResponseBody
    public List<User> findUser() {

        List<User> userList = new ArrayList<>();

        if (userRepository.existsByData("0000")) {
            userList =  userRepository.findByData("2389");
        }

        return userList;
    }
}
