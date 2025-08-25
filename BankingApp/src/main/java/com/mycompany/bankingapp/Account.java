/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingapp;
//import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author abdullahalnoman
 */
public class Account {
    
    private String ownerName;
    private String ownerNumber;
    private String ownerAddress;
    private String AccNumber;
    private double balance;
    private List<String> TransactionHistory;
    
    public Account(String ownerName, String ownerAddress, String ownerNumber, String newAccNumber){
        this.ownerName = ownerName;
        this.ownerNumber = ownerNumber;
        this.ownerAddress = ownerAddress;
        this.AccNumber = newAccNumber;
        this.balance = 0.0;
        this.TransactionHistory = new ArrayList<>();
        this.TransactionHistory.add("Account created with $ " + this.balance + "/-");
        
    }
    public Account(String ownerName, String ownerAddress, String ownerNumber, String AccNumber, List<String> history) {
        this.ownerName = ownerName;
        this.ownerNumber = ownerNumber;
        this.ownerAddress = ownerAddress;
        this.AccNumber = AccNumber;
        this.balance = balance;
        this.TransactionHistory = history;
    }   

    public String getOwnerName(){
        return ownerName;
    }
    public String getOwnerNumber(){
        return ownerNumber;
    }
    public String getOwnerAdress(){
        return ownerAddress;
    }
    public String getAccNumber(){
        return AccNumber;
    }
    public double getBalance(){
        return balance;
    }
    public List<String> getTransactionHistory(){
        return TransactionHistory;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void addTransaction(String Transaction){
        this.TransactionHistory.add(Transaction);
    }
    @Override
    public String toString() {
        return AccNumber + " | " + ownerName + " | $" + balance ;
}
}