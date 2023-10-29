package com.test.technique.Billing.services.interfaces;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;
import com.test.technique.Billing.models.User;

import java.util.List;

public interface IBillService {

    MessageResponse createBill(BillRequest billRequest);
    boolean editBill();
    boolean deleteBill();
}
