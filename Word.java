/*†
 * Program name: Word
 * Student name: Akua Tenkorang
 * IB Honor Code: I have neither given nor received help on this assignment, nor am I aware of any violation of the IB Honor Code.
 */
//import java.util.*;
//import java.io.*;

public class Word
{
 
  public static String chooseWord(String[] vWords)
  {
      int idx = (int)(Math.random() * (vWords.length));
      String currWord = vWords[idx];
      return currWord;
  }
  
  public static int getIndex(String[] vWords, String word)
  {
    int index = 0;
    for(int x = 0; x < vWords.length; x++)
    {
      if(vWords[x].equals(word))
      {
        index = x;
        break;
      }
      
    }
    return index;
  }
  
 
  public static void displayDef(int idxOfWord, String[] defs)
  {
    System.out.println(defs[idxOfWord]);
  }
}
  