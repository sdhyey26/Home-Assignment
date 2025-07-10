package com.tss.model.inhertitance.model;

import com.tss.model.inheritance.exceptions.NegativeBalanceException;
import com.tss.model.inheritance.exceptions.OverDraftLimitReachedException;

public class CurrentAccountModel extends AccountModel {

	private int overDraftLimit;
	
	public void enterAmount(int amount) {
		if(amount < 0) {
			throw new NegativeBalanceException(amount);

		}
		setBalance(amount);
	}
	
	public int getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(int overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}
	
	public void display() {
		System.out.println("Name : " + getName());
		System.out.println("Balance : " + getBalance());
		System.out.println("Account Number : " + getAccno());
		System.out.println("OverDraft Limit : " + getOverDraftLimit());
	}

	@Override
	public void credit(int amount) {
		setBalance(getBalance() + amount);
		System.out.println("Balance creditted successfully !!");
		System.out.println("updated successfully : " + getBalance());
		
	}

	@Override
	public void debit(int amount) {
		if (amount >= getOverDraftLimit()) {
			throw new OverDraftLimitReachedException(getOverDraftLimit());

		} else {
			setBalance(getBalance() - amount);
			System.out.println("Balance debitted successfully !!");
			System.out.println("updated successfully : " + getBalance());
		}
		
	}
}
