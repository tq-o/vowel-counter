/* This class counts the occurances of the vowels, i.e. characters: A,a,E,e,I,i,O,o,U,u. 
 * The vowel counts are case-insensitive.
 * For example, 'A' and 'a' are both counted as the same character.
 * Users may add a specific character, any letter or punctuation mark, of their choice to be counted. 
 * The user-specified character is optional, and if that option has been requested, the count 
 * is case-sensitive.
 * By default, the user character is initialized to the minimum possible char value by referencing
 * the public constant MIN_VALUE in the Character class. However, the method userCharSet returns false
 * unless the user character has been requested- by a call to setUserChar.
 * The count of all characters is also maintained. Note that space charcters are counted.
 * The current counts are provided on demand by "get" methods.
 */

public class VowelCounter {
     // the user-specific character.
     private char userChar;
     private int countA;
     private int countE;
     private int countI;
     private int countO;
     private int countU;
     private int countTotal;
     private int countCharUser;
     
     
     
     
   // TODO: Declare any other member variables (private) below.
     

    /* Constructor, where all variables are initialized to default values.
     */
   public VowelCounter(){
     //default value for user char- this is just a placeholder.
     userChar = Character.MIN_VALUE;
     countA = 0;
     countE = 0;
     countI = 0;
     countO = 0;
     countU = 0;
     countTotal = 0;
     countCharUser = 0;
     
   //TODO: initialize the other variables you have declared.
 
   }
    
    /* This method counts the vowels in a line of text passed in.
     * It also checks if a user-specified character has been set and will
     * count any occurences of that character.
     * This method also updates the total number of characters, including spaces,
     * that have been processed. 
     * Note that no counts are incremented if the line passed in has zero length. 
     */
   public void processLine(String line) {
   //TODO: implement this method.
     countTotal = line.length(); 
     if (countTotal ==0) 
         System.out.print("The line passed in has zero length");
     else {
         for (int i=0 ; i<countTotal ; i++) {
            if (line.charAt(i)== 'a' || line.charAt(i)== 'A'){
               countA += 1;
               
               }
            if (line.charAt(i)== 'e' || line.charAt(i)== 'E'){
               countE += 1;
               
               }
            if (line.charAt(i)== 'U' || line.charAt(i)== 'u'){
               countU += 1;
               
               }
            if (line.charAt(i)== 'i' || line.charAt(i)== 'I'){
               countI += 1;
               
               }
            if (line.charAt(i)== 'o' || line.charAt(i)== 'O'){
               countO += 1;  
               
               }
            if (line.charAt(i)== userChar) {  
               countCharUser += 1;
               }

            
         }
     }
             
   }
    
    /* This method allows a user to set an arbitrary character to be counted.
     * This character is treated as case sesitive. 
     * The user's character is passed in as a String, which is converted
     * to a single char data type.
     */ 
    public void setUserChar(String userCharStr) {
    //TODO: implement this method.
       userChar = userCharStr.charAt(0);
        
      
         
      
    }
    
    /* Returns true if the user has set a special character to count,
     * false otherwise.
     */
    public boolean userCharSet(){
    //TODO: implement this method.
       if (userChar >= 'A' && userChar <= 'z')
         return true;
       else
         return false;
    }

    /* Returns the user-specified character.  */    
    public char getUserChar(){
    //TODO: implement this method.
       return userChar;
    }
    
    /* Returns the count of vowel A.  */ 
    public int getCountA(){
    //TODO: implement this method.
       return countA;
    }
    
    /* Returns the count of vowel E.  */ 
    public int getCountE(){
    //TODO: implement this method.
       return countE;
    }
    
    /* Returns the count of vowel I.  */ 
    public int getCountI(){
    //TODO: implement this method.
       return countI;
    }
    
    /* Returns the count of vowel O.  */ 
    public int getCountO(){
    //TODO: implement this method.
       return countO;
    }
    
    /* Returns the count of vowel U.  */ 
    public int getCountU(){
    //TODO: implement this method.
       return countU;
    }
    
    /* Returns the count of all characters processed.  */ 
    public int getTotalCharCount(){
    //TODO: implement this method.
       return countTotal;
    }
    
    /* Returns the count of the user's character.  */ 
    public int getUserCharCount(){
    //TODO: implement this method.
       return countCharUser;
    }
}