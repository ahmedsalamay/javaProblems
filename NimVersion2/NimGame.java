
/**
 * Abstract class NimGame - 
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class NimGame
{
    
     protected String Player1;
     protected String Player2;
     protected static int HeabA;
     protected static int x;
      protected static int Choice;
     

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y    a sample parameter for a method
     * @return        the sum of x and y 
     */
     public abstract void setPlayer1Name(String name);

    public abstract String getPlayer1Name();
    
    public abstract void setPlayer2Name(String name);

    public abstract String getPlayer2Name();
    
    
    
    public abstract void makeChoice(int c);
    
    public abstract int getChoice();
    
    public abstract void changeTurn(String Player);
    
    public  abstract void setHeabA(int num);
   
    
    public abstract void Play (String Winner);
    public abstract  int getAdd();
    
    
     
    
}
