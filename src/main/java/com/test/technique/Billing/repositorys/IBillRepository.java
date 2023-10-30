package com.test.technique.Billing.repositorys;

import com.test.technique.Billing.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Long> {

    Bill findBillByUser(String dni);
}
