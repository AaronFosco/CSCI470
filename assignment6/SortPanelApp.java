/*
  _______________________________________________________________
 /                                                               \
||  Course: CSCI-470    Assignment #: 6    Semester: Summer 2018 ||
||                                                               ||
||  NAME:  Aaron Fosco    Z-ID: z1835687     Section: 1          ||
||                                                               ||
||  TA's Name: Srikar Akula                                      ||
||                                                               ||
||  Due: Monday  8/07/2018 by 11:59PM                            ||
||                                                               ||
||  Description:                                                 ||
||   This is the SortPanelApp class. It contains the main routine||
||   and will generate two SortPanel objects and add them to a   ||
||   JFrame. It also sets default options.                       ||
 \_______________________________________________________________/
*/

import javax.swing.JFrame;
import java.awt.FlowLayout;

public class SortPanelApp extends JFrame {
  public SortPanelApp(String s) {
    super(s);
    
    //set main flowlayout for JFrame
    setLayout(new FlowLayout(FlowLayout.LEADING, 2, 2));
    
    //No resize
    setResizable(false);
    
    //create objects
    SortPanel sp1 = new SortPanel();
    SortPanel sp2 = new SortPanel();
    
    //add them to the JFrame
    add(sp1);
    add(sp2);
  }
  
  public static void main(String[] args) {
    
    //New instance of this class
    SortPanelApp mainWindow = new SortPanelApp("Sorting Algorithm");
    
    //set attributes
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setSize(900, 390);
    mainWindow.setVisible(true);
  }
}