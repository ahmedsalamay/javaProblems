import java.util.Scanner;
/**
 * The normal game is between two players and played with three
 * heaps of any number of objects.
 * The two players alternate taking any number 
 * of objects from any single one of the heaps.
 * The goal is to be the last to take an object. In misère play, 
 * the goal is instead to ensure that the opponent is forced to take 
 * the last remaining object.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nim extends Player
{
    // instance variables - replace the example below with your own
    private static int HeabA;
    private static int HeabB;
    private static int HeabC;

    /**
     * Constructor for objects of class Nim
     */
    public Nim()
    {
        // initialise instance variables
        HeabA=3;
        HeabB=5;
        HeabC=7;
    }

    /**
     * Setter the Number of Objects in Heab A
     * 
     * @param  Number of Objects
     * @return    None 
     */
    public static void setHeabA(int num)
    {
     HeabA=num;   
    }
    /**
     * Setter the Number of Objects in Heab B
     * 
     * @param  Number of Objects
     * @return    None 
     */
    public static void setHeabB(int num)
    {
     HeabB=num   ;
    }
    /**
     * Setter the Number of Objects in Heab C
     * 
     * @param  Number of Objects
     * @return    None 
     */
    public static void setHeabC(int num)
    {
        HeabC=num;
    }
    /**
     * getter the Number of Objects in Heab A
     * 
     * @param  None
     * @return    Number of Objects
     */
    public  int getHeabA()
    {
        return HeabA;
    }
    /**
     * Setter the Number of Objects in Heab B
     * 
     * @param  None
     * @return    Number of Objects
     */
    public int getHeabB()
    {
        return HeabB;
    }
    /**
     * Setter the Number of Objects in Heab C
     * 
     * @param  None
     * @return    Number of Objects
     */
    public int getHeabC()
    {
        return HeabC;
    }
    /**
     * Game Rule
     * 
     * @param  Player Name
     * @return    COunt tell finish (as boolean if it is finished or not) 
     */
     public static int c(String player)
     {
         System.out.print("There Are "+(HeabA)+" Object in HeabA "+" \n && "
             +HeabB+" objects in HeabB  \n &&"
             +HeabC+" Objects in HeabC");
         int x=0;
         System.out.print("Choose The Heab: ");
         Scanner keyboard=new Scanner(System.in);
         int ChoiceH=keyboard.nextInt();
         System.out.print("\t Choose Number of Objects: ");
         int ChoiceO=keyboard.nextInt();
         if(ChoiceH==1)
         {
             
             if(HeabA-ChoiceO<0){
             System.out.print("Can Not CHoose prober Number or Different Heab");
            }
            if(HeabA-ChoiceO>=0)
            { HeabA=HeabA-ChoiceO;
             System.out.print("There Are "+(HeabA)+" Object in Heab(1) \n && "
             +HeabB+" objects in HeabB \n && "
             +HeabC+" Objects in HeabC \n");
            }
            }
          if(ChoiceH==2)
         {
             if(HeabB-ChoiceO<0){
             System.out.print("Can Not CHoose prober Number or Different Heab");
            }
            if(HeabB-ChoiceO>=0)
            {
             HeabB=HeabB-ChoiceO;
             System.out.print("There Are "+(HeabA)+" Object in HeabA "+" \n && "
             +HeabB+" objects in HeabB  \n &&"
             +HeabC+" Objects in HeabC");
            }
          }
          if(ChoiceH==3)
         {
             if(HeabC-ChoiceO<0){
             System.out.print("Can Not CHoose prober Number or Different Heab");
            }
            if(HeabC-ChoiceO>=0)
            {
             HeabC=HeabC-ChoiceO;
             System.out.print("There Are "+(HeabA)+" Object in HeabA "+
             " \n && "+HeabB+" objects in HeabB "
             +" \n &&"+HeabC+"Objects in HeabC");
            }
          }
            if(HeabA==0&&HeabB==0&&HeabC==0)
             {
                 System.out.print("Winner"+player);
                 x=1;
             }
             return x;
        }
     
}
