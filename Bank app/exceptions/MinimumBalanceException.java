package com.tss.model.inheritance.exceptions;

public class MinimumBalanceException extends RuntimeException{
	int minBalance ;
	
	public MinimumBalanceException(int minBalance) {
		this.minBalance = minBalance;
	}
	
	public String getMessage()
	{
		return "Your minimum balance is : " + minBalance;
	}
}
