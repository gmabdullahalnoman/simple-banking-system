package com.mycompany.members;

/**
 *
 * @author abdullahalnoman
 */
public class Member {
    private String name;
    private int age;
    
    public Member(String name,int age){
        this.name = name;
        this.age = age;
    }
    
    public String toCSV(){
        return name +" , " +age;
    }
}
