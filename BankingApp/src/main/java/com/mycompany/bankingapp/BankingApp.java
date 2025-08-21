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
                    System.out.println("Make Deposit");
                    break;
                    case "3" :
                    System.out.println("Make withdrow");
                    break;
                    case "4" :
                    System.out.println("Check balance");
                    break;
                    case "5" :
                    System.out.println("Transfer fund");
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
        System.out.println("\n--- Create a New Account ---");
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
    }
}
