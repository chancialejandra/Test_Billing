package com.test.technique.Billing.controllers;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.dto.Request.UserRequest;
import com.test.technique.Billing.dto.Response.UserResponse;
import com.test.technique.Billing.services.interfaces.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("billing/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequest user){
        var response = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<?> getUser(@PathVariable String dni){
        UserResponse userResponse = userService.getUser(dni);

        if (Objects.isNull(userResponse.dni)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }

    @PatchMapping("/{dni}/bill/{billId}")
    public ResponseEntity<?> editBillByUser(@PathVariable String dni,
                                          @PathVariable Long billId,
                                          @RequestBody BillRequest bill) {
        var response = userService.editBillByUser(dni, billId, bill);

        return ResponseEntity.status(response.status).body(response.message);
    }

    @DeleteMapping("/{dni}/bill/{billId}")
    public ResponseEntity<?> deleteBillByUser(@PathVariable String dni,
                                            @PathVariable Long billId)
    {
        var response = userService.deleteBillByUser(dni, billId);
        return ResponseEntity.status(response.status).body(response.message);
    }

}
