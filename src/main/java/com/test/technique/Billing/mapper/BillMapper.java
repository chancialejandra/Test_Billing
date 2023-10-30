package com.test.technique.Billing.mapper;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.models.Bill;
import com.test.technique.Billing.models.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BillMapper {

    public static Bill mapBill(BillRequest billRequest, Optional<User> user){
        Bill billMapper = new Bill();
        billMapper.setTotalAmount(billRequest.getTotalAmount());
        billMapper.setDes(billRequest.getDes());
       // billMapper.setUser(user);
        return billMapper;
    }
}
