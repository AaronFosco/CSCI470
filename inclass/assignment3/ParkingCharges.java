/*
  _______________________________________________________________
 /                                                               \
||  Course: CSCI-470    In-class #: 3.2    Semester: Summer 2018 ||
||                                                               ||
||  NAME:  Aaron Fosco    Z-ID: z1835687     Section: 1          ||
||                                                               ||
||  TA's Name: Srikar Akula                                      ||
||                                                               ||
||  Due: Thursday  7/05/2018 by 11:59PM                          ||
||                                                               ||
||  Description:                                                 ||
||   This is the class file for ParkingCharges. This program     ||
||   will calculate parking cost for a customer in a day.        ||
 \_______________________________________________________________/
*/
import java.util.Scanner;
public class ParkingCharges {
  public static void main(String[] args) {
    double charge;
    int hours;
    String restval;
    Scanner scan = new Scanner(System.in);
    boolean endval = false;
    while (!endval) {
      System.out.println("Enter The ammount of hours You've been parked:");
      hours = scan.nextInt();
      System.out.printf("You owe $%.2f\n", calculateCharges(hours));
      System.out.print("Would you like to calculate another customer's parking hours?\nyes or no:");
      restval = scan.next();
      restval.toLowerCase();
      endval = (restval.charAt(0) == 'n');
    }
  }
  
  public static double calculateCharges(int hours) {
   double rv;
   if (hours <= 3)
     rv = 2.00;
   else
     rv = 2.00 + (.5 * hours);
   return (rv >= 10.00) ? 10.00 : rv;
  }
}