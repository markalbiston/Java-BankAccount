package com.codingdojo.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account01 = new BankAccount();
		BankAccount account02 = new BankAccount();
		System.out.println(BankAccount.getNumberOfAccounts());
		System.out.println(account01.accountNumber);
		System.out.println(account02.accountNumber);
		account01.deposit("checking", 200);
		account01.deposit("savings", 1200);
		account01.withdrawal("checking", 40);
		System.out.println(account01.seeTotalCheckingAndSavings());
		System.out.println(BankAccount.getTotal());
	}

}
