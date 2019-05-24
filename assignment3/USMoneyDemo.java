/*
  _______________________________________________________________
 /                                                               \
||  Course: CSCI-470    Assignment #: 3.1  Semester: Summer 2018 ||
||                                                               ||
||  NAME:  Aaron Fosco    Z-ID: z1835687     Section: 1          ||
||                                                               ||
||  TA's Name: Srikar Akula                                      ||
||                                                               ||
||  Due: Tuesday  7/02/2018 by 11:59PM                           ||
||                                                               ||
||  Description:                                                 ||
||   The driver program for the USMoney class. This program will ||
||   take user input for the money of two people, then pool them ||
||   together and output the result.                             ||
 \_______________________________________________________________/
*/
import java.util.Scanner;
public class USMoneyDemo {
  public static void main(String[] args) {
    int alpha, beta;
    Scanner scan = new Scanner(System.in);
    
    System.out.println("How many dollars for person 1?");
    alpha = scan.nextInt();
    System.out.println("How many cents?");
    beta = scan.nextInt();
    USMoney p1 = new USMoney(alpha, beta);
    
    System.out.println("How many dollars for person 2?");
    alpha = scan.nextInt();
    System.out.println("How many cents?");
    beta = scan.nextInt();
    USMoney p2 = new USMoney(alpha, beta);
    
    USMoney p3 = p2.plus(p1);
    System.out.printf("If person 1 and person 2 where to pool their money together they'd have\nDollars:%d \nCents:%d\n",
                      p3.getDollars(),
                      p3.getCents());
  }
}
                      
    