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
||   This is the MileRedemptionGUI class for this package. This  ||
||   Class Will create the main swing JFrame, and provide an     ||
||   additional dialog for entering in a name for a file in the  ||
||   same directory. This will also use the class MileRedeemer to||
||   figure out what destinations a client can go to given the   ||
||   input from the file request dialog box, the inputed Freq.   ||
||   Flyer miles, and month that the client will leave.          ||
 \_______________________________________________________________/
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MileRedemptionGUI extends JFrame {
  
  //Define class vars
  
  private JPanel destinations;
  private JPanel redeemMiles;
  private Border blackLine;
  private JTextField mileInputBox;
  private JTextField normMilesField;
  private JTextField ssMilesField;
  private JTextField upgradeCostField;
  private JTextField ssDateField;
  private JTextField remMilesField;
  private JLabel normMilesLabel;
  private JLabel ssMilesLabel;
  private JLabel upgradeCostLabel;
  private JLabel ssDateLabel;
  private JLabel mileInputLabel;
  private JLabel monthLabel;
  private JLabel remMilesLabel;
  private JButton redMilesButton;
  private JSpinner monthSpinner;
  private JTextArea redeemBox;
  private JList destListBox;
  private TitledBorder destBorder;
  private TitledBorder mileBorder;
  private String[] destNames;
  private String[] months;
  private MileRedeemer miler;
  
  //Main Constructor
  
  public MileRedemptionGUI() {
    super("Frequent Filer App");
    
    //No resize
    
    setResizable(false);
    
    //Inialize MileRedeemer and months
    miler = new MileRedeemer();
    months = getMonthStrings();
    
    //Get destinations and output 
    buildDestList();
    
    
    //Create new objects and handlers
    //Each object is made as it is placed on it's respective JPanel 
    
    setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
    
    //Destinations
    destinations = new JPanel(new FlowLayout(FlowLayout.LEADING, 2, 1));
    destListBox = new JList<String>(destNames);
    normMilesField = new JTextField();
    normMilesLabel = new JLabel("Normal miles");
    ssMilesField = new JTextField();
    ssMilesLabel = new JLabel("Supersaver miles");
    upgradeCostField = new JTextField();
    upgradeCostLabel = new JLabel("upgrade cost");
    ssDateField = new JTextField();
    ssDateLabel = new JLabel("Supersaver Dates");
    
    //Redeem Miles
    redeemMiles = new JPanel(new FlowLayout(FlowLayout.LEADING, 2, 1));
    mileInputBox = new JTextField();
    mileInputLabel = new JLabel("Enter Your Miles");
    SpinnerListModel monthsModel = new SpinnerListModel(months);
    monthSpinner = new JSpinner(monthsModel);
    monthLabel = new JLabel("Select month of departure");
    redMilesButton = new JButton("Redeem Miles");
    redeemBox = new JTextArea();
    remMilesField = new JTextField();
    remMilesLabel = new JLabel("Your remaining miles");
    
    //handlers
    ListHandeler listHandel = new ListHandeler();
    EventsHandler eventsHandel = new EventsHandler();
    
    //Borders
    blackLine = BorderFactory.createLineBorder(Color.black);
    destBorder = BorderFactory.createTitledBorder(blackLine, "Destinations");
    mileBorder = BorderFactory.createTitledBorder(blackLine, "Redeem Miles");
    
    
    //Set attributes
    
    //Destination
    destBorder.setTitleJustification(TitledBorder.CENTER);
    destinations.setPreferredSize(new Dimension(300, 300));
    destinations.setBorder(destBorder);
    destinations.setBackground(new Color(100, 150, 100));
    destListBox.setPreferredSize(new Dimension(287, 170));
    //The box was big enough on linux, but not on windows...
    destListBox.setFont(new Font("Arial", Font.PLAIN, 10));
    normMilesLabel.setPreferredSize(new Dimension(135, 25));
    normMilesField.setPreferredSize(new Dimension(150, 25));
    normMilesField.setEditable(false);
    ssMilesLabel.setPreferredSize(new Dimension(135, 25));
    ssMilesField.setPreferredSize(new Dimension(150, 25));
    ssMilesField.setEditable(false);
    upgradeCostLabel.setPreferredSize(new Dimension(135, 25));
    upgradeCostField.setPreferredSize(new Dimension(150, 25));
    upgradeCostField.setEditable(false);
    ssDateLabel.setPreferredSize(new Dimension(135, 25));
    ssDateField.setPreferredSize(new Dimension(150, 25));
    ssDateField.setEditable(false);
    
    //Redeem Miles
    mileBorder.setTitleJustification(TitledBorder.CENTER);
    redeemMiles.setPreferredSize(new Dimension(400, 300));
    redeemMiles.setBorder(mileBorder);  
    redeemMiles.setBackground(new Color(100, 100, 150));
    mileInputBox.setPreferredSize(new Dimension(180, 25));
    mileInputLabel.setPreferredSize(new Dimension(205, 25));
    monthSpinner.setPreferredSize(new Dimension(180, 25));
    ((JSpinner.DefaultEditor) monthSpinner.getEditor()).getTextField().setEditable(false);
    monthLabel.setPreferredSize(new Dimension(205, 25));
    redMilesButton.setPreferredSize(new Dimension(387, 30));
    redeemBox.setPreferredSize(new Dimension(387, 165));
    redeemBox.setEditable(false);
    redeemBox.setLineWrap(true);
    redeemBox.setWrapStyleWord(true);
    remMilesField.setPreferredSize(new Dimension(180, 25));
    remMilesField.setEditable(false);
    remMilesLabel.setPreferredSize(new Dimension(205, 25));
    
    
    //add elemetns
    
    //destinations
    destinations.add(destListBox);
    destinations.add(normMilesLabel);
    destinations.add(normMilesField);
    destinations.add(ssMilesLabel);
    destinations.add(ssMilesField);
    destinations.add(upgradeCostLabel);
    destinations.add(upgradeCostField);
    destinations.add(ssDateLabel);
    destinations.add(ssDateField);
    add(destinations);
    
    //Redeem Miles
    redeemMiles.add(mileInputLabel);                    
    redeemMiles.add(mileInputBox);
    redeemMiles.add(monthLabel);
    redeemMiles.add(monthSpinner);
    redeemMiles.add(redMilesButton);
    redeemMiles.add(redeemBox);
    redeemMiles.add(remMilesLabel);
    redeemMiles.add(remMilesField);
    add(redeemMiles);
    
    
    //attach handlers
    
    destListBox.addListSelectionListener(listHandel);
    redMilesButton.addActionListener(eventsHandel);
    
  }
  
  //Function for Prompting the user for a file
  
  private void buildDestList() {
    
    //InputDialog
    String fileName = (String) JOptionPane.showInputDialog(null,
                                                           "Enter a filename:",
                                                           "File Select",
                                                           JOptionPane.PLAIN_MESSAGE);
    
    //If Cancel was clicked, close the program
    if (fileName == null)
      System.exit(0);
    
    File file = new File(fileName);
    
    //Try to open file with fileName
    try {
      
      Scanner fileScan = new Scanner(file);
      miler.readDestinations(fileScan);
      
    } catch (IOException e) {
      
      //If file not found, show error and exit gracefully
      JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
    
    //Fill string array destNames for JList destListBox
    destNames = miler.getCityNames();
  }
  
  //function provided from:
  // https://docs.oracle.com/javase/tutorial/uiswing/examples/components/SpinnerDemoProject/src/components/SpinnerDemo.java
  protected String[] getMonthStrings() {
    String[] months = new java.text.DateFormatSymbols().getMonths();  
    
    int lastIndex = months.length - 1;
    
    if (months[lastIndex] == null || months[lastIndex].length() <= 0)  { 
      String[] monthStrings = new String[lastIndex];

      System.arraycopy(months, 0, monthStrings, 0, lastIndex);
      return monthStrings;
    } else { 
      return months;
    }
  }
  
  //ListSelectionLister for handling destListBox selection
  private class ListHandeler implements ListSelectionListener {
    
    @Override
    public void valueChanged(ListSelectionEvent event) {
      
      //Search for the destination with selected destination name
      Destination selDest = miler.findDestination(destNames[destListBox.getSelectedIndex()]);
      
      //Set Field values
      normMilesField.setText(Integer.toString(selDest.getNormalMiles()));
      ssMilesField.setText(Integer.toString(selDest.getFlyCheapMiles()));
      upgradeCostField.setText(Integer.toString(selDest.getFirstClassUpgrade()));
      
      //Set Field value and format the month
      ssDateField.setText(String.format("%s%s%s",
                                        months[selDest.getStartMonth()-1],
                                        " - ",
                                        months[selDest.getEndMonth()-1]));
    }
  }
  
  //ActionLister for Handling "Redeem Miles" button click
  private class EventsHandler implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent event) {
      
      if (event.getActionCommand() == "Redeem Miles") {
        
        //get input miles and selected month
        int customMiles = Integer.parseInt(mileInputBox.getText());
        String spinString = (String) monthSpinner.getValue();
        
        //find the index for the requested month
        int index = -1;
        for (int i = 0; i < months.length && index == -1; i++) {
          if (months[i] == spinString)
            index = i;
        }
        
        //Get applicable desinations 
        String[] appliDestn = miler.redeemMiles(customMiles, index+1);
        
        //output text based on applicable desinations 
        if (appliDestn.length != 0) {
          redeemBox.setText("Your client's Frequent Flyer Miles can be used to redeem the following tickets:\n");
          for (String destnPlus : appliDestn)
            redeemBox.append(destnPlus + "\n");
 
        } else {
          redeemBox.setText("*** Your client has not accumulated enough Frequent Flyer Miles ***");
        }
      }
      
      //set remMilesField to the remaining miles
      remMilesField.setText(Integer.toString(miler.getRemainingMiles()));
    }
  }
}