/*
  _______________________________________________________________
 /                                                               \
||  Course: CSCI-470    Assignment #: 2    Semester: Summer 2018 ||
||                                                               ||
||  NAME:  Aaron Fosco    Z-ID: z1835687     Section: 1          ||
||                                                               ||
||                                                               ||
||  Due: Thursday 6/28/2018 by 11:59PM                           ||
||                                                               ||
||  Description:                                                 ||
||   A Simple program that will divide INTs and store them into  ||
||   3 diffrent primitive types.                                 ||
 \_______________________________________________________________/
*/
public class IntegerDivision
{
 public static void main(String[] args)
 {
  int numA = 78,
      numB = 33,
      numC;
  double numD;
  System.out.println("**** CSCI 470/680-E Assignment 2 Output ****");
  numC = numA / numB;
  System.out.printf("The result of integer %1$d divided by integer %2$d and stored in an integer is %3$d%n",
                    numA,
                    numB,
                    numC);
  numD = numA / numB;
  System.out.printf("The result of integer %1$d divided by integer %2$d and stored in a double is %3$.3f%n",
                    numA,
                    numB,
                    numD);
  numD = (double) numA / numB;
  System.out.printf("The result of integer %1$d (cast as a double) divided by integer %2$d and stored in a double is %3$.3f%n",
                    numA,
                    numB,
                    numD);
  System.out.println("**** CSCI 470/680-E Output Complete ****");
 }
}