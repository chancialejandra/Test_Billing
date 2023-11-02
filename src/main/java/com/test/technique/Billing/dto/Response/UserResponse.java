package com.test.technique.Billing.dto.Response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponse {

    public Long idUser;
    public String dni;
    public String name;
    public Integer age;
    public String email;
    public List<BillResponse> bills;


}
