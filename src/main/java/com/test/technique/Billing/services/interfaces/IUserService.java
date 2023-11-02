package com.test.technique.Billing.services.interfaces;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.dto.Request.UserRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;
import com.test.technique.Billing.dto.Response.UserResponse;
import com.test.technique.Billing.models.UserModel;

import java.util.Optional;


public interface IUserService {

    MessageResponse createUser(UserRequest user);
    MessageResponse editBillByUser(String dni, Long billId, BillRequest billRequest);
    MessageResponse deleteBill(String dni, Long billId);
    Optional<UserModel>  searchUserByDni(String dni);
    UserResponse getUser(String dni);


}
