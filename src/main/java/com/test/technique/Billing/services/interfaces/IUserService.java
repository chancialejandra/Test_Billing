package com.test.technique.Billing.services.interfaces;

import com.test.technique.Billing.dto.Request.UserRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;
import com.test.technique.Billing.dto.Response.UserResponse;
import com.test.technique.Billing.models.UserModel;

import java.util.Optional;


public interface IUserService {

    boolean existUser(String dni);
    Optional<UserModel>  searchUserByDni(String dni);
    UserResponse getUser(String dni);
    MessageResponse createUser(UserRequest user);

}
