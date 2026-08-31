package com.personal_finance_api.database.repository;

import com.personal_finance_api.database.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepository extends JpaRepository<TransactionEntity, Integer> {
}
