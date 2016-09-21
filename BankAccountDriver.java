// BankAccountDriver:
// Prompts the user to input their name, ID, and account balance
// Creates a BankAccount class to store values
// Prompts user to enter 1,2,3,4,5 to either
// 1- check the balance
// 2- deposit money
// 3- withdraw money
// 4- adds interest
// 5- exits program
// Created by Van Ralf Aguas and Tyler Hoh
// CS 11B Jessica Masters
// September 28, 2016

import bankaccount.BankAccount;
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
        do{
            username = userInput.nextLine();
            if(username.length() == 0){
                System.out.println("You must have a name! Please enter your name.");
            }
        }while(username.length() == 0);
        
        System.out.println("What is your account ID?");
        do{
            userID = userInput.nextLine();
            if(userID.length() == 0){
                System.out.println("You must have an ID! Please enter your ID.");
            }
        }while(userID.length() == 0);

        System.out.println("What is your account balance?");
        do{
            userBalance = userInput.nextDouble();
            if(userBalance == 0){
                System.out.println("You must have a starting balance! Please enter your account balance.");
            }
            else if(userBalance < 0){
                System.out.println("You cannot have a negative starting balance! Please enter a positive account balance.");
            }
        }while(userBalance == 0 || userBalance < 0);
 
        System.out.println("How much interest would you like?");
        userInterest = userInput.nextDouble();
        
        BankAccount newUser = new BankAccount(username, userID, userBalance,userInterest);
        newUser.setAccountInterest(userInterest);

        do{
            System.out.println("Press 1 to check balance." + 
                               "\nPress 2 to deposit money." +
                               "\nPress 3 to withdraw money." +
                               "\nPress 4 to add interest." +
                               "\nPress 5 to exit program.");
            
            choice = userInput.nextInt();
            
            switch(choice){
                case 1: 
                    System.out.println("Your balance is: $" + newUser.getAccountBalance());
                    break;
                case 2:
                    System.out.println("How much would you like to deposit?");
                    amount = userInput.nextDouble();
                    newUser.deposit(amount);
                    amount = 0;
                    break;           
                case 3:
                    System.out.println("How much would you like to withdraw?");
                    amount = userInput.nextDouble();
                    newUser.withdraw(amount);
                    amount = 0;
                    break;
                case 4:
                    newUser.addInterest();
                    break;
                default:
                    amount = 0;
                    break;
            }
        }while(choice < 5 && choice >= 0);
        
        System.out.println(newUser.toString());
    }
}
