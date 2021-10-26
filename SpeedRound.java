import java.util.ArrayList;
import java.util.Scanner;
public class SpeedRound extends Matching
{
  private String cWord;
  private int points;
  private static ArrayList<Integer> indices = new ArrayList<Integer>();
  private static ArrayList<Integer> wrongAns = new ArrayList<Integer>();
  public SpeedRound()
  {
    points = 0;
  }
  
  public static String chooseWord(String[] vWords)
  {
      int idx = (int)(Math.random() * (vWords.length));
      while(indices.indexOf(idx)!= -1)
      {
        idx = (int)(Math.random() * (vWords.length));
      }
      String currWord = vWords[idx];
      return currWord;
  }
    
    
  public void isCorrect(String answer, String word, int i) //entered word, correct word
  {
    cWord = word;
    if(answer.equalsIgnoreCase(cWord))
      points++;
    else
    {
      if(points > 0)
         points--;
      wrongAns.add(i);
    }
  }
  
  public void displayPoints()
  {
    System.out.println("\nPoints: " + points);                    
  }
  
  public void addIndex(int idx)
  {
    indices.add(idx);
  }
  
  public char getResult()
  {
    Scanner kb = new Scanner(System.in);
    int grade = points * 10;
    int missedWords = 10 - points;
    if(grade >= 70 && grade < 100)
    { 
      System.out.println("Congratulations! You passed this speed round with a score of " + grade + "% .");
      System.out.print("\n\nWould you like to review the answers you missed? Enter Y for yes, N for no:");
      String r = kb.nextLine();
      char c = r.charAt(0);
      return c;
    }
    else if(grade == 100)
    {
      System.out.println("WOOHOO! You got a perfect score of 100% on this speed round!! Way to go!");
      return 'n';
    }
    else
    {
      System.out.println("You failed this round with " + grade + "% ." + "\nYou missed " + missedWords + " words.");
      System.out.print("\n\nWould you like to review the answers you missed? Enter Y for yes, N for no:");
      String r = kb.nextLine();
      char c = r.charAt(0);
      return c;
    }
  }
  
  public void reviewAnswers(String[] words, String[] definitions)
  {
    for(int i = 0; i < wrongAns.size(); i++)
    {
      int wa = wrongAns.get(i);
      System.out.println(definitions[wa] + ": " + words[wa]);
    }
  }  
}

  