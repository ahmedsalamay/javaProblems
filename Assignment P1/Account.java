
/**
 * 
 * 
 * @author (Ahmed) 
 * @version (a version number or a date)
 */
public class Account
{
    private int Balance;
    private int AccountNumber;
    /**
     * Defualt Constructor for objects of class Account
     */
    public Account()
    {
        Balance = 0;
        AccountNumber =0;
    }
    /**
     * Constructor for objects of class Account
     */
    public Account(int num,int bal)
    {
        Balance = bal;
        AccountNumber=num;
    }

    /**
     * Seter for Balance
     * 
     * @param  the amount of money to add to your balance
     * @return     void 
     */
    public void setBalance(int balance)
    {
        Balance=balance;
    }
    /**
     * Seter for Account Number
     * 
     * @param  account number 
     * @return     void
     */
    public void setAccountNumber(int num)
    {
        AccountNumber=num;
    }
    /**
     * Geter for Account Number
     * 
     * @param No parameter for a method
     * @return      Account Number o
     */
    public int getAccountNumber()
    {
        return AccountNumber;
    }
    /**
     * Geter for Balance
     * 
     * @param No parameter for a method
     * @return     the Balance of this cleint
     */
    public int getBalance()
    {
        return Balance;
    }
     /**
     * toString Function
     * 
     * @param No parameter for a method
     * @return     String of information about account
     * @@Override the to string method in the String class
     */
    public String toString()
    {
        return "The Account Number: "+this.AccountNumber+"\n The Account Balance: "+this.Balance;
    }
    /**
     * Deposite  to Increase the Balance
     * 
     * @param the amount of money you want to add 
     * @return     void
     */
    public void Deposite(int amount)
    {
        Balance+=amount;
    }
    /**
     * Withdraw  to get some money 
     * 
     * @param the amount of money you want to withdraw 
     * @return     void
     */
    public void Withdraw(int amount)
    {
        if(Balance>=amount)
        Balance-=amount;
    }
    
}
    