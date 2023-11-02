package com.test.technique.Billing.dto.Request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRequest {
    @NotBlank(message = "La identificación no puede estar vacía")
    @Size(min= 6, max = 12, message = "La identificación debe de tener entre 6 y 12 Caracteres")
    private String dni;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;
    @Min(value=1, message = "Debe ser mayor a 1 año")
    @Max(value=200, message = "Debe ser menor a 200 años")
    private Integer age;
    private String email;

}
