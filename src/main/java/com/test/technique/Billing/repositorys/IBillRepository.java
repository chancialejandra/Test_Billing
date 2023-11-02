package com.test.technique.Billing.repositorys;

import com.test.technique.Billing.models.BillModel;
import com.test.technique.Billing.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBillRepository extends JpaRepository<BillModel, Long> {

    List<BillModel> findAllByUser(UserModel userModel);
    BillModel findBillByUser(UserModel userModel);
}
