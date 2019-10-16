package app;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Bank {
	// Variable for logging/not logging
	private static final boolean LOG = true;

	private static int accountCounter = 1;
	private String name;
	private ArrayList<Account> accounts;

	public Bank() {
		this("Bank Name");
	}

	public Bank(String name) {
		this.name = name;
		accounts = new ArrayList<>();
		log("Bank Created");
	}

	public int createAccount(String name) {
		Account newAccount = new Account(name);
		accounts.add(newAccount);

		log("Added account " + newAccount);
		return newAccount.accountNumber;
	}

	public boolean closeAccount(int accountNumber) {
		Account account = findAccount(accountNumber);
		if (account == null) {
			log("Could not close account " + accountNumber);
			return false;
		}
		accounts.remove(account);
		log("Successfully closed " + account);
		return true;
	}

	public boolean deposit(int accountNumber, int amount) {
		Account account = findAccount(accountNumber);
		if (account == null) {
			log("Could not deposit to account " + accountNumber);
			return false;
		}
		account.balance += amount;
		log("Successfully deposited $" + amount + " to " + account);
		return true;
	}

	public boolean withdraw(int accountNumber, int amount) {
		Account account = findAccount(accountNumber);
		if (account == null) {
			log("Could not withdraw from account " + accountNumber);
			return false;
		}
		if (account.balance < amount) {
			log("Insufficient funds in " + account);
			return false;
		}
		account.balance -= amount;
		log("Successfully withdrew $" + amount + " from " + account);
		return true;
	}

	public int checkBalance(int accountNumber) {
		Account account = findAccount(accountNumber);
		if (account == null) {
			log("Could not check balance of account " + accountNumber);
			return -1;
		}
		log("Successfully checked balance of account " + account);
		return account.balance;
	}

	public void transfer(int fromAccount, int toAccount, int amount) {
		Account from = findAccount(fromAccount);
		Account to = findAccount(toAccount);
		if(from.balance >= amount)
		{
			from.balance -= amount;
			to.balance += amount;
			log("Successfully transfered $" + amount + " from " + from + " to " + to);
		}
		else if(to == from)
		{
			System.out.println("Can't transfer money to your own account");
		}
		else
		{
			log("Insufficient funds in " + from);
		}
	}
	
	public void saveAccounts(String filename) {
		try {
			FileWriter fw = new FileWriter(filename);
			
			for(Account a: accounts)
			{
				fw.append(a.toString());
			}
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log("Accounts are Saved");
	}

	public void loadAccounts(String filename) {
		
		try {
			Scanner fileInput = new Scanner(new File(filename));
			
			while(fileInput.hasNextLine())
			{
				String line = fileInput.nextLine();
				String[] lineInfo = line.split("::");
				
				int accountNum = Integer.parseInt(lineInfo[0].substring(1, lineInfo[0].length()-1));
				String accName = lineInfo[1];
				int balance = Integer.parseInt(lineInfo[2].substring(0,lineInfo[2].length()-1));
				
				account a = new account(accountNum, accName, balance);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log("Load not yet implemented.");
	}

	private Account findAccount(int accountNumber) {
		for (int i = accounts.size() - 1; i >= 0; i--) {
			if (accounts.get(i).accountNumber == accountNumber)
				return accounts.get(i);
		}
		return null;
	}

	private void log(String message) {
		if (LOG)
			System.out.println(name + " ::: " + message + ".");
	}

	/**
	 * Private Inner Class Account
	 * Deals with Account information
	 */
	private class Account {
		int accountNumber;
		String name;
		int balance;

		private Account(String name) {
			this.name = name;
			balance = 0;
			accountNumber = accountCounter++;
		}

		public String toString() {
			return "{" + accountNumber + "::" + name + "::$" + balance + "}";
		}

	}
}
