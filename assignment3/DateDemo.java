/*
  _______________________________________________________________
 /                                                               \
||  Course: CSCI-470    Assignment #: 3.2  Semester: Summer 2018 ||
||                                                               ||
||  NAME:  Aaron Fosco    Z-ID: z1835687     Section: 1          ||
||                                                               ||
||  TA's Name: Srikar Akula                                      ||
||                                                               ||
||  Due: Tuesday  7/02/2018 by 11:59PM                           ||
||                                                               ||
||  Description:                                                 ||
||   This is the driver file for the date class. It will request ||
||   a day, a month, and a year, then consturct a new date       ||
||   object and call the function daysSinceJan1.                 ||
 \_______________________________________________________________/
*/

import java.util.Scanner;
public class DateDemo {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int x, y, z;
    
    System.out.println("Please Enter a year:");
    x = scan.nextInt();
    
    System.out.println("Enter a month:");
    y = scan.nextInt();
    
    System.out.println("Enter a day:");
    z = scan.nextInt();
    
    Date dayte = new Date(x, y, z);
    System.out.printf("%d days have past since January 1st\n", dayte.daysSinceJan1());
  }
}