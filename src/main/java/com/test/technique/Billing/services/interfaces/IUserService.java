package com.test.technique.Billing.services;

import com.test.technique.Billing.models.User;

import java.util.List;

public interface IUserService {


    public boolean createUser(Long idUser);
    public boolean editUser();
    public User findUser();
    public List<User> findAll();
    public boolean deleteUser();
}
