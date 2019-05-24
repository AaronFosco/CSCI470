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
||   This is the class file for date. It will store a day, month ||
||   and year into it's data members, it can also calculate days ||
||   since january 1st.                                          ||
 \_______________________________________________________________/
*/

public class Date {
  private int day, month, year;
  
  /* ============================================================>
   * Constuctor: Date
   * 
   * Use: sets the object's data members
   * 
   * Parameters: y: number to be stored into year
   *             m: number to be stored into month
   *             d: number to be stored into day
   * ============================================================>
   */
  
  Date(int y, int m, int d) {
    day = d;
    month = m;
    year = y;
  }
  
  /* ============================================================>
   * Function: daysSinceJan1
   * 
   * Use: Calculates the days since january 1st
   * 
   * Parameters: none
   * 
   * Returns: days since january 1st
   * ============================================================>
   */
  
  public int daysSinceJan1() {
    int rv = 0;
    switch(month) {
      case 1:
        rv = day;
        break;
      case 2:
        rv = day + 31;
        break;
      case 3:
        rv = day + 59;
        break;
      case 4:
        rv = day + 90;
        break;
      case 5:
        rv = day + 120;
        break;
      case 6:
        rv = day + 151;
        break;
      case 7:
        rv = day + 181;
        break;
      case 8:
        rv = day + 212;
        break;
      case 9:
        rv = day + 243;
        break;
      case 10:
        rv = day + 273;
        break;
      case 11:
        rv = day + 304;
        break;
      case 12:
        rv = day + 334;
        break;
    }
    if ((year % 4) == 0 && ((year % 100) == (year % 400)))
      rv++;
    
    return rv;
  }
}