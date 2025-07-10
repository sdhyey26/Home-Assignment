package com.tss.model.inhertitance.model;

import com.tss.model.inheritance.exceptions.NegativeBalanceException;

public abstract class AccountModel {
	
	private String name;
	private int balance;
	private int accno;
	
	public abstract void credit(int amount);
	public abstract void debit(int amount);

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
	
		this.balance = balance;
	}
	
	void AccountModel() {
		balance = 500;
	}
}
