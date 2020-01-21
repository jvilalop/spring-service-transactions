package com.codechallenge.springboot.app.transactions.exception;

public class EbankOpDaoException extends EbankOpException{
	public EbankOpDaoException() { }
	
	public EbankOpDaoException(String msg, Throwable e) {
		super(msg, e);
	}

}
