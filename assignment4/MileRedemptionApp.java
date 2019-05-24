/*
  _______________________________________________________________
 /                                                               \
||  Course: CSCI-470    Assignment #: 4    Semester: Summer 2018 ||
||                                                               ||
||  NAME:  Aaron Fosco    Z-ID: z1835687     Section: 1          ||
||                                                               ||
||  TA's Name: Srikar Akula                                      ||
||                                                               ||
||  Due: Monday  7/16/2018 by 11:59PM                            ||
||                                                               ||
||  Description:                                                 ||
||   This is the main class for this package. Will use the class ||
||   MileRedeemer to figure out what destinations a client can   ||
||   go to given user input for a file to read, Freq. flyer      ||
||   miles, and month that the client wants to leave.            ||
 \_______________________________________________________________/
*/

import java.io.*;
import java.util.Scanner;
public class MileRedemptionApp {
  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    MileRedeemer miler = new MileRedeemer();
    String filename ;
    String[] destNames;
    String[] appliDestNames;
    int freqFlyM, depart;
    String anotherOne;
    boolean endVal = false;
    
    
    System.out.print("Please enter the name of the file: ");
    filename = scan.next();
    File file = new File(filename);
    Scanner fileScan = new Scanner(file);
    miler.readDestinations(fileScan);
    destNames = miler.getCityNames();
    
    System.out.println("\n----------------------------------------------------------------");
    System.out.println("WELCOME TO THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
    System.out.println("----------------------------------------------------------------\n");
    System.out.println("List of destination cities your client can travel to:\n");
    
    for (String destn : destNames)
      System.out.println(destn);
    
    while (!endVal) {
      System.out.println("\n----------------------------------------------------------------\n");
      
      System.out.print("Please enter your client's accumulated Frequent Flyer Miles: ");
      freqFlyM = scan.nextInt();
      System.out.print("\nPlease enter your client's month of departure (1-12): ");
      depart = scan.nextInt();
      appliDestNames = miler.redeemMiles(freqFlyM, depart);
    
      if (appliDestNames.length != 0) {
        System.out.println("\nYour client's Frequent Flyer Miles can be used to redeem the following tickets:\n");
        for (String destnPlus : appliDestNames) 
          System.out.println(destnPlus);
      
      } else {
        System.out.println("\n*** Your client has not accumulated enough Frequent Flyer Miles ***");
      }
      
      freqFlyM = miler.getRemainingMiles();
      System.out.println("\nYour client's remaining Frequent Flyer Miles: " + freqFlyM);
    
      System.out.println("\n----------------------------------------------------------------\n");
      
      System.out.print("do you want to continue? y/n: ");
      anotherOne = scan.next();
      anotherOne.toLowerCase();
      endVal = (anotherOne.charAt(0) == 'n');
    }
    
    System.out.println("\n----------------------------------------------------------------");
    System.out.println("THANK YOU FOR USING THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
    System.out.println("----------------------------------------------------------------");
  }
}