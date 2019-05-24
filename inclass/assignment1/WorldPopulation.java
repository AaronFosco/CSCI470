/*
  _______________________________________________________________
 /                                                               \
||  Course: CSCI-470     Inclass #: 1.1    Semester: Summer 2018 ||
||                                                               ||
||  NAME:  Aaron Fosco    Z-ID: z1835687     Section: 1          ||
||                                                               ||
||                                                               ||
||  Due: Tuesday 6/26/2018 by 10:15PM                            ||
||                                                               ||
||  Description:                                                 ||
||   A Simple program that will calculate the world population   ||
||   after 1-5 years. The program will take user input for the   ||
||   population.                                                 ||
 \_______________________________________________________________/
*/
import java.util.Scanner;
import java.text.DecimalFormat;

public class WorldPopulation {
  public static void main(String[] args) {
   double curPop;
   double growth = 1.09;
   DecimalFormat df = new DecimalFormat("###,###,###,###,###,##0.##");
   Scanner input = new Scanner(System.in);
   System.out.println("Enter a population: "); 
   curPop = input.nextDouble();
   System.out.printf("You entered: %s \n", df.format(curPop));
   for (int i = 1; i < 6; i++)
   {
     curPop = curPop * growth;
     System.out.printf("The population after %d Years: %s\n", i, df.format(curPop));
   }
  }
}
