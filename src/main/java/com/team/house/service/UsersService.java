package com.team.house.service;

import com.team.house.entity.Users;

import java.util.List;

public interface UsersService {
    public int usersReg(Users users);
    public Users usersLogin(String name,String password);
}
