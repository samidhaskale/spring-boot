/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.prac9;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

/**
 *
 * @author asus tuf gaming
 */
public class DemoApplication implements CommandLineRunner{
    
    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class);
    }
    
    @Override
    public void run(String... args){
        try {
            if(args.length < 4){
                System.out.println("Usage: <RollNo> <Name> <Marks> <Subject>");
                return;
            }
            
            String rollno = args[0];
            String name = args[1];
            String marks = args[2];
            String sub = args[3];
            
            int rollNo = Integer.parseInt(rollno);
            double marksd = Double.parseDouble(marks);
            
            double percentage = (marksd / 100) * 100; 
            
            System.out.println("----- Student Info -----"); 
            System.out.println("Roll No: " + rollNo); 
            System.out.println("Name: " + name); 
            System.out.println("Subject: " + sub); 
            System.out.println("Marks: " + marksd); 
            System.out.println("Percentage: " + percentage); 
        } catch(NumberFormatException e){
            System.out.println("Error: Roll No and Marks must be numeric.");
        }
        
    }
    
}
