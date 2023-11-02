package com.test.technique.Billing.services;

import com.test.technique.Billing.dto.Request.BillRequest;
import com.test.technique.Billing.dto.Request.UserRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;
import com.test.technique.Billing.dto.Response.UserResponse;
import com.test.technique.Billing.models.BillModel;
import com.test.technique.Billing.models.UserModel;
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

    private ModelMapper mapper = new ModelMapper();

    public UserService(IUserRepository iUserRepository, IBillRepository iBillRepository) {
        this.iUserRepository = iUserRepository;

        this.iBillRepository = iBillRepository;
    }

    @Override
    public MessageResponse createUser(UserRequest userRequest) {
        UserModel userModel = mapper.map(userRequest, UserModel.class);
        MessageResponse responseMessage = MessageResponse.builder().build();

        try {
            if(iUserRepository.findUserByDni(userModel.getDni()).isPresent()){
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
                    .message("error saving in database")
                    .status(HttpStatus.OK)
                    .build();
        }
        return responseMessage;
    }

    @Override
    public MessageResponse editBillByUser(String dni, Long billId, BillRequest billRequest) {
        MessageResponse responseMessage = MessageResponse.builder().build();

        try{
            if (iUserRepository.findUserByDni(dni).isPresent()){
                var billValidation = iBillRepository.findById(billId);
                if (billValidation.isPresent()) {
                    BillModel oldBill = billValidation.get();

                    oldBill.setTotalAmount(billRequest.getTotalAmount());
                    oldBill.setDesc(billRequest.getDesc());
                    iBillRepository.save(oldBill);
                    return MessageResponse.builder()
                            .message("Bill Updated successfully")
                            .status(HttpStatus.OK)
                            .build();
                }else{
                    return MessageResponse.builder()
                            .message("Bill doesn't exist")
                            .status(HttpStatus.BAD_REQUEST)
                            .build();
                }
            }
            return MessageResponse.builder()
                    .message("User doesn't exist")
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }catch(Exception ex){
            MessageResponse.builder()
                    .message("error saving in database")
                    .status(HttpStatus.OK)
                    .build();
        }
        return responseMessage;
    }

    @Override
    public MessageResponse deleteBill(String dni, Long billId) {
        var userModel = iUserRepository.findUserByDni(dni);
        MessageResponse messageResponse = MessageResponse.builder().build();

            if (userModel.isPresent()) {
                var billValidation = iBillRepository.findById(billId);

                if (billValidation.isPresent()) {
                    BillModel oldBill = billValidation.get();
                    iBillRepository.delete(oldBill);
                    return MessageResponse.builder()
                            .message("Bill Deleted successfully")
                            .status(HttpStatus.OK)
                            .build();
                }
                return MessageResponse.builder()
                        .message("Bill doesn't exist")
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }


        return MessageResponse.builder()
                .message("User doesn't exist")
                .status(HttpStatus.BAD_REQUEST)
                .build();
    }

    @Override
    public Optional<UserModel> searchUserByDni(String dni) {
        return iUserRepository.findUserByDni(dni);
    }


    @Override
    public UserResponse getUser(String dni) {
        UserResponse responseUser = UserResponse.builder().build();
        var userModel = iUserRepository.findUserByDni(dni);

        if (iUserRepository.findUserByDni(dni).isEmpty()) {
            return responseUser;
        }
        return mapper.map(userModel.get(), UserResponse.class);
    }


}
