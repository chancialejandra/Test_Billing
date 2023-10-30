package com.test.technique.Billing.services;

import com.test.technique.Billing.dto.Request.UserRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;
import com.test.technique.Billing.dto.Response.UserAndBillResponse;
import com.test.technique.Billing.mapper.BillsMapper;
import com.test.technique.Billing.models.Bill;
import com.test.technique.Billing.models.User;
import com.test.technique.Billing.repositorys.IBillRepository;
import com.test.technique.Billing.repositorys.IUserRepository;
import com.test.technique.Billing.services.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final IUserRepository iUserRepository;
    private final IBillRepository iBillRepository;

    ModelMapper mapper = new ModelMapper();

    public UserService(IUserRepository iUserRepository, IBillRepository iBillRepository) {
        this.iUserRepository = iUserRepository;

        this.iBillRepository = iBillRepository;
    }

    @Override
    public boolean existUser(String dni) {
        if(iUserRepository.findByDni(dni).isPresent()){
            return true;
        }
        return false;
        }

    @Override
    public User searchUserByDni(String dni) {
        return iUserRepository.searchUserByDni(dni);
    }

    @Override
    public MessageResponse createUser(UserRequest userRequest) {
        User user = mapper.map(userRequest,User.class);
        MessageResponse responseMessage;

        try {
            if(!existUser(userRequest.getDni())){
                iUserRepository.save(user);
                responseMessage = MessageResponse.builder()
                        .message("Successful registration")
                        .status(HttpStatus.OK)
                        .build();
                return responseMessage;
            }else{
                return MessageResponse.builder()
                        .message("User already exists")
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }
        }catch(Exception ex){
            responseMessage = MessageResponse.builder()
                    .message("Error creating user")
                    .status(HttpStatus.OK)
                    .build();
        }
        return responseMessage;
    }

    @Override
    public UserAndBillResponse findAllByDni(String dni) {
        UserAndBillResponse response;

        try {
            if (!existUser(dni)){
                return UserAndBillResponse.builder()
                        .message("User does not exist")
                        .build();
            } else {
                Optional<User> user= iUserRepository.findByDni(dni);
                Bill UserBills = iBillRepository.searchBillByUser(user.get());

                var  bills = BillsMapper.mapBills(UserBills, user);
                return UserAndBillResponse.builder()
                        .message("Bills")
                        .userName(bills.getUser().getName())
                        .IdBill(bills.getIdBill())
                        .totalAmount(bills.getTotalAmount())
                        .des(bills.getDes())
                        .build();
            }
        } catch (Exception ex) {
            response =UserAndBillResponse.builder()
                    .message("invoice error")
                    .build();

        }
        return  response ;
    }

}
