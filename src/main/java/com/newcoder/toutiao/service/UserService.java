package com.newcoder.toutiao.service;

import com.newcoder.toutiao.dao.UserDAO;
import com.newcoder.toutiao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:Siyu
 * @Date:Created in 下午5:44 2018/6/22
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public User getUser(int id) {
        return userDAO.selectById(id);
    }

}
