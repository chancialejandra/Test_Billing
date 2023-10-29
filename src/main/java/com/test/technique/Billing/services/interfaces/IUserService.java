package com.test.technique.Billing.services.interfaces;

import com.test.technique.Billing.dto.Request.UserRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;
import com.test.technique.Billing.models.User;

import java.util.List;

public interface IUserService {

    boolean findByDni(String dni);
    MessageResponse createUser(UserRequest user);
    boolean editUser();
    User findUser();
    List<User> findAll();
    boolean deleteUser(Long idUser);
}
