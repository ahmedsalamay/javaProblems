
/**
 * Write a description of class Nim100 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nim100 extends Player
{
    // instance variables - replace the example below with your own
    private static int x=0;

    /**
     * Constructor for objects of class Nim100
     */
    public Nim100()
    {
       
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void addNumber (int y,String Winner)
    {
        if(x<100&&x+y<=100)
        x+=y;
        if(x==100)
        {System.out.println(Winner+" Win the game");
        }
    }
    public  int getAdd ()
    {
        return x;
    }
}
