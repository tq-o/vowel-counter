import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class VowelCounterTest {//expected, actual

   VowelCounter counter;
   int count;
   
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
       counter = new VowelCounter();
   }
   
   /** Test count initializations. **/
   
   @Test public void initCountATest() {
      count = counter.getCountA(); 
      assertEquals("Test 1: Count A initialization.", 0, count);
   }
   
   @Test public void initCountETest() {
      count = counter.getCountE(); 
      assertEquals("Test 2: Count E initialization.", 0, count);
   }
   
   @Test public void initCountITest() {
      count = counter.getCountI(); 
      assertEquals("Test 3: Count I initialization.", 0, count);
   }
   
   @Test public void initCountOTest() {
      count = counter.getCountO(); 
      assertEquals("Test 4: Count O initialization.", 0, count);
   }
   
   @Test public void initCountUTest() {
      count = counter.getCountU(); 
      assertEquals("Test 5: Count U initialization.", 0, count);
   }

   @Test public void initCountUserCharTest() {
      count = counter.getUserCharCount(); 
      assertEquals("Test 6: Count userChar initialization.", 0, count);
   }
   
    @Test public void initCharCountTest() {
      count = counter.getTotalCharCount(); 
      assertEquals("Test 7: Character count initialization.", 0, count);
   }

   @Test public void initUserCharTest() {
      char userChar = counter.getUserChar(); 
      assertEquals("Test 8: User character default initialization.", Character.MIN_VALUE, userChar);
   }
   
   @Test public void initUserCharSetTest() {
      boolean actualBool = counter.userCharSet(); 
      assertEquals("Test 9: Has user character default initialization.", false, actualBool);
   }
   
   /** processLine tests **/
   
   @Test public void emptyProcLineTest() {
      counter.processLine(""); 
      count = counter.getTotalCharCount(); 
      assertEquals("Test 10: Char count on zero length line.", 0, count);
   }  
   
   @Test public void incrementLineCtProcLineTest() {
      counter.processLine("test");
      count = counter.getTotalCharCount(); 
      assertEquals("Test 11: Line count increments correctly.", 4, count);
   }  
   
   @Test public void countAProcLineTest() {
      counter.processLine("As the TA said, let's all be happy."); 
      count = counter.getCountA();
      assertEquals("Test 12: Count A increments correctly.", 5, count);
   }
   
   @Test public void countEProcLineTest() {
      counter.processLine("Everybody expects a nice evening."); 
      count = counter.getCountE();
      assertEquals("Test 13: Count E increments correctly.", 7, count);
   }
   
   @Test public void countIProcLineTest() {
      counter.processLine("I'm instantiating a very interesting class."); 
      count = counter.getCountI();
      assertEquals("Test 14: Count I increments correctly.", 6, count);
   }
   
   @Test public void countOProcLineTest() {
      counter.processLine("Who doesn't object to observing Object-oriented programers at work?."); 
      count = counter.getCountO();
      assertEquals("Test 15: Count O increments correctly.", 9, count);
   }
   
   @Test public void countUProcLineTest() {
      counter.processLine("Usually, ululating Ural owls roost under the cedar boughs."); 
      count = counter.getCountU();
      assertEquals("Test 16: Count U increments correctly.", 7, count);
   }
   
   /* multiple process line tests */
   
   @Test public void vowelMultipleProcLineTest() {
      int[] correctCts = {9,7,7,4,2};
      int[] studentCts = new int [5]; 
      counter.processLine("You are getting practice with conditionals.");
      counter.processLine("Please, call me a taxi.");
      counter.processLine("You're a taxi!");
      studentCts[0] = counter.getCountA();
      studentCts[1] = counter.getCountE();
      studentCts[2] = counter.getCountI();
      studentCts[3] = counter.getCountO(); 
      studentCts[4] = counter.getCountU();
      assertArrayEquals("Test 17: Vowel counts on multiple lines.", correctCts, studentCts);
   }   
   
   /* more proc line tests */
   
   @Test public void vowelProcLineTest1() {
      int[] correctCts = {3,2,2,2,2};
      int[] studentCts = new int [5]; 
      counter.processLine("AeIoUaOEuai");
      studentCts[0] = counter.getCountA();
      studentCts[1] = counter.getCountE();
      studentCts[2] = counter.getCountI();
      studentCts[3] = counter.getCountO(); 
      studentCts[4] = counter.getCountU();
      assertArrayEquals("Test 18: Line count increments.", correctCts, studentCts);
   } 
   
   @Test public void vowelProcLineTest2() {
      int[] correctCts = {3,2,2,2,2};
      int[] studentCts = new int [5]; 
      counter.processLine("AeIoUaOEuai");
      studentCts[0] = counter.getCountA();
      studentCts[1] = counter.getCountE();
      studentCts[2] = counter.getCountI();
      studentCts[3] = counter.getCountO(); 
      studentCts[4] = counter.getCountU();
      assertArrayEquals("Test 19: Line count increments.", correctCts, studentCts);
   }
 
    /* Test if user character gets set */
   @Test public void setUserCharTest() {
      char testChar = 'm';
      String testCharStr = "m";
      counter.setUserChar(testCharStr);
      char userChar = counter.getUserChar(); 
      assertTrue("Test 20: User character was set correctly.", Character.toLowerCase(userChar) == testChar);
   }
   
   @Test public void setUserCharNonAlphaTest() {
      char testChar = '!';
      String testCharStr = "!";
      counter.setUserChar(testCharStr);
      char userChar = counter.getUserChar(); 
      assertTrue("Test 21: User character was set correctly.", userChar == testChar);
   }
   
   @Test public void setUserCharNumberTest() {
      char testChar = '9';
      String testCharStr = "9";
      counter.setUserChar(testCharStr);
      char userChar = counter.getUserChar(); 
      assertTrue("Test 22: User character was set correctly.", userChar == testChar);
   }
   
   @Test public void setHasUserCharTest() {
      counter.setUserChar("M");
      boolean actualBool = counter.userCharSet(); 
      assertEquals("Test 23: Has user character boolean set correctly.", true, actualBool);
   } 
   
   @Test public void countUserCharProcLineTest() {
      counter.setUserChar("m");
      counter.processLine("Mostly, I do mind if you mention logical operators."); 
      count = counter.getUserCharCount();
      assertEquals("Test 24: User char increments correctly.", 2, count);
   } 
   
   @Test public void countUserCharProcLineTest1() {
      counter.setUserChar("M");
      counter.processLine("Mostly, I do mind if you mention logical operators."); 
      count = counter.getUserCharCount();
      assertEquals("Test 25: User char increments correctly.", 1, count);
   } 
   
   @Test public void countUserCharProcLineTest2() {
      counter.setUserChar("m");
      counter.processLine("Mostly, I do mind if you mention logical operators."); 
      count = counter.getUserCharCount();
      assertEquals("Test 26: User char increments correctly.", 2, count);
   }
   
   @Test public void countUserCharProcLineTest3() {
      counter.setUserChar("#");
      counter.processLine("If you dial # you mean # not ###."); 
      count = counter.getUserCharCount();
      assertEquals("Test 27: User char increments correctly.", 5, count);
   } 

   
}
