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
		int ewbankAccountNo = bank.createAccount("Mr. Ewbank");
		int howardAccountNo = bank.createAccount("Mr. Howard");
		
		bank.deposit(ewbankAccountNo, 25);
		bank.deposit(howardAccountNo, 75);

		bank.checkBalance(ewbankAccountNo);
		bank.checkBalance(howardAccountNo);
		
		bank.withdraw(ewbankAccountNo, 10);
		bank.closeAccount(howardAccountNo);
		
		bank.checkBalance(ewbankAccountNo);
		bank.checkBalance(howardAccountNo);
		
	}
	public static void menu()
	{
		while(true)
		{
			System.out.println("Hello, do you already have an account? (yes/no)");
			Scanner input = new Scanner(System.in);
			int accountNumber = 0;
			if(input.nextLine() == "yes")
			{
				System.out.println("What is your account number?");
				Scanner input2 = new Scanner(System.in);
				accountNumber = input2.nextInt();
			}
			else if(input.nextLine() == "no")
			{
				System.out.println("Would you like to make an account?");
				Scanner input3 = new Scanner(System.in);
			}
			else
			{
				System.out.println("Whaaaat????")
			}
		}
	}
}
