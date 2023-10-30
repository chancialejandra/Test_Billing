package com.test.technique.Billing.controllers;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.services.interfaces.IBillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("billing/bill")
public class BillController {

    private final IBillService billService;

    public BillController(IBillService billService) {
        this.billService = billService;
    }

    @PostMapping
    public ResponseEntity<?> createBill(@RequestBody BillRequest bill){
        var response = billService.createBill(bill);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
