package com.codechallenge.springboot.app.transactions.models.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codechallenge.springboot.app.transactions.models.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
