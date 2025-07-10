package com.tss.model.inheritance.exceptions;

public class NegativeBalanceException extends RuntimeException {
	int balance ;
	
	public NegativeBalanceException(int balance2) {
		this.balance = balance2;
	}


	public String getMessage()
	{
		return "you entered invalid balance : " + balance;
	}
}
