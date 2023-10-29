package com.test.technique.Billing.services;

import com.test.technique.Billing.dto.Request.UserRequest;
import com.test.technique.Billing.dto.Response.MessageResponse;
import com.test.technique.Billing.models.User;
import com.test.technique.Billing.repositorys.IUserRepository;
import com.test.technique.Billing.services.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService {

    private final IUserRepository iUserRepository;
    ModelMapper mapper = new ModelMapper();

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public boolean findByDni(String dni) {
        if(iUserRepository.findByDni(dni).isPresent()){
            return true;
        }
        return false;
        }

    @Override
    public MessageResponse createUser(UserRequest userRequest) {
        User user = mapper.map(userRequest,User.class);
        MessageResponse responseMessage;

        try {
            if(!findByDni(userRequest.getDni())){
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
    public boolean editUser() {
        return false;
    }

    @Override
    public User findUser() {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean deleteUser(Long idUser) {
        return false;
    }
}
