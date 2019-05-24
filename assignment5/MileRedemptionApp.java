/*
  _______________________________________________________________
 /                                                               \
||  Course: CSCI-470    Assignment #: 5    Semester: Summer 2018 ||
||                                                               ||
||  NAME:  Aaron Fosco    Z-ID: z1835687     Section: 1          ||
||                                                               ||
||  TA's Name: Srikar Akula                                      ||
||                                                               ||
||  Due: Monday  7/30/2018 by 11:59PM                            ||
||                                                               ||
||  Description:                                                 ||
||   This is the MileRedemtionApp class in this package. This    ||
||   holds the main routine and simply creates a new             ||
||   MileRedemptionGUI.                                          ||
 \_______________________________________________________________/
*/
import javax.swing.JFrame;
public class MileRedemptionApp {
  public static void main(String[] args) {
    
    //new instance of MileRedemptionGUI
    
    MileRedemptionGUI myApp = new MileRedemptionGUI();
    
    //Set attributes 
    
    myApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //The JPanel was big enough on linux, but not on windows,
    //Corners will not be colored in...
    myApp.setSize(715, 340);
    myApp.setVisible(true);
    
  }
}