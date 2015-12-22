
/**
 * withdraw to allow over drafting with maximum limit of 1000 LE.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpecialAccount extends Account
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class SpecialAccount
     */
    public SpecialAccount(int num,int bal)
    {
       // super( num,bal);
    }
    /**
     * withdraw to allow over drafting with maximum limit of 1000 LE.
     * @param the amount of money you want to take 
     * @return None (Void)
     * @override the withdraw method on the Account class
     */
    public void Withdraw(int amount)
    {
         if(getBalance()-amount>=-1000)
        {
           setBalance(getBalance()-amount);
            System.out.println("Your current balance :" +getBalance());
        }
        else 
        {
            System.out.println("NO enough balance");
        }
        /*if(getBalance()>=(-1000)&&(getBalance()-amount)>=-1000)
        setBalance(getBalance()-amount);
        else 
        System.out.print("Cant\n");*/
    }

    
    }

