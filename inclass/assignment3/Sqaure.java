/*
  _______________________________________________________________
 /                                                               \
||  Course: CSCI-470    In-class #: 3.1    Semester: Summer 2018 ||
||                                                               ||
||  NAME:  Aaron Fosco    Z-ID: z1835687     Section: 1          ||
||                                                               ||
||  TA's Name: Srikar Akula                                      ||
||                                                               ||
||  Due: Thursday  7/05/2018 by 11:59PM                          ||
||                                                               ||
||  Description:                                                 ||
||   This is the class file for Square. It will take a number &  ||
||   print out a square of asterisks with a side length of the   ||
||   number.
 \_______________________________________________________________/
*/

import java.util.Scanner;
public class Sqaure { 
  public static void main(String[] args) {
    boolean endval = false;
    String restval;
    Scanner scan = new Scanner(System.in);
    
    while (!endval) {
      System.out.println("How Long should one side be?");
      squareOfAsterisks(scan.nextInt());
      System.out.print("Would you like to make another square?\nyes or no:");
      restval = scan.next();
      restval.toLowerCase();
      endval = (restval.charAt(0) == 'n');
    }
  }
	
  public static void squareOfAsterisks(int side) {
    String asterik = "*";
    for (int i = 1
           
           ; i < side; i++)
      asterik += '*';
    for (int i = 0; i < side; i++)
      System.out.println(asterik);
  }                                         
                                            
}