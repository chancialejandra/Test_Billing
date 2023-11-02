package com.test.technique.Billing.services.interfaces;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;

public interface IBillService {

    MessageResponse createBill(BillRequest billRequest);

}
