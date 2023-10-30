package com.test.technique.Billing.mapper;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.dto.Response.UserAndBillResponse;
import com.test.technique.Billing.models.Bill;
import com.test.technique.Billing.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BillsMapper {
    public static UserAndBillResponse mapBills(List<Bill> bill, User user){
        List<Bill> listBills = getListBills(bill);
         return UserAndBillResponse.builder()
                .userName(user.getName())
                .bills(listBills)
                .build();
    }

    public static List<Bill> getListBills(List<Bill> bills){
        List<Bill> listBill = new ArrayList<>();

        bills.stream().forEach(x ->{
                Bill bill = new Bill();
                bill.setIdBill(bill.getIdBill());
                bill.setTotalAmount(bill.getTotalAmount());
                bill.setDes(bill.getDes());
        });
        return listBill;
    }
}
