package com.test.technique.Billing.services.interfaces;

import com.test.technique.Billing.models.User;

import java.util.List;

public interface IUserService {

    boolean createUser();
    boolean editUser();
    User findUser();
    List<User> findAll();
    boolean deleteUser(Long idUser);
}
