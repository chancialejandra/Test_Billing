package com.test.technique.Billing.services.interfaces;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;
import com.test.technique.Billing.dto.Response.UserAndBillResponse;

public interface IBillService {

    MessageResponse createBill(BillRequest billRequest);
    UserAndBillResponse findAllBillsByUser(String dni);
    boolean editBill();
    boolean deleteBill();
}
