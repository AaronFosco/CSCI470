/*
  _______________________________________________________________
 /                                                               \
||  Course: CSCI-470     Inclass #: 2    Semester: Summer 2018   ||
||                                                               ||
||  NAME:  Aaron Fosco    Z-ID: z1835687     Section: 1          ||
||                                                               ||
||                                                               ||
||  Due: Thursday 6/28/2018 by 10:15AM                           ||
||                                                               ||
||  Description:                                                 ||
||    This program reads a line from the user and checkes to see ||
||    if the identifer is valid                                  ||
 \_______________________________________________________________/
*/
import java.io.*;

public class CheckIdentifiers
{
 public static void main(String[] args) throws IOException
 { 
   boolean end = false;
   int ihold;
   char hold;
   String ident = "";
   System.out.println("Please enter a vaild java identifier: ");
   ihold = System.in.read();
   hold = (char) ihold;
   if (ihold == -1)
   {
       System.out.println("At least one character is needed!"); 
       end = true;
   } else if (! Character.isLetter(hold) && ! Character.isDigit(hold) && ! (hold == '$') && ! (hold == '_'))
   { 
     System.out.println("Illegal first character: " + hold);
     end = true;
   } else
   {
     ident += hold;
   }
   while (end != true)
   {
     ihold = System.in.read();
     hold = (char) ihold;
     ident += (ihold == -1) ? "" : hold;
     if (ihold == -1 || ihold == 10)
     {
       end = true;
     } else if (! Character.isLetter(hold) && ! Character.isDigit(hold) && ! (hold == '$') && ! (hold == '_'))
     { 
       System.out.println("Illegal character: " + hold);
       end = true;
     }
   }
   System.out.println("You entered: " + ident);
 }  
}