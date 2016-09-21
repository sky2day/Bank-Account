package bankaccount;
// BankAccount:
// Prompts the user to input their name, ID, and account balance
// Creates a BankAccount class to store values
// Prompts user to enter 1,2,3,4,5 to either
// 1- check the balance
// 2- deposit money
// 3- withdraw money
// 4- adds interest
// 5- exits program (or any other integer)
// Created by Van Ralf Aguas and Tyler Hoh
// CS 11B Jessica Masters
// September 28, 2016

public class BankAccount {
    
    private String accountOwner;
    private String accountID;
    private double accountBalance;
    private double accountInterest;
    
    public BankAccount(String owner, String ID, double balance, double interest){ //constructor
        accountOwner = owner;
        accountID = ID;
        accountBalance = balance;
        accountInterest = interest;
    }
    
    // gets account owner
    public String getAccountOwner(){ 
        return accountOwner;
    }
    // gets account ID
    public String getAccountID(){ 
        return accountID;
    }
    // gets account balance
    public double getAccountBalance(){ 
        return accountBalance;
    }
    // gets account interest
    public double getAccountInterest(){ 
        return accountInterest;
    }
    // sets account owner
    public void setAccountOwner(String owner){ 
        if(owner.length() == 0){
                System.out.println("You must have a name! Please enter your name.");
        }
        else{
            accountOwner = owner;
        }
    }
    // sets account ID
    public void setAccountID(String ID){ 
        if(ID.length() == 0){
            System.out.println("You must have an ID! Please enter your ID.");
        }
        else{
            accountID = ID;
        }
    }
    // sets account balance
    public void setAccountBalance(double balance){ 
        if(balance == 0){
                System.out.println("You must have a starting balance! Please enter your account balance.");
        }
        else if(balance < 0){
                System.out.println("You cannot have a negative starting balance! Please enter a positive account balance.");
            }
        else{
            accountBalance = balance;
        }
    }
    // sets account interest
    public void setAccountInterest(double interest){ 
        accountInterest = interest/100; //to turn into a decimal value
    }
    // method to deposit amount
    public void deposit(double depositAmount){
        if(depositAmount == 0){
            System.out.println("No money was deposited in this transaction.");
        }
        else if(depositAmount < 0.01)
            System.out.println("Please enter a larger amount");
        else{
            accountBalance += depositAmount;
            setAccountBalance(accountBalance);
        }
    }
    // method to withdraw amount
    public void withdraw(double withdrawAmount){
        if(withdrawAmount > accountBalance)
            System.out.println("Insufficient funds. Please enter a valid amount.");
        else if(withdrawAmount == 0){
            System.out.println("No money was withdrawn from this transaction");
        }
        else if(withdrawAmount < 0){
            System.out.println("Please enter a positive, non zero amount.");
        }
        else{
            accountBalance -= withdrawAmount;
            setAccountBalance(accountBalance);
        }
    }
    //adds interest to balance
    public void addInterest(){
        setAccountBalance(accountBalance += (accountBalance * accountInterest));
    }
    //toString method
    public String toString(){
        return "Username: " + accountOwner 
              +"\nID: "       + accountID
              +"\nInterest Rate: " + (accountInterest*100) + "%"
              +"\nBalance: "  + accountBalance;
    }
}