package com.test.technique.Billing.repositorys;

import com.test.technique.Billing.models.Bill;
import com.test.technique.Billing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Long> {

    List<Bill> findAllByUser(User user);
    Bill findBillByUser(User user);
}
