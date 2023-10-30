package com.test.technique.Billing.services.interfaces;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;
import com.test.technique.Billing.dto.Response.UserAndBillResponse;
import com.test.technique.Billing.models.Bill;

public interface IBillService {

    MessageResponse createBill(BillRequest billRequest);
    Bill findAllByUser(Long idUser);
    boolean editBill();
    boolean deleteBill();
}
