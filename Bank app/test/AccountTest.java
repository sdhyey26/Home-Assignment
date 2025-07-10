package com.tss.model.inhertitance.test;

import java.util.Scanner;

import com.tss.model.inheritance.exceptions.MinimumBalanceException;
import com.tss.model.inhertitance.model.CurrentAccountModel;
import com.tss.model.inhertitance.model.SavingsAccountModel;

public class AccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		CurrentAccountModel current = new CurrentAccountModel();
		SavingsAccountModel savings = new SavingsAccountModel();
		
		System.out.println("Select which account you want to create !!");
		System.out.println("1.savings");
		System.out.println("2.current");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1 : {
			System.out.println("Enter Name : ");
			String name = sc.next();
			savings.setName(name);
			System.out.println("Set Acc no : ");
			int accNo = sc.nextInt();
			savings.setAccno(accNo);
			System.out.println("enter minimum balance : ");
			int minBalance = sc.nextInt();
			savings.setMinBalance(minBalance);
		}break;
		
		case 2 :{
			System.out.println("Enter Name : ");
			String name = sc.next();
			current.setName(name);
			System.out.println("Set Acc no : ");
			int accNo = sc.nextInt();
			current.setAccno(accNo);
			System.out.println("enter amount : ");
			int amount = sc.nextInt();
			current.enterAmount(amount);
			System.out.println("enter overdraft limit : ");
			int overDraftLimit = sc.nextInt();
			current.setOverDraftLimit(overDraftLimit);
		}break;
		
		}
		
		System.out.println("1.display");
		System.out.println("2.credit");
		System.out.println("3.debit");
		System.out.println("4.Exit");
		
		boolean isTrue = true;
		while(isTrue) {
			System.out.println("enter your choice : ");
			int choiceAgain = sc.nextInt();
			switch(choiceAgain) {
			case 1 : 
				if(choice == 1) {
					savings.display();
				}
				if(choice == 2) {
					current.display();
				}break;
				
			case 2 : 
				if(choice == 1) {
					System.out.println("enter amount : ");
					int amount = sc.nextInt();
					savings.credit(amount);
				}
				if(choice == 2) {
					System.out.println("enter amount : ");
					int amount = sc.nextInt();
					current.credit(amount);
				}break;
				
			case 3 :
				try {
					
				
				if(choice == 1) {
					System.out.println("enter amount : ");
					int amount = sc.nextInt();
					savings.debit(amount);
				}
				if(choice == 2) {
					System.out.println("enter amount : ");
					int amount = sc.nextInt();
					current.debit(amount);
				}
				}
				catch(MinimumBalanceException exception) {
					System.out.println(exception);
				}
				break;
				
			case 4 :{
				isTrue = false;
			}
				
			}
		}
	}

}
