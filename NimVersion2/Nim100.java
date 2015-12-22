import java.util.Scanner;
/**
 *  two players start from 0 and alternatively add a number from 1 to 10 to the sum.
 *  The player who reaches 100 wins. 
 *  The winning strategy is to reach a number in which the digits are subsequent
 *  (e.g. 01, 12, 23, 34,...) and control the game by jumping
 *  through all the numbers of this sequence. Once reached 89, 
 *  the opponent has lost (he can only tell numbers from 90 to 99,
 *  and the next answer can in any case be 100)
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nim100 extends NimGame
{
    
    /**
     *insttance variable to counter untill reach 100 
       */
private int x;
    /**
     * Constructor for objects of class Nim100
     */
    public Nim100()
    {
       
    }
    /**
     * Setter Player One Name
     * @param Player 1 Name
     * @return None
     */
    public  void setPlayer1Name(String name)
    {
        Player1=name;
    }
     /**
     * getter Player 1 Name
     * @param 
     * @return Name of the player
     */
    public String getPlayer1Name()
    {
        return Player1;
    }
     /**
     * Setter Player Two Name
     * @param Player 2 Name
     * @return None
     */
    public  void setPlayer2Name(String name)
    {
        Player2=name;
    }
     /**
     * getter Player 1 Name
     * @param 
     * @return Name of the player
     */
    public String getPlayer2Name()
    {
        return Player2;
    }
    /**
     * Choice number between 1-10
     * @param the number you want to choose
     * @return None
     */
    public  void makeChoice(int c)
    {
        Choice=c;
    }
     /**
     * Getter for you choice
     * @param None
     * @return the number you had choosed
     */
    public  int getChoice()
    {
        return Choice;
    }
    /**
     * Change turns betwenn the players
     * @param the player who will play 
     * @return None
     */
    public  void changeTurn(String Player)
    {
        System.out.print(Player+" Your Turn Enter a Number Between 1-10 \n");
    }
    
     public  void setHeabA(int num)
     {
         HeabA=100;
        }
        
    /**
     * The Rule of play 
     * 
     * @param  Player Name
     * @return     None
     */
    public  void Play (String Winner)
    {    
        System.out.println("Y="+Choice);
        System.out.println("x="+x);
        if(x<100&&x+Choice<=100)
        {x=x+Choice;
            System.out.println("Y="+Choice);
          System.out.println("x="+x);
        }
        if(x==100)
        {System.out.println(Winner+" Win the game");
        }
    }
    public int getAdd()
    {return x;}
   /**
    * Main FUnction
    */
    public static void main(String [] args)
    {
         NimGame n1=new Nim100();
        n1.setPlayer1Name("Ahmed");
        
         n1.setPlayer2Name("Mustafa");
        Scanner keyboard=new Scanner(System.in);
        while(true)
        {
            
                 n1.changeTurn(n1.getPlayer1Name());
                 int Choice=keyboard.nextInt();
                 n1.makeChoice(Choice);
                 n1.Play(n1.getPlayer1Name());
             System.out.println("Now Number is "+n1.getAdd());
             if(n1.getAdd()>=100)
             break;
             n1.changeTurn(n1.getPlayer1Name());
            Choice=keyboard.nextInt();
             n1.makeChoice(Choice);
              n1.Play(n1.getPlayer2Name());
              System.out.println("Now Number is "+n1.getAdd());
             
            if(((Nim100) n1).getAdd()==100)
            {
                break;
            }
       
    }
   }
}
