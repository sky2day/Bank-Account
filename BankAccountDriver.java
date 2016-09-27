package ccsf111b;

//import bankaccount.BankAccount; - don't have to import your own class
import java.util.Scanner;

public class BankAccountDriver {
	public static void main(String[] args) {

		String username;
		String userID;
		double userBalance;
		double userInterest;
		double amount; // amount to withdraw or deposit
		int choice; // variable to determine user action

		Scanner userInput = new Scanner(System.in);
		System.out.println("Welcome to the Bank Account!");

		System.out.println("What is your name?");
		do {
			username = userInput.nextLine();
			if (username.length() == 0) {
				System.out
						.println("You must have a name! Please enter your name.");
			}
		} while (username.length() == 0);

		System.out.println("What is your account ID?");
		do {
			userID = userInput.nextLine();
			if (userID.length() == 0) {
				System.out
						.println("You must have an ID! Please enter your ID.");
			}
		} while (userID.length() == 0);

		System.out.println("What is your initial deposit?");
		do {
			userBalance = userInput.nextDouble();
			//userBalance = Double.parseDouble(userInput.nextLine());
			if (userBalance == 0) {
				System.out
						.println("You must have a starting balance! Please enter your initial deposit.");
			} else if (userBalance < 0) {
				System.out
						.println("You cannot have a negative starting balance! Please enter a positive amount.");
			}
		} while (userBalance <= 0);

		System.out.println("How much interest would you like?");
		userInterest = userInput.nextDouble();

		BankAccount newUser = new BankAccount(username, userID, userBalance,
				userInterest);
		// newUser.setAccountInterest(userInterest);
		do {
			do {
				System.out.println("\nPlese select one of the following options: "
								+ "\nPress 1 to check balance."
								+ "\nPress 2 to deposit money."
								+ "\nPress 3 to withdraw money."
								+ "\nPress 4 to add interest."
								+ "\nPress 5 to exit program.");

				choice = userInput.nextInt();
				if (choice > 5 || choice <= 0) {
					System.out.print("Please enter a valid choice. ");
				}
			} while (choice > 5 || choice <= 0);

			switch (choice) {
			case 1:
				System.out.println("Your balance is: $"
						+ newUser.getAccountBalance());
				break;
			case 2:
				do{
				System.out.println("How much would you like to deposit?");
				amount = userInput.nextDouble();
				newUser.deposit(amount);}
				while (amount < 0);
				amount = 0;
				break;
			case 3:
				do{
				System.out.println("How much would you like to withdraw?");
				amount = userInput.nextDouble();
				newUser.withdraw(amount);}
				while(amount <0 || amount> newUser.getAccountBalance());
				
				amount = 0;
				break;
			case 4:
				newUser.addInterest();
				break;
			case 5:
				System.out.println("Thank you for using your bank account. Program will quit now.");
			default:
				break;
			}
		}

		while (choice != 5);
		System.out.println(newUser.toString());
	}
}