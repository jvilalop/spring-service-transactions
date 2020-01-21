package com.codechallenge.springboot.app.transactions.models.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.codechallenge.springboot.app.transactions.models.entity.Transaction;

public interface ITransactionService {
		public List<Transaction> findAll();
		public Transaction findById(Long id);
		List<Transaction> findAllOrderByAmmountAsc();
		List<Transaction> findAllOrderByAmmountDesc();
		public Transaction findByAccount(@Param("accountValue") String accountValue);
		//public ResponseEntity<List<Transaction>> search(Transaction user);
}