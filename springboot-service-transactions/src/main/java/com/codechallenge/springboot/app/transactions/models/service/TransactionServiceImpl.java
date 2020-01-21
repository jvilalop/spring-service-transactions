package com.codechallenge.springboot.app.transactions.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codechallenge.springboot.app.transactions.models.dao.TransactionDao;
import com.codechallenge.springboot.app.transactions.models.entity.Transaction;

@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private TransactionDao transactionDao;

	@Transactional(readOnly = true)
	public List<Transaction> findAll() {

		return (List<Transaction>)transactionDao.findAll();

	}

	@Transactional(readOnly = true)
	public Transaction findById(Long id) {
		return transactionDao.findById(id).orElse(null);
	}


    @Override
    public List<Transaction> findAllOrderByAmmountAsc() {
        return transactionDao.findAllOrderByAmmountAsc();
    }
    
    @Override
    public List<Transaction> findAllOrderByAmmountDesc() {
        return transactionDao.findAllOrderByAmmountDesc();
    }
    
    @Override
    public Transaction findByAccount(String account) {
        return transactionDao.findByAccount(account);
    }

//    @Override
//    public List<City> findAllOrderByNameAsc() {
//
//        var sort = new Sort(Sort.Direction.ASC, "name");
//        return repository.findAllOrderByNameAsc(sort);
//    }

}