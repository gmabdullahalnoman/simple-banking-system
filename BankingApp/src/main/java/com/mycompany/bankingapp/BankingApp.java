/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bankingapp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author abdullahalnoman
 */
public class BankingApp {

    private static List<Account> accountsDatabase = new ArrayList<>();
    
    public static void main(String[] args) {
        
    Scanner input = new Scanner(System.in);
        
    boolean isRunning = true;
    
        
    while (isRunning){
        
        System.out.println("***************************************");
        System.out.println("Welcome to Simple Bank System");
        System.out.println("***************************************");
        System.out.println("1. Create a New Account");
        System.out.println("2. Make a deposit");
        System.out.println("3. Make a Withdrow");
        System.out.println("4. Check balance");
        System.out.println("5. Transfer money");
        System.out.println("6. Exit application");
        System.out.println("***************************************");
        System.out.println("Enter your choice (1-6): ");
        
            String choice = input.nextLine();
            
            switch (choice) {
                case "1":
                    //System.out.println("Create new account");
                    createAccount(input);
                    break;
                case "2" :
                    //System.out.println("Make Deposit");
                    deposit(input);
                    break;
                    case "3" :
                    //System.out.println("Make withdrow");
                    withdraw(input);
                    break;
                    case "4" :
                    //System.out.println("Check balance");
                    checkBalance(input);
                    break;
                    case "5" :
                    //System.out.println("Transfer fund");
                    transfer(input);
                    break;
                    case "6" :
                    isRunning = false;
                    break;
                default:
                    
                    System.out.println("Wrong entry");
            }
        }
        input.close();
    }
    static void createAccount(Scanner input){
        System.out.println("\n----- Create a New Account -----");
        System.out.print("Enter owner's name: ");
        String ownerName = input.nextLine();
        
        System.out.print("Enter owner's address: ");
        String ownerAddress = input.nextLine();
        
        System.out.println("Enter owner's number: ");
        int ownerNumber = input.nextInt();
        
        Account newAccount = new Account(ownerName, ownerAddress, ownerNumber);
        
        System.out.println("\nSuccess! New account created.");
        System.out.println("Account Number: " + newAccount.getAccNumber());
        System.out.println("Account Owner: " + newAccount.getOwnerName());
        System.out.println("Current Balance: $" + newAccount.getBalance());
        System.out.println("You can check this account in the 'Check Balance' option.");
        
        accountsDatabase.add(newAccount);
    }
    public static void deposit(Scanner input){
        System.out.println("\n----- Make a Deposit -----");
        System.out.println("Enter account number: ");
        String accNumber = input.nextLine();
        
        Account account = findAccount(accNumber);
        
        if(account != null){
            System.out.println("Enter amount to deposit: $");
            double amount = input.nextDouble();
            input.nextLine();
            
            if(amount > 0){
                account.setBalance(account.getBalance() + amount);
                account.addTransaction("Deposited $" + amount);
                System.out.println("Successfully $"+amount+" deposited to account "+account.getAccNumber());
            }
            else{
                System.out.println("Invalid,Enter positive number and try again");
            }
            
        } 
        else {
            System.out.println("Account not found");
        }
    }
    private static Account findAccount(String accNumber){
        for (Account account : accountsDatabase) {
            if(account.getAccNumber().equals(accNumber)){
                return account;
            }
        }
        return null;
    }
    public static void withdraw(Scanner input){
        System.out.println("\n----- Make a Withdrawal -----");
        System.out.println("Enter account number: ");
        String accNumber = input.nextLine();
        
        Account account = findAccount(accNumber);
        
        if (account != null){
            System.out.println("Enter amount to withdraw");
            double amount = input.nextDouble();
            input.nextLine();
            
            if(amount > 0){
                account.setBalance(account.getBalance() - amount);
                account.addTransaction("Withdrew $"+amount);
                System.out.println("Successfully $" +amount+ "withdrawn from "+ account.getAccNumber());
                
            }
            else{
                System.out.println("Insufficient fund | Withdrawal failed");
            }
            
        } else {
            System.out.println("Account not found");
        }
        
    }
    public static void checkBalance(Scanner input){
        System.out.println("\n----- Check Balance -----");
        System.out.println("Enter account number: ");
        String accNumber = input.nextLine();
        
        Account account = findAccount(accNumber);
        
        if(account != null){
            System.out.println("Details of "+accNumber+" :");
            System.out.println("Owner: "+account.getOwnerName());
            System.out.println("Current balance: $"+account.getBalance());
            System.out.println("\n----- Transaction History -----");
            
            for (String transaction : account.getTransactionHistory()){
                System.out.println("==> "+ transaction);
            }
        }
        else{
            System.out.println("Account not founds");
        }
        
    }
    public static void transfer(Scanner input){
        System.out.println("\n----- Transfer Funds -----");
        
        System.out.println("Enter your account number: ");
        String fromAccNumber = input.nextLine();
        
        System.out.println("Enter recipient account number: ");
        String toAccNumber = input.nextLine();
        
        Account fromAccount = findAccount(fromAccNumber);
        Account toAccount = findAccount(toAccNumber);
        
        if(fromAccount != null && toAccount != null){
            System.out.println("Enter amount to transfer: $");
            
            double amount = input.nextDouble();
            
            if(amount > 0){
                fromAccount.setBalance(fromAccount.getBalance()- amount);
                toAccount.setBalance(toAccount.getBalance()+ amount);
                
                fromAccount.addTransaction("Transferred $"+amount + " to " + toAccount.getAccNumber()  );
                toAccount.addTransaction("Received $"+amount+" from "+ fromAccount.getAccNumber());
                
                System.out.println("Successfully transferred funds");
        }else{
                System.out.println("Insufficient funds, Transaction failed");
            }
        }
        else{
            System.out.println("Sender or Recipient not found,please check accunts again!");
        }
        
        
    }
}
