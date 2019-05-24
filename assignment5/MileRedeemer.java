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
||   This is the Mile Redeemer class for this package. This will ||
||   handle all allocation of new arrays for destinations and    ||
||   process destinations a client can go to. The main array for ||
||   this class will hold an array of Destination class objects. ||
 \_______________________________________________________________/
*/
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;


public class MileRedeemer implements Comparator<Destination> {
  
  private Destination[] destinationArray;
  private int mileCount = 0;
  
  public void readDestinations(Scanner fileScan) throws IOException {
     String inpLine = "";
     ArrayList<Destination> destList = new ArrayList<Destination>();
     
     while (fileScan.hasNextLine()) {
       inpLine = fileScan.nextLine();
       Destination hold = new Destination(inpLine);
       destList.add(hold);
     }
     destinationArray = (Destination[]) destList.toArray(new Destination[destList.size()]);
     Arrays.sort(destinationArray, this);
  }
  
  public String[] getCityNames() {
    String[] rv = new String[destinationArray.length];
    short counter = 0;
    for (Destination holder : destinationArray) {
      rv[counter] = holder.getDestinationName();
      counter++;
    }
    Arrays.sort(rv);
    return rv;
  }
  public String[] redeemMiles(int miles, int months) {
    mileCount = miles;
    boolean flyC = false;
    String[] rv;
    
    //Assuming that ArrayList.add() will sequentially place new objects
    
    ArrayList<String> finalDestination = new ArrayList<String>();
    
    //There might be a more efficent way...?
    
    int[] upgrdCost = new int[destinationArray.length];
    int placeHold = 0;
    
    //Figure out what destinations we can go to
    
    for (Destination destn : destinationArray) {
      
      flyC = (destn.getStartMonth() <= months && destn.getEndMonth() >= months);
      
      if (flyC) {
        
        if (destn.getFlyCheapMiles() <= mileCount) {
          finalDestination.add(destn.getDestinationName());
          upgrdCost[placeHold] = destn.getFirstClassUpgrade();
          placeHold++;
          mileCount -= destn.getFlyCheapMiles();
        }
        
      } else {
        
        if (destn.getNormalMiles() <= mileCount) {
          finalDestination.add(destn.getDestinationName());
          upgrdCost[placeHold] = destn.getFirstClassUpgrade();
          placeHold++;
          mileCount -= destn.getNormalMiles();
        }
        
      }
    }
    rv = finalDestination.toArray(new String[finalDestination.size()]);
    
    //figure out if we can upgrade any flights & format output string
    
    for (int i = 0; i < placeHold; i++) {
      if (upgrdCost[i] <= mileCount) {
        mileCount -= upgrdCost[i];
        rv[i] = "* A trip to " + rv[i] + " in First Class";
      } else {
        rv[i] = "* A trip to " + rv[i] + " in Economy Class";
      }
    }
    
    return rv;
  }
  
  public int getRemainingMiles() {
    return mileCount;
  } 
  
  public Destination findDestination(String cityName) {
    Destination rv = null;
    
    //Search thru each destination
    for (Destination destn : destinationArray) {
      
      if (destn.getDestinationName() == cityName) {
        rv = destn;
        
        //exit loop if the destination was found
        break;
      }
    }
    return rv;
  }
  
  public int compare(Destination dest1, Destination dest2) {
    return (dest2.getNormalMiles() - dest1.getNormalMiles());
  }
}