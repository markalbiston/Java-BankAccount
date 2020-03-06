package com.codingdojo.bankaccount;
import java.util.Random;

public class BankAccount {
	protected String accountNumber;
	private double checkingBalance=0;
	private double savingsBalance=0;
	private static int numberOfAccounts = 0;
	private static double totalMoneyInAllAccounts = 0;
	
	public BankAccount() {
		this.accountNumber = randomAccountNumber();
		numberOfAccounts++;
	}
	
	private String randomAccountNumber() {
		String accountNumber="";
		int i = 10;
		while(i>0) {
			Random r = new Random();
			accountNumber += r.nextInt(10);
			i--;
		}
		return accountNumber;
	}
	
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
	public double getSavingsBalance() {
		return this.savingsBalance;
	}
	public BankAccount deposit(String accountType, double depositAmount) {
		if(accountType == "checking") {
			this.checkingBalance += depositAmount;
		}
		else if(accountType == "savings") {
			this.savingsBalance += depositAmount;
		}
		totalMoneyInAllAccounts += depositAmount;
		return this;
	}
	public double withdrawal(String accountType, double withdrawalAmount) {
		if(accountType == "checking" && this.checkingBalance >= withdrawalAmount) {
			this.checkingBalance -= withdrawalAmount;
			totalMoneyInAllAccounts -= withdrawalAmount;
			return withdrawalAmount;
		}
		else if(accountType == "savings" && this.savingsBalance >= withdrawalAmount) {
			this.savingsBalance -= withdrawalAmount;
			totalMoneyInAllAccounts -= withdrawalAmount;
			return withdrawalAmount;
		}
		else {
			System.out.println("insufficient funds");
			return 0;
		}
	}
	public String seeTotalCheckingAndSavings() {
		return ("Checking: $"+ this.checkingBalance +"  :  Savings: $"+this.savingsBalance);
	}
	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	public static double getTotal() {
		return totalMoneyInAllAccounts;
	}
}
