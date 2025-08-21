/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bankingapp;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author abdullahalnoman
 */
public class Account {
    
    private String ownerName;
    private int ownerNumber;
    private String ownerAddress;
    private String AccNumber;
    private double balance;
    private List<String> TransactionHistory;
    
    public Account(String ownerName, int ownerNumber, String ownerAddress){
        this.ownerName = ownerName;
        this.ownerNumber = ownerNumber;
        this.ownerAddress = ownerAddress;
        this.AccNumber = UUID.randomUUID().toString();
        this.balance = 0.0;
        this.TransactionHistory = new ArrayList<>();
        this.TransactionHistory.add("Account created with $ " + this.balance + "/-");
        
    }

    Account(String ownerName, String ownerAddress, int ownerNumber) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getOwnerName(){
        return ownerName;
    }
    public int getOwnerNumber(){
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
    public void addTransaction(String Transaction){
        this.TransactionHistory.add(Transaction);
    }
    @Override
    public String toString() {
        return AccNumber + " | " + ownerName + " | $" + balance ;
}
}