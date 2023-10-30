package com.test.technique.Billing.mapper;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.models.Bill;
import com.test.technique.Billing.models.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BillsMapper {
    public static Bill mapBills(Bill bill, Optional<User> user){

        Bill billsMapper = new Bill();
        billsMapper.setUser(user.get());
        billsMapper.setIdBill(bill.getIdBill());
        billsMapper.setTotalAmount(bill.getTotalAmount());
        billsMapper.setDes(bill.getDes());
        return billsMapper;
    }
}
