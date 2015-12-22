
/**
 * A similar version is the "100 game": two players start from 0 and alternatively
 * add a number from 1 to 10 to the sum. 
 * The player who reaches 100 wins.
 * The winning strategy is to reach a number in which the digits are subsequent 
 * (e.g. 01, 12, 23, 34,...) and control the game by jumping 
 * through all the numbers of this sequence. Once reached 89,
 * the opponent has lost (he can only tell numbers from 90 to 99, 
 * and the next answer can in any case be 100).
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nim100 extends Player
{
    // instance variables - replace the example below with your own
    private static int x;

    /**
     * Constructor for objects of class Nim100
     */
    public Nim100()
    {
       
    }

    /**
     * 
     * Rule Game
     * @param  Choosed Number ,Player Name
     * @return     Void
     */
    public static void addNumber (int y,String Winner)
    {    
        System.out.println("Y="+y);
        System.out.println("x="+x);
        if(x<100&&x+y<=100)
        {x=x+y;
            System.out.println("Y="+y);
          System.out.println("x="+x);
        }
        if(x==100)
        {System.out.println(Winner+" Win the game");
        }
    }
    /**
     * 
     *
     * @param  None
     * @return     Count Number tell reach to 100
     */
    public static  int getAdd ()
    {
        return x;
    }
}
