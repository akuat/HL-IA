/*†
 * Program name: List Maker
 */
import java.util.*;
import java.io.*;

public class ListMaker
{
  private String fileName;
  private static String vocabWords[];
  private static String vocabDefs[];
  public ListMaker(String file)
  {
    fileName = file;
  }
  public String[] readFile() throws IOException
  {
    Scanner fR = new Scanner(new File(fileName));
    int maxIndex = -1;
    String[] text = new String[10];
    
    while(fR.hasNext())
    {
      maxIndex++;
      text[maxIndex] = fR.nextLine();
    }
    fR.close();
    return text;
  }
  
  public void splitText(String text[])
  {
    int maxIndex = text.length - 1;
    
    vocabWords = new String[text.length];
    vocabDefs = new String[text.length];

    for(int j = 0; j<= maxIndex; j++)
    {
      if(text[j] == null)
        break;
      
      Scanner sc = new Scanner(text[j]);
      while(sc.hasNext())
      {
        if(text[j] == null)
          break;
        vocabWords[j] = sc.next();
        vocabDefs[j] = sc.nextLine();
      }
      sc.close();
    }
  }
  
  public String[] getWords()
  {
    return vocabWords;
  }
  public String[] getDefs()
  {
    return vocabDefs;
  }
}
  
    
