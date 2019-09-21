package com.zhouyi.yiblog.service;

import com.zhouyi.yiblog.po.User;



public interface UserService {

    User checkUser(String username, String password);
}
