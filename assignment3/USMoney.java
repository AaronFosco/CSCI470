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
||   This is the class file for USMoney. It can be used to store ||
||   dollars and cents, as well has produce a new USMoney object ||
||   by taking the sum of two other USMoney object's data members||
 \_______________________________________________________________/
*/

import java.lang.Math;
public class USMoney {
  private int dollars = 0;
  private int cents = 0;
  
  /* ============================================================>
   * Constuctor: USMoney
   * 
   * Use: Sets the object's data members
   * 
   * Parameters: dollar: number to be stored into dollars
   *             cent: number to be stored into cents
   * ============================================================>
   */
  
  USMoney(int dollar, int cent){
    double holder = Math.floor((double) cent / 100);
    dollars += dollar + holder;
    cents = cent % 100;
  }
  
  /* ============================================================>
   * Function: plus
   * 
   * Use: Consturct a new USMoney object by suming the data members
   *      of two other USMoney objects
   * 
   * Parameters: x: USMoney object to have it's data members summed
   * 
   * Returns: The new USMoney object
   * ============================================================>
   */
  
  public USMoney plus(USMoney x) {
    USMoney rv = new USMoney((dollars + x.getDollars()),
                             (cents + x.getCents()));
    return rv;
  }
  
  /*============================================================>
   * Function: getDollars
   * 
   * Use: Gets the private data member dollar
   * 
   * Parameters: None
   * 
   * Returns: dollars
   * ============================================================>
   */
  
  public int getDollars() {
    return dollars;
  }
  
  /* ============================================================>
   * Function: getCents
   * 
   * Use: Gets the private data member cents
   * 
   * Parameters: None
   * 
   * Returns: cents
   * ============================================================>
   */
  
  public int getCents() {
    return cents; 
  }
}
  