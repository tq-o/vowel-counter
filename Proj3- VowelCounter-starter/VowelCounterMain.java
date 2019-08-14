import java.util.Scanner;
/* This class runs a console interface between a user and 
 * a VowelCounter object.
*/
public class VowelCounterMain {
       
   public static void main(String[] args){
       
      System.out.println("Vowel Counter");
      Scanner scan = new Scanner(System.in);     
      VowelCounter counter = new VowelCounter();
      boolean keepGoing = true;
      String inputStr = "";

      while(keepGoing) {
         System.out.println("Main Menu:");
         System.out.println("Enter A to add a special character to be counted."); 
         System.out.println("Enter E to enter a line of text.");  
         System.out.println("Enter P to print the report.");  
         System.out.println("Enter X to quit.");
         System.out.println("");
         inputStr = scan.nextLine();
              
         if (inputStr.equalsIgnoreCase("E")){
            System.out.println("Enter a line of text: ");
            inputStr = scan.nextLine();
            counter.processLine(inputStr);
         }
         else if (inputStr.equalsIgnoreCase("A")){
            System.out.println("Enter a single character to count.");
            String userCharStr = scan.nextLine();
            counter.setUserChar(userCharStr);
         }              
         else if (inputStr.equalsIgnoreCase("P")){
            printReport(counter);    
         }              
         else if(inputStr.equalsIgnoreCase("X")){
            keepGoing = false;
         }
         else
            System.out.println("Unrecognized input.");
         System.out.println("");               
      }
      System.out.println("Bye for now.");
      scan.close();
   }
   
   /* Using the data stored in a VowelCounter object, this method prints a report 
    * of all vowel and special character counts.
    * The counts as a percentage of the total character count are also printed.
   */ 
   public static void printReport(VowelCounter counter){
      System.out.println("Frequency Report:");
      System.out.println("A count: "+counter.getCountA());
      System.out.println("E count: "+counter.getCountE());
      System.out.println("I count: "+counter.getCountI());
      System.out.println("O count: "+counter.getCountO());
      System.out.println("U count: "+counter.getCountU());
      if(counter.userCharSet())
         System.out.println(""+counter.getUserChar()+" count: "+counter.getUserCharCount());
      System.out.println(counter.getTotalCharCount()+" total characters counted.");
      int totalCharCount = counter.getTotalCharCount();
      System.out.printf("%n");
      if(totalCharCount>0){
         System.out.printf("percent A: %4.2f%n",(counter.getCountA()/(double)totalCharCount)*100);
         System.out.printf("percent E: %4.2f%n",(counter.getCountE()/(double)totalCharCount)*100);
         System.out.printf("percent I: %4.2f%n",(counter.getCountI()/(double)totalCharCount)*100);
         System.out.printf("percent O: %4.2f%n",(counter.getCountO()/(double)totalCharCount)*100);
         System.out.printf("percent U: %4.2f%n",(counter.getCountU()/(double)totalCharCount)*100);
         if(counter.userCharSet()){
            System.out.print("percent "+counter.getUserChar());
            System.out.printf(": %4.2f%n",(counter.getUserCharCount()/(double)totalCharCount)*100);
         }  
      }
   } 
}