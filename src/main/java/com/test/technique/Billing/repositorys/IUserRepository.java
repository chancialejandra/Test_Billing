package com.test.technique.Billing.repositorys;

import com.test.technique.Billing.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserModel,Long> {

    Optional<UserModel> findUserByDni(String dni);

}

