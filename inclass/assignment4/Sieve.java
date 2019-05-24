/*
  _______________________________________________________________
 /                                                               \
||  Course: CSCI-470    In-class #: 4      Semester: Summer 2018 ||
||                                                               ||
||  NAME:  Aaron Fosco    Z-ID: z1835687     Section: 1          ||
||                                                               ||
||  TA's Name: Srikar Akula                                      ||
||                                                               ||
||  Due: Tusday  7/10/2018 by 10:15PM                            ||
||                                                               ||
||  Description:                                                 ||
||   This is the file for Sieve.java. This program will calculate||
||   all prime values from 2 to 999, Then print out those values ||
 \_______________________________________________________________/
*/

import java.util.Arrays;
public class Sieve {
  public static void main(String[] args) {
    boolean[] sieveArray = new boolean[1000];
    Arrays.fill(sieveArray, true);
    for (int count = 2; count <= 999; count++) {
      if (sieveArray[count] == true) {
        for (int inner = 2; inner*count <= 999; inner++) {
          sieveArray[inner*count] = false;
        }
      } 
    }
    int count = 0;
    for (int it = 2; it <= 999; it++) {
      if (sieveArray[it]) {
        if (count == 6) {
          System.out.println(" ");
          count = 0;
        }
        System.out.print(" " + it );
        count++;
      }
    }
    System.out.println(" ");
  }
}