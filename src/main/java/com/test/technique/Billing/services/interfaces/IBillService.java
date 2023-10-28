package com.test.technique.Billing.services.interfaces;

import com.test.technique.Billing.models.User;

import java.util.List;

public interface IBillService {

    public boolean createBill();
    public boolean editUser();
    public User findUser();
    public List<User> findAll();
    public boolean deleteUser();
}
