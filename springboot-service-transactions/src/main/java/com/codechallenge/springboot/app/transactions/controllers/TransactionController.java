package com.codechallenge.springboot.app.transactions.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codechallenge.springboot.app.transactions.models.data.TransactionRepository;
import com.codechallenge.springboot.app.transactions.models.entity.Transaction;
import com.codechallenge.springboot.app.transactions.models.service.ITransactionService;


@RestController
public class TransactionController {

//	@Autowired
//	private TransactionRepository transactionData;
//	
//	@RequestMapping(value = "/createNewTransaction.html", method = RequestMethod.POST)
//	public String newTransaction(Transaction transaction) {
//
//		transactionData.save(transaction);
//		return ("redirect:/listTransaction.html");
//
//	}
//
//	@RequestMapping(value = "/createNewTransaction.html", method = RequestMethod.GET)
//	public ModelAndView createNewTransaction() {
//
//		Transaction emp = new Transaction();
//		return new ModelAndView("newTransaction", "form", emp);
//
//	}
//	
//	@RequestMapping(value = "/listTransaction.html", method = RequestMethod.GET)
//	public ModelAndView transactions() {
//		List<Transaction> allTransactions = transactionData.findAll();
//		return new ModelAndView("allTransactions", "Transactions", allTransactions);
//
//	}
//	
	
	@Autowired
	private ITransactionService transactionService;
	

	@GetMapping("/listar")
    public List<Transaction> listar(){
    	return transactionService.findAll();
    }
	
	@GetMapping("/ver/{id}")
	public Transaction detalle(@PathVariable Long id) {
		return transactionService.findById(id);
	}
	
    @GetMapping(value = "/ammountasc")
    public List<Transaction> getTransactionByAmmountAsc() {

        return transactionService.findAllOrderByAmmountAsc();
    }
    
    @GetMapping(value = "/ammountdesc")
    public List<Transaction> getTransactionByAmmountDesc() {

        return transactionService.findAllOrderByAmmountDesc();
    }
    
    @GetMapping(value = "/filteraccount/{account}")
    public Transaction getFilterByAccount(@PathVariable String account) {

        return transactionService.findByAccount(account);
    }
	
//    @GetMapping
//    public List<Transaction> findAllByRsql(@RequestParam(value = "search") String search) {
//        Node rootNode = new RSQLParser().parse(search);
//        Specification<Transaction> spec = rootNode.accept(new CustomRsqlVisitor<Transaction>());
//        return transactionService.findAll(spec);
//    }
	
//	   @GetMapping(value = "/_search1")
//	    public ResponseEntity<List<Transaction>> search(@RequestParam(value = "account") String traAccount) { 
//
//		   Transaction user = new Transaction(){{
//	            setAccount("zhangsan");
//	        }};
//
//	        return transactionService.search(user);
//	    }

}
