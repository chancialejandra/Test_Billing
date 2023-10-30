package com.test.technique.Billing.dto.Response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.test.technique.Billing.models.Bill;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserAndBillResponse {

    public String message;
    public String userName;
    public Long IdBill;
    public double totalAmount;
    public String des;

}
