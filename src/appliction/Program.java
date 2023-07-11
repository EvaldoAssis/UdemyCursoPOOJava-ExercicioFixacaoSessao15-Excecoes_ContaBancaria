package appliction;

import java.util.Locale;
import java.util.Scanner;
import model.entities.Account;
import model.exceptions.AccountException;

public class Program {

	public static void main(String[] args) {
		
		try {
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account acc = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			
			acc.withdraw(amount);
			System.out.println("New balance: " + acc.getBalance());
		}catch (AccountException e) {
			System.out.println("Withdrw error: " + e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
	}

}
