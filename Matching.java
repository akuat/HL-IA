import java.util.ArrayList;
public class Matching extends Word
{
  ArrayList<String> usedWords = new ArrayList<String>();
  ArrayList<String> usedDefs = new ArrayList<String>();
  public Matching()
  {
  }
  public void displayWordsAndDefs(String[] words, String[] defs) //displays words to be matched with definitions
  {
    usedWords.add("*disregard*");
    usedDefs.add("*disregard*");
    for(int i=1; i<=words.length; i++)
    {
      String uWord = Word.chooseWord(words);
      while(usedWords.indexOf(uWord) != -1)
      {
        uWord = Word.chooseWord(words);
      }
      usedWords.add(uWord);
      System.out.print(i + ". " + uWord + "    ");
    }
    System.out.println();
    for(int i=1; i<=defs.length; i++)
    {
      String uDef = Word.chooseWord(defs);
      while(usedDefs.indexOf(uDef) > -1)
      {
        uDef = Word.chooseWord(defs);
      }
      usedDefs.add(uDef);
      System.out.println(i + ". " + uDef); 
    }
  }

  public int checkUserInput(int[] a, String[] words, String[] definitions)
  {
    int wIdx = 0;
    int dIdx = 0;
    for(int j = 0; j < a.length; j++)
    {
      for(int w = 0; w < words.length; w++)
      {
        if(words[w].equals(usedWords.get(j+1)))
        {
          wIdx = w;
          break;
        }  
      }
      for(int d = 0; d < definitions.length; d++)
      {
        if(definitions[d].equals(usedDefs.get(j+1)))
        {
          dIdx = d;
          break;
        }
      }
      if(wIdx != dIdx)
      {
        return 0;
      }
    }
    
    return 1;
      
  }
}
  
  
