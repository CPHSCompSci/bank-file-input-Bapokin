package app;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) 
	{
		example1();
		
	}
	
	public static void example1()
	{
		Bank bank = new Bank("Bank of CPHS");
		menu(bank);
//		int ewbankAccountNo = bank.createAccount("Mr. Ewbank");
//		int howardAccountNo = bank.createAccount("Mr. Howard");
//		
//		bank.deposit(ewbankAccountNo, 25);
//		bank.deposit(howardAccountNo, 75);
//
//		bank.checkBalance(ewbankAccountNo);
//		bank.checkBalance(howardAccountNo);
//		
//		bank.withdraw(ewbankAccountNo, 10);
//		bank.closeAccount(howardAccountNo);
//		
//		bank.checkBalance(ewbankAccountNo);
//		bank.checkBalance(howardAccountNo);
		
	}
	public static void menu(Bank bank)
	{
		boolean bankRunning = true;
		bank.loadAccounts("AccountData");
		while(bankRunning)
		{
			System.out.println("Hello, do you already have an account? (yes/no)");	
			Scanner input = new Scanner(System.in);
			String respond = input.nextLine();
			int accountNumber = 0;
			if(respond.equals("yes"))
			{
				System.out.println("What is your account number?");
				Scanner input2 = new Scanner(System.in);
				accountNumber = input2.nextInt();
				boolean userActive = true;
				while(userActive)
				{
				System.out.println("What would you like to do? (deposit (1), withdraw (2), close account (3), check balance (4), transfer(5), leave (6))");
				Scanner input3 = new Scanner(System.in);
				String respond2 = input3.nextLine();
				if(respond2.equals("1"))
				{
					System.out.println("Ok, how much would you like to deposit?");
					Scanner depositAmount = new Scanner(System.in);
					int amount = depositAmount.nextInt();
					bank.deposit(accountNumber, amount);
				}
				else if(respond2.equals("2"))
				{
					System.out.println("Ok, how much would you like to withdraw?");
					Scanner withdrawAmount = new Scanner(System.in);
					int amount = withdrawAmount.nextInt();
					bank.withdraw(accountNumber, amount);
				}
				else if(respond2.equals("3"))
				{
					System.out.println("Are you sure you want to close your account? (yes/no)");
					Scanner closeAccount = new Scanner(System.in);
					String close = closeAccount.nextLine();
					if(close.equals("yes"))
					{
						bank.closeAccount(accountNumber);
					}
				}
				else if(respond2.equals("4"))
				{
					bank.checkBalance(accountNumber);
				}
				else if(respond2.equals("5"))
				{
					System.out.println("What is the account number that you want to transfer the money to?");
					Scanner accNum = new Scanner(System.in);
					int toAccount = accNum.nextInt();
					System.out.println("How much money would you like to transfer?");
					Scanner ammount2 = new Scanner(System.in);
					int amount = ammount2.nextInt();
					bank.transfer(accountNumber, toAccount, amount);
				}
				else if(respond2.equals("6"))
				{
					System.out.println("Bye!");
					bank.saveAccounts("AccountData");
					userActive = false;
				}
			}
		}
			
			else if(respond.equals("no")) //account creation
			{
				System.out.println("Would you like to make an account? (yes/no)");
				Scanner input3 = new Scanner(System.in);
				if(input3.nextLine().equals("yes"))
				{
					System.out.println("What would you like to name your account?");
					Scanner input4 = new Scanner(System.in);
					bank.createAccount(input4.nextLine());
					bank.saveAccounts("AccountData");
				}
				else
				{
					System.out.println("Ok, Bye");
				}
			}
			else
			{
				System.out.println("Whaaaat????");
			}
		}
	}
}
