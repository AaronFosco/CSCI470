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
||   This is the Destination class for this package. This class  ||
||   will hold information for each destination. It has two      ||
||   constructors, one base constructor, and one for setting all ||
||   data members to values that get passed in the form of a     ||
||   single String. Also included are getter/setter functions    ||
||   for each data member.                                       ||
 \_______________________________________________________________/
*/

import java.io.*;
public class Destination {
  private String destn;
  private int normM, flyC, firstClUp, starM, endM;
  public Destination() {
    destn = " ";
    normM = 0;
    flyC = 0;
    firstClUp = 0;
    starM = 0;
    endM = 0;
  }
  public Destination(String list) {
    String[] strAr = list.split(";");
    String[] monthAr = strAr[strAr.length-1].split("-");
    destn = strAr[0];
    normM = Integer.parseInt(strAr[1]);
    flyC = Integer.parseInt(strAr[2]);
    firstClUp = Integer.parseInt(strAr[3]);
    starM = Integer.parseInt(monthAr[0]);
    endM = Integer.parseInt(monthAr[1]);
  }
  //in an attempt to cover all bases, all getters/setters are included
  
  //Getter Functions
  
  public String getDestinationName() {
    return destn;
  }
  
  public int getNormalMiles() {
    return normM;
  }
  
  public int getFlyCheapMiles() {
    return flyC;
  }
  
  public int getFirstClassUpgrade() {
    return firstClUp;
  }
  
  public int getStartMonth() {
    return starM;
  }
  
  public int getEndMonth() {
    return endM;
  }
  
  public void setDestinationName(String dest) {
    destn = dest;
  }
  
  public void setNormalMiles(int norm) {
    normM = norm;
  }
  
  public void setFlyCheapMiles(int fly) {
    flyC = fly;
  }
  
  public void setFirstClassUpgrade(int first) {
    firstClUp = first;
  }
  
  public void setStartMonth(int star) {
    starM = star;
  }
  
  public void setEndMonth(int end) {
    endM = end;
  }
}