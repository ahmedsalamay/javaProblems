import java.util.Scanner;
/**
 * Write a description of class Nim here.
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
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void setHeabA(int num)
    {
     HeabA=num;   
    }
    public static void setHeabB(int num)
    {
     HeabB=num   ;
    }
    public static void setHeabC(int num)
    {
        HeabC=num;
    }
    public  int getHeabA()
    {
        return HeabA;
    }
    public int getHeabB()
    {
        return HeabB;
    }
    public int getHeabC()
    {
        return HeabC;
    }
     public static int c(String player)
     {
         int x=0;
         System.out.print("Choose The Heab: ");
         Scanner keyboard=new Scanner(System.in);
         char ChoiceH=keyboard.next();
         System.out.print("\t Choose Number of Objects: ");
         int ChoiceO=keyboard.nextInt();
         if(ChoiceH=='A')
         {
             
             if(HeabA-ChoiceO<0){
             System.out.print("Can Not CHoose prober Number or Different Heab");
            }
             HeabA=HeabA-ChoiceO;
             System.out.print("There Are "+(HeabA)+"Object in HeabA left"+"&& "+HeabB+" objects in HeabB"
             +HeabC+"Objects in HeabC");
          }
          if(ChoiceH=='B')
         {
             if(HeabB-ChoiceO<0){
             System.out.print("Can Not CHoose prober Number or Different Heab");
            }
             HeabB=HeabB-ChoiceO;
             System.out.print("There Are "+(HeabA)+"Object in HeabA left"+"&& "+HeabB+" objects in HeabB"
             +HeabC+"Objects in HeabC");
          }
          if(ChoiceH=='C')
         {
             if(HeabC-ChoiceO<0){
             System.out.print("Can Not CHoose prober Number or Different Heab");
            }
             HeabC=HeabC-ChoiceO;
             System.out.print("There Are "+(HeabA)+"Object in HeabA left"+"&& "+HeabB+" objects in HeabB"
             +HeabC+"Objects in HeabC");
          }
            if(HeabA==0&&HeabB==0&&HeabC==0)
             {
                 System.out.print("Winner"+player);
                 x=1;
             }
             return x;
        }
     
}
