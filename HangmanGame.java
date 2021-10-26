import java.util.*;
public class HangmanGame extends Word
{
  public int currLives = 0;
  private StringBuffer empCurrWord;
  private ArrayList<Character> guessedLetters = new ArrayList<Character>();
  private final int MAX_LIVES = 6;
  private String currWord = "";
  
  public HangmanGame(String cWord)
  {
    currWord = cWord;
    currLives = 0;
  } 
  public void allotSpaces()
  {
    int len = currWord.length();
    char[] sp = new char[len];
    for(int g = 0; g < len ; g++)
      sp[g] = '-';
    String spaces = new String(sp);
    empCurrWord = new StringBuffer(spaces);
    System.out.println("\t" + empCurrWord.toString());
  }
 
  public int checkInput(char i)
  {
    currWord = currWord.toLowerCase();
    if(currWord.indexOf(i) == -1) //Verifies if a guessed letter is in the current word
    {
      currLives++;
      return -1;
    }
    if(guessedLetters.indexOf(i) != -1) //Accounts for previously guessed letters
      return 0;
    if(currWord.indexOf(i) > -1)
      return 1;
    return 1;
  }
  
  public void fillInLetters(char i)
  {
    guessedLetters.add(i);
    int idx = currWord.indexOf(i);
    String tempI = i + "";
    empCurrWord = empCurrWord.replace(idx,idx+1,tempI);  //Replaces "_" with correctly guessed letter
    while(currWord.indexOf(i,idx+1) != -1) //Accounts for multiple occurences of a guessed letter
    {
      int addIdx = currWord.indexOf(i,idx+1);
      empCurrWord = empCurrWord.replace(addIdx,addIdx+1, tempI); 
    }
    System.out.println(empCurrWord.toString());
  }
 
  public int getGameStatus()
  {
    String s = empCurrWord.toString();
    if(s.equalsIgnoreCase(currWord))
       return 1;
    if(currLives >= MAX_LIVES)
      return -1;
    return 0;
  }
  
  
}
  
  
    

  