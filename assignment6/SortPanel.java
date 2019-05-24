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
||   This is the SortPanel class. It is an extended JPanel that  ||
||   Will display Graphics of sorting algorthms and show how     ||
||   each of them sort. The sorting algorithms use Concurrency   ||
||   so that the main thread isn't over encumbered.              ||
 \_______________________________________________________________/
*/

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class SortPanel extends JPanel {
  
  //Define Class vars
  
  private JButton popArr;
  private JButton sort;
  private JComboBox selSort;
  private String[] sortTypes;
  private SortAnimationPanel sortPanel;
  private ExecutorService executor;
  
  //Main Constuctor for making & placing items in a JPanel
  
  public SortPanel() {
    super(new FlowLayout(FlowLayout.CENTER, 2, 1));
    
    //Overall size of this JPanel
    
    setPreferredSize(new Dimension(445, 350));
    
    //Create new objects, handlers, and executors
    
    sortPanel = new SortAnimationPanel();
    sortTypes = new String[]{"Selection", "Bubble", "Heap"};
    popArr = new JButton("Populate Array");
    sort = new JButton("Sort");
    selSort = new JComboBox<String>(sortTypes);
    EventsHandler buttonH = new EventsHandler();
    executor = Executors.newCachedThreadPool();
    
    //Set Attributes of some objects
    
    sort.setEnabled(false);
    sortPanel.setPreferredSize(new Dimension(440, 300));
    sortPanel.setBackground(new Color(100, 150, 100));
    
    //Add all addable objects to this JPanel
    
    add(sortPanel);
    add(popArr);
    add(sort);
    add(selSort);
    
    //Attach Listeners to certain objects
    
    popArr.addActionListener(buttonH);
    sort.addActionListener(buttonH);
    
  }
  
  //Private inner class for Displaying contents of an array,
  //Then sorting the array
  
  private class SortAnimationPanel extends JPanel implements Runnable {
    
    //Define Class Vars
    
    private int[] sortable;
    public int sortNo = 0;
    
    //Default constructor, Assists with placement on main JPanel
    
    public SortAnimationPanel() {
      super(new FlowLayout(FlowLayout.LEADING, 2, 1));
    }
    
    //Populate this class's private int array
    //The size of int array is based on this panel's width (400)
    //while the range of values is based on this panel's heigth (300)
    
    public void populateArr() {
      sortable = new int[440];
      Random rand = new Random(System.currentTimeMillis());
      for (int i = 0; i < sortable.length; i++)
        sortable[i] = rand.nextInt(300);
    }
    
    //Selection sort
    
    private void selectionSort() throws InterruptedException {
      
      int hold, min, n = sortable.length;
      
      for (int i = 0; i < n-1; i++) {
        
        min = i;
        
        for (int j = i+1; j < n; j++) {
          if (sortable[j] < sortable[min])
            min = j;
        }
        
        if (min != i) {
          hold = sortable[i];
          sortable[i] = sortable[min];
          sortable[min] = hold;
        }
        
        repaint();
        //The 'recommended' time of 100ms was too slow...
        Thread.sleep(25);
      }
    }
    
    //Bubble Sort
    
    private void bubbleSort() throws InterruptedException {
      
      int hold, n = sortable.length;
      boolean swapped;
      
      do {
        
        swapped = false;
        
        for (int i = 1; i <= n-1; i++) {
          
          if (sortable[i-1] > sortable[i]) {
            hold = sortable[i-1];
            sortable[i-1] = sortable[i];
            sortable[i] = hold;
            swapped = true;
          }
          
        }
        
        repaint();
        //The 'recommended' time of 100ms was too slow...
        Thread.sleep(25);
        
      } while (swapped);
    }
    
    //Heap Sort (Code/Logic reused from csci340 assign 7)
    
    private void heapSort() throws InterruptedException {
       
      //build heap
      for (int root = sortable.length - 1; root > 0; root--)
         heapify(sortable.length-1, root);
      
      //Conduct the sort on the now heapified int array
      int i = sortable.length - 1;
      while (i > 0) {
        int hold = sortable[0];
        sortable[0] = sortable[i];
        sortable[i] = hold;
        heapify(--i, 0);
      }
    }
    
    //(Code/Logic reused from csci340 assign 7)
    //Used to build a heap based on this class's int array
    //int len: Logical size of current heap
    //int root: current root of logical tree/subtree
    
    private void heapify(int len, int root) throws InterruptedException {
      
      if ((2*root) == len){ //There is only 1 child
        
        if (sortable[2*root] > sortable[root]) {
          int hold = sortable[2*root];
          sortable[2*root] = sortable[root];
          sortable[root] = hold;
          heapify(len, 2*root);
        }
        
      } else if ((2*root + 1) < len) { //There are two children
        
        if (sortable[2*root] > sortable[2*root + 1]) {
          
          if (sortable[2*root] > sortable[root]) { 
            int hold = sortable[2*root];
            sortable[2*root] = sortable[root];
            sortable[root] = hold;
            heapify(len, 2*root);
          }
          
        } else {
          
          if (sortable[2*root + 1] > sortable[root]) {
            int hold = sortable[2*root + 1];
            sortable[2*root + 1] = sortable[root];
            sortable[root] = hold;
            heapify(len, 2*root+1);
          }
          
        }
        
      }
      
      repaint();
      //Since heapify is called recursivly, sleep is set to a lower number
      Thread.sleep(5);
    }
    
    //Draw the elements of this class's array on this JPanel
    
    @Override
    public void paintComponent(Graphics g) {  
      super.paintComponent(g);
      this.setBackground(Color.WHITE);
      
      g.setColor(Color.BLUE);
      if (sortable != null) {
        for (int i = 0; i < sortable.length; i++)
          g.drawLine(i, (300 - sortable[i]), i, 300);
      }
    }
    
    //Conduct a sort when execute is called
    //re-enables the "Populate Array" button
    
    @Override
    public void run() {
      try {
        switch(sortNo) {
          case 0: selectionSort();
                  break;
          case 1: bubbleSort();
                  break;
          case 2: heapSort();
                  break;
        }
        
        popArr.setEnabled(true);
      } catch (InterruptedException exception) {
        exception.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
  }
  
  //Event handler for buttons
  
  private class EventsHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
      if (event.getActionCommand() == "Populate Array") {
        
        //Initalize array and draw it
        sortPanel.populateArr();
        sortPanel.repaint();
        
        //Toggle buttons
        popArr.setEnabled(false);
        sort.setEnabled(true);
      } else {
        
        //Get what the JComboBox was on and set a var in SortPanel
        sortPanel.sortNo = selSort.getSelectedIndex();
        
        //Execute the run() statement; sorts sortPanel's int array
        executor.execute(sortPanel);
        
        //Disable Sort button
        sort.setEnabled(false);
      }
    }
  }
}