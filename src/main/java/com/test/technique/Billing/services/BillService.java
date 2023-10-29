package com.test.technique.Billing.services;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;
import com.test.technique.Billing.mapper.BillMapper;
import com.test.technique.Billing.models.Bill;
import com.test.technique.Billing.models.User;
import com.test.technique.Billing.repositorys.IBillRepository;
import com.test.technique.Billing.services.interfaces.IBillService;
import com.test.technique.Billing.services.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService implements IBillService {

    ModelMapper mapper = new ModelMapper();
    private final IUserService userService;
    private final IBillRepository iBillRepository;

    public BillService(IUserService userService, IBillRepository iBillRepository) {
        this.userService = userService;
        this.iBillRepository = iBillRepository;
    }

    @Override
    public MessageResponse createBill(BillRequest billRequest) {
        Bill bill = mapper.map(billRequest,Bill.class);
        MessageResponse responseMessage;

        try {
            if(!userService.findByDni(billRequest.getUserDni())) {
                return MessageResponse.builder()
                        .message("User does not exist")
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }else{
                var UserBill = userService.searchUserByDni(billRequest.getUserDni());
                Bill bills = BillMapper.mapBill(billRequest,UserBill);
                iBillRepository.save(bills);
                return MessageResponse.builder()
                    .message("invoice created successfully")
                    .status(HttpStatus.OK)
                    .build();
            }
        }catch(Exception ex){
            responseMessage = MessageResponse.builder()
                    .message("Error creating bill")
                    .status(HttpStatus.OK)
                    .build();
        }
        return responseMessage;
    }

    @Override
    public boolean editBill() {
        return false;
    }

    @Override
    public boolean deleteBill() {
        return false;
    }


}
