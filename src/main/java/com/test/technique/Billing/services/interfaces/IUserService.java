package com.test.technique.Billing.services.interfaces;

import com.test.technique.Billing.dto.Request.UserRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;
import com.test.technique.Billing.dto.Response.UserAndBillResponse;
import com.test.technique.Billing.models.Bill;
import com.test.technique.Billing.models.User;

import java.util.Optional;


public interface IUserService {

    boolean existUser(String dni);
    Optional<User>  searchUserByDni(String dni);
    UserAndBillResponse findAllByDni(String dni);
    MessageResponse createUser(UserRequest user);

}
