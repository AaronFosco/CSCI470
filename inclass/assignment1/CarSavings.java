/*
  _______________________________________________________________
 /                                                               \
||  Course: CSCI-470     Inclass #: 1.2    Semester: Summer 2018 ||
||                                                               ||
||  NAME:  Aaron Fosco    Z-ID: z1835687     Section: 1          ||
||                                                               ||
||                                                               ||
||  Due: Tuesday 6/26/2018 by 10:15PM                            ||
||                                                               ||
||  Description:                                                 ||
||   A Program to calculate the cost effectivenes of carpooling. ||
||   It will take user input and calculate the daily, monthly    ||
||   and annual cost.                                            ||
 \_______________________________________________________________/
*/
import java.util.Scanner;
import java.text.DecimalFormat;

public class CarSavings {
  public static void main (String[] args) {
    double miles, cost, mpg, parking, tolls;
    Scanner input = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("$###,###,###,###,##0.00");
    System.out.println("This will calculate Car-Pool Savings!");
    System.out.println("Enter your total miles driven per day: ");
    miles = input.nextDouble();
    System.out.println("Enter your local cost per gallon of gas: ");
    cost = input.nextDouble();
    System.out.println("Enter your avg. MPG: ");
    mpg = input.nextDouble();
    System.out.println("Enter your parking fees per day: ");
    parking = input.nextDouble();
    System.out.println("Enter your tolls per day: ");
    tolls = input.nextDouble();
    System.out.printf("Daily cost: %s \nMonthly cost %s \nAnnual: %s\n", 
                      (df.format((miles / mpg) * cost + parking + tolls)), 
                      (df.format((miles / mpg) * cost * 30 + parking + tolls)),
                      (df.format((miles / mpg) * cost * 365 + parking + tolls)));
  }
}
