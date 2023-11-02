package com.test.technique.Billing.dto.Request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BillRequest {
    @NotNull(message = "El precio no puede estar vacío.")
    @DecimalMin(value = "0.0", message="El Total no puede ser menor a 0")
    @DecimalMax(value = "10000000", message="El precio de la factura no puede superar los 10.000.000")
    private double totalAmount;

    @NotBlank(message = "La Descripción no puede estar vacía")
    private String desc;
    @NotBlank(message = "El Dni del usuario no puede estar vacio")
    private String userDni;
}
