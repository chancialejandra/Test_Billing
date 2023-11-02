package com.test.technique.Billing.services;

import com.test.technique.Billing.dto.Request.UserRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;
import com.test.technique.Billing.dto.Response.UserResponse;
import com.test.technique.Billing.mapper.BillsMapper;
import com.test.technique.Billing.models.BillModel;
import com.test.technique.Billing.models.UserModel;
import com.test.technique.Billing.repositorys.IBillRepository;
import com.test.technique.Billing.repositorys.IUserRepository;
import com.test.technique.Billing.services.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final IUserRepository iUserRepository;
    private final IBillRepository iBillRepository;

    private ModelMapper mapper = new ModelMapper();

    public UserService(IUserRepository iUserRepository, IBillRepository iBillRepository) {
        this.iUserRepository = iUserRepository;

        this.iBillRepository = iBillRepository;
    }

    @Override
    public boolean existUser(String dni) {
        if(iUserRepository.findUserByDni(dni).isPresent()){
            return true;
        }
        return false;
        }

    @Override
    public Optional<UserModel> searchUserByDni(String dni) {
        return iUserRepository.findUserByDni(dni);
    }

    @Override
    public UserResponse getUser(String dni) {
        var userModel = iUserRepository.findUserByDni(dni);

        if (userModel.isEmpty()) {
            return null;
        }

        return mapper.map(userModel.get(), UserResponse.class);
    }

    @Override
    public MessageResponse createUser(UserRequest userRequest) {
        UserModel userModel = mapper.map(userRequest, UserModel.class);
        MessageResponse responseMessage;

        try {
            if(!existUser(userRequest.getDni())){
                iUserRepository.save(userModel);
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
    public UserResponse findAllByDni(String dni) {
        UserResponse response;

        try {
            if (!existUser(dni)){
                return UserResponse.builder()
                      //  .message("User does not exist")
                        .build();
            } else {
                Optional<UserModel> user= iUserRepository.findUserByDni(dni);
                List<BillModel> userBillModels = iBillRepository.findAllByUser(user.get());

                var  bills = BillsMapper.mapBills(userBillModels, user);
                return UserResponse.builder()
                       // .message("Bills")
                       // .userName(bills.userName)
                        .bills(bills.bills)
                        .build();
            }
        } catch (Exception ex) {
            response = UserResponse.builder()
                   // .message("invoice error")
                    .build();

        }
        return  response ;
    }

}
