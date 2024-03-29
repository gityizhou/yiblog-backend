package com.zhouyi.yiblog.service;

import com.zhouyi.yiblog.dao.UserRepository;
import com.zhouyi.yiblog.po.User;
import com.zhouyi.yiblog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return  user;
    }
}
