import java.util.Scanner;
import java.io.*;
public class 
StudyBuddyTester
{
  public static void main(String args[]) throws IOException
  {
   char l = '1';
   Scanner kb = new Scanner(System.in);
   boolean isException = false;
   int choice = 0;
   do
   {
     System.out.println("Hello, Welcome to the StudyBuddy! Would you like to study for English or Science?\n");
     System.out.println(" 1. English \t 2. Environmental Science");
     do
     {
       try
       {
         System.out.print("\nPlease enter the number beside your choice: ");
         isException = false;
         choice = kb.nextInt(); 
         if(choice != 1 && choice !=2)
         {
           System.out.print("Please only enter a '1' or '2'.");
         }
       }
       catch(Exception e)
       {
         System.out.print("Please enter a '1' or '2'.");
         isException = true;
       }
       kb.nextLine();
     }while(isException == true || choice != 1 && choice != 2);
     
     System.out.println("These are the three game modes: \n1.Hangman          2.MatchMaster \t 3.SpeedRound \n");
     System.out.print("Would you like to see the description each game? Enter '1' yes or '2' for no:");
     do
     {
       try
       {
         isException = false;
         choice = kb.nextInt(); 
         if(choice != 1 && choice !=2)
         {
           System.out.print("Please only enter a '1' or '2'.");
         }
       }
       catch(Exception e)
       {
         System.out.print("Please enter a '1' or '2'.");
         isException = true;
       }
       kb.nextLine();
     }while(isException == true || choice != 1 && choice != 2);
     
     if(choice == 1)
     {
       System.out.println("\nHangman: You will be presented with a definition, and you must guess the vocab word\n\tby entering the letters it contains individually.\n\tIf you guess 6 letters wrong, you will lose that round.\n");
       System.out.println("MatchMaster: You will be given a number of randomized words and definitions\n\tand you must enter the number of the definition that matches your word.\n");
       System.out.println("SpeedRound: You will be given a definition and must the enter the word with that definition as fast as you can.\n");
     }
     
     System.out.println("Which game would you like to play?\n");
     System.out.println(" 1. Hangman \t 2. MatchMaster \t 3.SpeedRound");
     do
     {
       try
       {
         System.out.print("\nPlease enter the number beside your choice: ");
         isException = false;
         choice = kb.nextInt(); 
         if(choice != 1 && choice !=2 && choice !=3)
         {
           System.out.print("Please only enter a '1' '2' or '3'.");
         }
       }
       catch(Exception e)
       {
         System.out.print("Please enter a '1' or '2'.");
         isException = true;
       }
       kb.nextLine();
     }while(isException == true || choice != 1 && choice != 2 && choice !=3);
     
     System.out.print("\nPlease enter the name of the file of the vocabulary you want to study (please leave off the file extension):");
     String fileName = kb.nextLine() + ".txt";
     ListMaker vocab = new ListMaker(fileName);
     String[] text = vocab.readFile();
     vocab.splitText(text);
     String[] words = vocab.getWords();
     String[] definitions = vocab.getDefs();
     
     switch(choice)
     {
       case 1:
       {
         char decision;
         do
         {
           String currentWord = Word.chooseWord(words);
         int idx = Word.getIndex(words, currentWord);
         
         System.out.println("The definition of the word is:\n");
         Word.displayDef(idx, definitions);
         System.out.println();
         
         HangmanGame newHM = new HangmanGame(currentWord);
         newHM.allotSpaces();
         int gS = 0;
         do
         {
           gS = newHM.getGameStatus();
           if(gS == -1 || newHM.currLives == 5)
           {
             System.out.println("Sorry, you lost this round.");
             System.out.println("The correct word was \"" + currentWord + "\" .");
             break;
           }
           else if(gS == 1)
           {
             System.out.println("Congratulations! You've won!");
             break;
           }
           
           else
           {
             System.out.print("\nPlease enter the letter you want to guess (in lowercase): ");
             char letter = kb.next().charAt(0);
             int corr = newHM.checkInput(letter);
             if(corr == -1)
             {
               System.out.println("Sorry that letter is not in the word.");
               System.out.println("You have " + (5-newHM.currLives) + " lives left.");
             }
             else if(corr == 0)
             {
               System.out.println("You have already guessed that letter.");
             }
             else
             {
               System.out.println(letter + " is in the word.");
               newHM.fillInLetters(letter);
               gS = 0;
               continue;
             }
           }
           gS = newHM.getGameStatus();
           continue;
           }while(gS!=-1 && gS!=1 || newHM.currLives >= 5);
           System.out.print("Would you like to play HangMan again? Enter 'Y' for yes and 'N' for no:");
           String d = kb.next();
           decision = d.charAt(0);
         }while(decision == 'Y' || decision == 'y');
         break;
       }
       case 2:
       {
         char decision;
         do
         {
           Matching newMG = new Matching();
           newMG.displayWordsAndDefs(words,definitions);
           int[] answers = new int[10];
           for(int s = 0; s < 10; s++)
           {
             do
             {
               try
               {
                 System.out.print("\nPlease enter the number beside the defintion for word " + (s+1) + ":");
                 isException = false;
                 answers[s] = kb.nextInt(); 
                 if(answers[s] < 1 || answers[s] > 10)
                 {
                   System.out.print("Please only enter a number from 1-10.");
                   isException = true;
                 }
               }
               catch(Exception e)
               {
                 System.out.print("Please enter a number from 1-10.");
                 isException = true;
               }
               kb.nextLine();
             }while(isException == true || ((answers[s] >= 1)==false && !(answers[s] <= 10)==false));
           }
           
           int result = newMG.checkUserInput(answers, words, definitions);
           
           if(result == 1)
           {
             System.out.println("Congratulations! You have mastered this list!");
           }
           else
           {
             System.out.println("Sorry, you did not get all the answers correct.");
           }
           
           System.out.println();
           System.out.print("Would you like to review the answers? Enter \"Y\" for yes or \"N\" for no:");
           String input = kb.next();
           char r = input.charAt(0);
           if(r == 'Y' || r == 'y')
           {
             for(int k = 0; k<words.length; k++)
             {
               System.out.println(words[k] + definitions[k]);
             }
           }
           System.out.print("\n\nWould you like to play MatchMaster again? Enter 'Y' for yes and 'N' for no:");
           String d = kb.next();
           decision = d.charAt(0);
         }while(decision == 'Y' || decision == 'y');
         break;
       }
       case 3:
       { 
         SpeedRound newSR = new SpeedRound();
         char decision;
         Stopwatch timer1 = new Stopwatch();
         do
         {
             System.out.println("\nGOOOO!!\n"); 
             for(int s = 0; s < 10; s++)
             { 
               String currentWord = 
               SpeedRound.chooseWord(words); 
               int idx = 
               Word.getIndex(words, currentWord);
               newSR.addIndex(idx);
               Word.displayDef(idx, definitions);
               System.out.println();
               System.out.print("Enter the word: ");
               String ans = kb.next();
               newSR.isCorrect(ans, currentWord, idx);
               newSR.displayPoints();                      
             }
             double time1 = timer1.elapsedTime();
             System.out.print("\nThis speed round took you approximately:");;
             System.out.printf(" %.2f seconds\n", time1);
             System.out.println();
             int r = newSR.getResult();
             if(r == 'Y' || r == 'y')
             {
               newSR.reviewAnswers(words, definitions);
             }
             
             System.out.print("\n\nWould you like to play SpeedRound again? Enter 'Y' for yes and 'N' for no:");
             String d = kb.next();
             decision = d.charAt(0);
         }while(decision == 'Y' || decision == 'y');
         break;
         }   
       }
       
       System.out.print("\nWould you like to use StudyBuddy again? Enter \"S\" for study or \"E\" for exit:");
       String loop = kb.next();
       l = loop.charAt(0);
     }while(l == 'S' || l == 's');
    
    System.out.println("Have a great day, Scholar!");
      
    kb.close();
  
}
}
   