
/**
 * Client Class to initial an Client who have Name,NID,Address,Phone and an account;
 * 
 * @author (your Ahmed) 
 * @version (a version number or a date)
 */
public class Client
{
    private String Name;
    private int NID;
    private String Address;
    private Account Acc;
    private int Phone;
    /**
     * Defualt Constructor for objects of class Client
     */
    public Client()
    {      
    }
     /**
     * Constructor for objects of class Client
     */
    public Client(String name,String add,int nid,int phone,Account acc_)
    { 
        this.Name = name;
        NID=nid;
        this.Address=add;
        Phone=phone;
        Acc=acc_;
    }

    /**
     * Setter Name 
     * 
     * @param  string name 
     * @return     void
     */
    public void setName(String name)
    {
        Name=name;
    }
    /**
     *Setter NID 
     * 
     * @param  int NID
     * @return     void 
     */
    public void setNID(int nid)
    {
        NID=nid;
    }
    /**
     * Setter Address 
     * 
     * @param  string address
     * @return     void 
     */
    public void setAdd(String add)
    {
        Address=add;
    }
    /**
     * Setter Phone number 
     * 
     * @param  string int phone number
     * @return     void 
     */
    public void setPhone(int ph)
    {
        Phone=ph;
    }
    /**
     * Setter Account 
     * 
     * @param  int x=Balance ,inty=Account number
     * @return     the sum of x and y 
     */
    public void setAccount(int x,int y)
    {
        Acc.setBalance(x);
        Acc.setAccountNumber(y);
    }
    /**
     * Getter Name
     * 
     * @param  None
     * @return     Client Name
     */
    public String getName()
    {
        return Name;
    }
    /**
     * Getter Address
     * 
     * @param  None
     * @return     Client Address 
     */
    public String getAdd()
    {
        return Address;
    }
    /**
     * Getter Phone
     * 
     * @param  None
     * @return     Client Phone Number 
     */
     public int getPhone()
    {
        return Phone;
    }
    /**
     *Getter NID
     * 
     * @param None
     * @return     Client NID
     */
    public int getNID()
    {
        return NID;
    }
    /**
     * Getter Account
     * 
     * @param  None
     * @return     Client Account Containe Balance and account number 
     */
    public Account getAcc()
    {
        return Acc;
    }
    /**
     * ToString Method override
     * 
     * @param  None
     * @return     Information about the client (Name,Phone,Address,NID,Account) 
     */
    public String toString()
    {
        return "Name: "+Name+"\n Address "+Address+"\n Phone: "+Phone+"\n NID : "+NID+"\n Account Balance: "+Acc.getBalance()+"\n Account Number: "+Acc.getAccountNumber();
    }
}
