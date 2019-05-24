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
||    This is the EventsFrame class. It will create a new frame  ||
||    that contains a box and clickable elements with event      ||
||    handlers attached.                                         ||
 \_______________________________________________________________/
*/

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JList;

public class EventsFrame extends JFrame {
  
  //Private data members
  
  private JRadioButton selMe;
  private JList listBox;
  private JComboBox animalBox;
  private JButton clearButton;
  private JTextArea mainBox;
  private static final String[] animals = {"Elephant", "Rhinoceros", "Lion", "Hippopotamus" };
  
  //Constructor that does all the work
  
  public EventsFrame() {
    super("Events");
    
    //No resize
    
    setResizable(false);
    
    //Create new objects and handlers
    
    setLayout(new FlowLayout());
    mainBox = new JTextArea();
    animalBox = new JComboBox<String>(animals);
    selMe = new JRadioButton("Select Me");
    listBox = new JList<String>(animals);
    clearButton = new JButton("Clear");
    EventsHandler handle = new EventsHandler();
    RadioButtonHandler rHandle = new RadioButtonHandler();
    
    //Set attributes for listBox & mainBox
    
    listBox.setVisibleRowCount(4);
    mainBox.setPreferredSize(new Dimension(420, 250));
    mainBox.setEditable(false);
    mainBox.setLineWrap(true);
    mainBox.setWrapStyleWord(true);
    
    //Add elements to the frame
    
    add(mainBox);
    add(animalBox);
    add(selMe);
    add(new JScrollPane(listBox));
    add(clearButton);
    
    //Attach event handlers to buttons
    
    clearButton.addActionListener(handle);
    selMe.addItemListener(rHandle);
    
    //Attach and create an event handle to the list
    
    listBox.addListSelectionListener(
       new ListSelectionListener()
       {
          @Override
          public void valueChanged(ListSelectionEvent event)
          {
             String holder = "Un-Clicked";
             if (event.getValueIsAdjusting() == true)
                holder = "Clicked";
             mainBox.setText(String.format("You %s: %s from the List\n%s", holder, animals[listBox.getSelectedIndex()], event.toString()));
          }
        }
     );
    
    //Attach and create an event handle to the dropdown box
    
    animalBox.addItemListener(
      new ItemListener()
         {
             @Override
             public void itemStateChanged(ItemEvent event)
             {
                if (event.getStateChange() == ItemEvent.SELECTED)
                   mainBox.setText(String.format("You Selected: %s from the Dropdown Box\n%s", animals[animalBox.getSelectedIndex()], event.toString()));
             }
         }
    );
  }
  
  //Event handler for Clear button
  
  private class EventsHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
      if (event.getActionCommand() == "Clear")
         mainBox.setText("");
    }
  }
  
  //Event handler for RadioButton
  
  private class RadioButtonHandler implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent event) {
      if (event.getStateChange() == ItemEvent.SELECTED)
         mainBox.setText(String.format("You Selected the Radio button\n%s", event.toString()));
      else 
         mainBox.setText(String.format("You Unselected the Radio button\n%s", event.toString()));
    }
  }
}