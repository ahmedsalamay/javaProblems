
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
     * Setter to Player Name
     * 
     * @param  Name
     * @return    VOid 
     */
    public void setPlayerName(String name)
    {
        Player=name;
    }
   /**
     * Getter to Player Name
     * 
     * @param  None
     * @return    Name
     */
    public String getPlayerName()
    {
        return Player;
    }
    
    /**
     * Tell me Who is Next
     * 
     * @param  None
     * @return    No return But Print Who is Next
     */
    public void yourTurn()
    {
        System.out.print(Player+" it is your Turn Now Enter Number\n");
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
        int x=0;
        /**
         * Looping tell reach to 100
         */
        while(true){
            if(x==1)
            break;
          p1.yourTurn();
           x= ((Nim) p1).c(p1.getPlayerName());
           if(x==1)
            break;
            p2.yourTurn();
  
           x= ((Nim) p2).c(p2.getPlayerName());
            
    }
  }
}