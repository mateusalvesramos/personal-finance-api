package com.personal_finance_api.database.repository;

import com.personal_finance_api.database.model.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity, Integer> {
}
