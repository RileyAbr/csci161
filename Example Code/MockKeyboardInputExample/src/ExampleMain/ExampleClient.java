/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExampleMain;

import java.util.Scanner;

/**
 *
 * @author araderma
 */
public class ExampleClient 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in); 
        
        System.out.println("Please enter your name: ");
        String name = scan.nextLine();
        System.out.println("Please enter your ID: ");
        int id = scan.nextInt();
        System.out.println("Please enter your GPA: ");
        double gpa = scan.nextDouble();
        scan.nextLine(); // burn the leftover newline
        
        System.out.println("Please enter your favorite color: ");
        String color = scan.nextLine(); 
        
        System.out.println(name + ", " + id + ", " + gpa + ", " + color);
        
    }
}
