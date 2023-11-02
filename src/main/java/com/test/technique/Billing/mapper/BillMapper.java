package com.test.technique.Billing.mapper;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.models.BillModel;
import com.test.technique.Billing.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class BillMapper {

    public static BillModel mapBill(BillRequest billRequest, UserModel user){
        BillModel billMapper = new BillModel();
        billMapper.setTotalAmount(billRequest.getTotalAmount());
        billMapper.setDesc(billRequest.getDesc());
        billMapper.setUser(user);
        return billMapper;
    }
}
