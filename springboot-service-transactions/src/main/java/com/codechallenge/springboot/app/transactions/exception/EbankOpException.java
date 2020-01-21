package com.codechallenge.springboot.app.transactions.exception;

@SuppressWarnings("serial")
public class EbankOpException extends Exception{
	public EbankOpException() {}
	
	public EbankOpException(String msg, Throwable e) {
		super(msg, e);
	}

}
