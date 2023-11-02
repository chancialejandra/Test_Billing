package com.test.technique.Billing.repositorys;

import com.test.technique.Billing.models.BillModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBillRepository extends JpaRepository<BillModel, Long> { }
