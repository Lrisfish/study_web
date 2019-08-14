package com.example.demo.service;

import com.example.demo.entity.master;
import com.example.demo.mapper.masterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class masterService {
    @Autowired
    private masterMapper masterMapper;

    /**注册**/
    public int masterRegister(String username, String password){
        master user = new master();
        user.setMasterName(username);
        user.setMasterPassword(password);
        return masterMapper.addMaster(user);
        //return masterMapper.addMaster(username,password);
    }

    /**登陆**/
    public master masterLogin(String username, String password){
        master user = new master();
        user.setMasterName(username);
        user.setMasterPassword(password);
        return masterMapper.masterLogin(user);
    }
}
