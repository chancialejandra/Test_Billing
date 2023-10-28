package com.test.technique.Billing.repositorys;

import com.test.technique.Billing.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {
}
