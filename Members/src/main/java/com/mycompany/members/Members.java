/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.members;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author abdullahalnoman
 */
public class Members {
    private static final String MEMBER_FILE = "members.csv";

    public void showMembers(){
        try (BufferedReader reader = new BufferedReader(new FileReader(MEMBER_FILE))) {
            String line;
            System.out.println("\n📋 Members List:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    String age = parts[1];
                    System.out.println("Name: " + name + " | Age: " + age);
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file (maybe it's empty): " + e.getMessage());
        }
    }
    // Method to add new member (ask input, save to CSV)
    public void addMember() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter member name: ");
        String name = sc.nextLine();

        System.out.print("Enter member age: ");
        int age = sc.nextInt();
        sc.nextLine(); 

        Member newMember = new Member(name, age);

        FileWriter writer = new FileWriter(MEMBER_FILE, true);
            writer.write(newMember.toCSV() + "\n");
            System.out.println("✅ Member saved to " + MEMBER_FILE);
    }
    // Main program
    public static void main(String[] args) {
        Members membersManager = new Members();
        Scanner input = new Scanner(System.in);

        OUTER:
        while (true) {
            try {
                System.out.println("\n1. Add Member");
                System.out.println("2. View Members");
                System.out.println("3. Exit");
                System.out.print("Choose option: ");
                int choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1 -> membersManager.addMember();
                    case 2 -> membersManager.showMembers();
                    case 3 -> {
                        System.out.println("Exiting...");
                        break OUTER;
                    }
                    default -> System.out.println("Invalid choice, try again.");
                }
            } catch (IOException ex) {
                System.getLogger(Members.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
    }
    
}    
