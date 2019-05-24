/*
  _______________________________________________________________
 /                                                               \
||  Course: CSCI-470    In-class #: 5      Semester: Summer 2018 ||
||                                                               ||
||  NAME:  Aaron Fosco    Z-ID: z1835687     Section: 1          ||
||                                                               ||
||  TA's Name: Srikar Akula                                      ||
||                                                               ||
||  Due: Wendsday  8/25/2018 by 7:00PM                           ||
||                                                               ||
||  Description:                                                 ||
||    This is the Events main class. It will create a new        ||
||    EventsFrame object, sets the size, and shows it.           ||
 \_______________________________________________________________/
*/

import javax.swing.JFrame;

public class Events {
  public static void main(String[] args) {
    EventsFrame evFrame = new EventsFrame();
    evFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    evFrame.setSize(450, 400);
    evFrame.setVisible(true);
  }
}