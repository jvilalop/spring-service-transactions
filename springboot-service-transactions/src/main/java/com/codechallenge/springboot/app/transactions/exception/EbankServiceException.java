package com.codechallenge.springboot.app.transactions.exception;

@SuppressWarnings("serial")
public class EbankServiceException extends EbankOpException{
	
	public EbankServiceException() {}
	
	public EbankServiceException(String msg, Throwable e) {
		super(msg, e);
	}


}
