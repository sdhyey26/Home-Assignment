package com.tss.model.inhertitance.model;

import com.tss.model.inheritance.exceptions.*;

public class SavingsAccountModel extends AccountModel {
	private int minBalance  ;
	
	void SavingsAccountModel() {
		setBalance(minBalance);	
	}
	
	public int getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(int minBalance) {
		if(minBalance < 0)
			throw new NegativeBalanceException(minBalance);
		this.minBalance = minBalance;
	}
	
	public void display() {
		System.out.println("Name : " + getName());
		System.out.println("Balance : " + getBalance());
		System.out.println("Account Number : " + getAccno());
	}

	@Override
	public void debit(int amount) {
		if(amount <= minBalance) {
			setBalance(minBalance - amount);
			System.out.println("amount debited successfully!!");
			System.out.println("Balance left : " + getBalance());
		}
		else {
			throw new MinimumBalanceException(getMinBalance());
		}
	}
	
	@Override
	public void credit(int amount) {
		setBalance(getBalance() + amount);
		System.out.println("Balance credit successfully !!");
		System.out.println("updated successfully : " + getBalance());
	}
}
