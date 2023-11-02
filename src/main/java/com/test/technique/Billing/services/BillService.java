package com.test.technique.Billing.services;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;
import com.test.technique.Billing.mapper.BillMapper;
import com.test.technique.Billing.models.BillModel;
import com.test.technique.Billing.repositorys.IBillRepository;
import com.test.technique.Billing.services.interfaces.IBillService;
import com.test.technique.Billing.services.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class BillService implements IBillService {

    private final IUserService userService;
    private final IBillRepository iBillRepository;

    public BillService(IUserService userService, IBillRepository iBillRepository) {
        this.userService = userService;
        this.iBillRepository = iBillRepository;
    }

    @Override
    public MessageResponse createBill(BillRequest billRequest) {
        MessageResponse responseMessage = MessageResponse.builder().build();

        try {
            if(userService.searchUserByDni(billRequest.getUserDni()).isEmpty()){
                return MessageResponse.builder()
                        .message("User does not exist")
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }else{
                var UserBill = userService.searchUserByDni(billRequest.getUserDni());
                BillModel billModel = BillMapper.mapBill(billRequest, UserBill.get());
                iBillRepository.save(billModel);
                return MessageResponse.builder()
                        .message("Bill created successfully")
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

}
