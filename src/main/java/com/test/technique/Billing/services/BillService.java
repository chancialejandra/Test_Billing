package com.test.technique.Billing.services;

import com.test.technique.Billing.models.User;
import com.test.technique.Billing.services.interfaces.IBillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService implements IBillService {


    @Override
    public boolean createBill() {
        return false;
    }

    @Override
    public boolean editUser() {
        return false;
    }

    @Override
    public User findUser() {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean deleteUser() {
        return false;
    }
}
