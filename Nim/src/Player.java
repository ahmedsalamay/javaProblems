
import java.util.Scanner
;
/**
 * Write a description of class Players here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String Player;
    private int  Total;
    private int PlayerResult;
    /**
     * Constructor for objects of class Players
     */
    public Player()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setPlayerName(String name)
    {
        Player=name;
    }
   
    public String getPlayerName()
    {
        return Player;
    }
    
    public void setPlayerResult(int res)
    {
        PlayerResult=res;
    }
   
    public int getPlayerResult()
    {
        return PlayerResult;
    }
    public void yourTurn()
    {
        System.out.print(Player+" it is your Turn Now Enter Number");
    }
    
    public static void main(String [] args)
      {/*
        Player n1=new Nim100();
        n1.setPlayerName("Ahmed");
        Player n2= new Nim100();
         n2.setPlayerName("Mustafa");
        Scanner keyboard=new Scanner(System.in);
        while(true)
        {
            
                 n1.yourTurn();
                 int Choice=keyboard.nextInt();
                 Nim100.addNumber(Choice,n1.getPlayerName());
             System.out.println("Now Number is "+Nim100.getAdd());
             if(Nim100.getAdd()>=100)
             break;
             n2.yourTurn();
            Choice=keyboard.nextInt();
              Nim100.addNumber(Choice,n2.getPlayerName());
              System.out.println("Now Number is "+Nim100.getAdd());
             
            if(((Nim100) n1).getAdd()==100)
            {
                break;
            }
        }*/
        
        Player p1=new Nim();
        Player p2=new Nim();
        p1.setPlayerName("Ahmed");
        p2.setPlayerName("Mustafa");
        while(true){
          p1.yourTurn();
            ((Nim) p1).c(p1);
            p2.yourTurn();
            ((Nim) p2).c(p2);
    }
  }
}