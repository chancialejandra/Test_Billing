package com.test.technique.Billing.repositorys;

import com.test.technique.Billing.models.Bill;
import com.test.technique.Billing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Long> {

    Bill searchBillByUser(User user);
}
