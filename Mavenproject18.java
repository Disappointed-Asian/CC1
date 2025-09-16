/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject18;

/**
 *
 * @author M304User
 */

import java.util.Scanner;

public class Mavenproject18 {

    public static void main(String[] args) {
        //Creates new scanner
        Scanner scanner = new Scanner(System.in);
        
        //Asks user for price and quantity of items
        System.out.println("Enter Price of Item 1(PHP): ");
        double price1 = scanner.nextInt();
        System.out.println("Enter Quantity of Item 1: ");
        double quantity1 = scanner.nextInt();
        
        System.out.println("Enter Price of Item 2(PHP): ");
        double price2 = scanner.nextInt();
        System.out.println("Enter Quantity of Item 2: ");
        double quantity2 = scanner.nextInt();
        
        System.out.println("Enter Price of Item 3(PHP): ");
        double price3 = scanner.nextInt();
        System.out.println("Enter Quantity of Item 3: ");
        double quantity3 = scanner.nextInt();
        
        //Calculates subtotal
        double subtotal = (price1*quantity1) + (price2*quantity2) + (price3*quantity3);
        double discount = subtotal*.05;
        double salesTax = (subtotal - discount) * .12;
        double finalTotal = subtotal - discount + salesTax;
        
        System.out.println("\n\n-----------------------------------------------");
        System.out.println("Price of Item 1: \tPHP " + price1);
        System.out.println("Quantity of Item 1: \t" + quantity1);
        System.out.println("\nPrice of Item 2: \tPHP " + price2);
        System.out.println("Quantity of Item 2: \t" + quantity2);
        System.out.println("\nPrice of Item 3: \tPHP " + price3);
        System.out.println("Quantity of Item 3: \t" + quantity3);
        System.out.println("-----------------------------------------------");
        System.out.println("Subtotal: \t\tPHP " + subtotal);
        System.out.println("Discount: \t\tPHP " + discount);
        System.out.println("Sales Tax: \t\tPHP " + salesTax);
        System.out.println("Final Total: \t\tPHP " + finalTotal);
        System.out.println("-----------------------------------------------");
        scanner.close();
    }
}
