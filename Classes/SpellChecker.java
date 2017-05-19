import java.util.Scanner;
import java.io.*;

/*
 * This class implements a spell checker application. 
 */
public class SpellChecker {

  public static void main(String [] args) {

    File f = new File("../input/dictionary");
    
    try {
      Scanner sk = new Scanner(f);
        
      StringSet x = new StringSet();
    
      // Read in the entire dictionary...
      while (sk.hasNext()) {
        String word = sk.next();
        x.insert(word);      
      }
      System.out.println("Dictionary loaded...");
     
      sk = new Scanner(System.in);
      
      // Keep suggesting alternatives as long as the user makes an input.
      while (sk.hasNext()) {
        String word = sk.next();
        if (x.find(word)) {
	         System.out.println(word + " is correct.\n");
        }
        else {
          boolean found = false;
	        System.out.println("Suggesting alternatives ...");
          for (int i = 0; i < word.length(); i++){
            char ch = 'a';
            while (ch <= 'z'){
              String newWord;
              char[] newWordChars = word.toCharArray();
              newWordChars[i] = ch;
              newWord = String.valueOf(newWordChars);
              if (x.find(newWord) && !newWord.equals(word)){
                System.out.println(newWord);
                found = true;
              }
              ch++;
            }
          }
          if (!found)
            System.out.println("Not found.");
          System.out.println();
		    }
      }
 

    } 
    catch (FileNotFoundException e) {
      System.out.println("Cannot open file " + f.getAbsolutePath());
      System.out.println(e);
    } 

  } 

}
