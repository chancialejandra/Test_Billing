package com.test.technique.Billing.repositorys;

import com.test.technique.Billing.dto.Response.UserAndBillResponse;
import com.test.technique.Billing.models.Bill;
import com.test.technique.Billing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    Optional<User> findByDni(String dni);
    User searchUserByDni(String dni);

    Bill findAllByDni(String dni);
}

