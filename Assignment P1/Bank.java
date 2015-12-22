
import java.util.*;

/**
 *Bank System 
 *
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bank
{
    
    private String Name;
    private String Address;
    private Account Acc;
    private int Phone;

    /**
     * Constructor for objects of class Bank
     */
    public Bank(String name,String add,int phone)
    {
        // initialise instance variables
        this.Name = name;
        this.Address=add;
        Phone=phone;
    }
    /**
     * Setter to Name
     * 
     * @param  the name of the Bank
     * @return     None
     */
    public void setName(String name)
    {
        // put your code here
        Name=name;
    }
    /**
     * setter Address
     * 
     * @param  the address of the Bank
     * @return     the sum of x and y 
     */
    public void setAdd(String add)
    {
        // put your code here
        Address=add;
    }
    /**
     * setter Phone Number
     * @param  phone number
     * @return None
       */
    public void setPhone(int ph)
    {
        // put your code here
        Phone=ph;
    }
        /**
         * getter Name
         * 
         * @param  None
         * @return    Name of client 
         */
    public String getName()
    {
        // put your code here
        return Name;
    }
    /**
     * getter Address
     * 
     * @param  None
     * @return  Address of client
     */
    public String getAdd()
    {
        // put your code here
        return Address;
    }
    /**
     * getter Phone Number
     * 
     * @param  None
     * @return  Phone of client
     */
     public int getPhone()
    {
        // put your code here
        return Phone;
    }

    public static void main(String [] args)
    {
          ArrayList<Account> ACC_ = new ArrayList<Account>();
        ArrayList<Client>CLI_=new ArrayList<Client>();
        Scanner keyboard=new Scanner(System.in);
    
     int i=0;
     Account c1;
     Client s1;
      int j=0;
      while(true){
        System.out.println("Enter (1)to add Client (2)for COmpany(3) for Viewing Clients");
     int choice=keyboard.nextInt();
       if(choice==1)
     {
       System.out.println("Enter (1)to Regular Account for Client or (2) for Specail Account for Client ");
       choice=keyboard.nextInt();
       System.out.println("ENter The Account Number ");
       int ACCNumber_=keyboard.nextInt();
       System.out.println("ENter The Balance ");
       int Balance_=keyboard.nextInt();
       System.out.println("ENter The Client NAme ");
       String Name_=keyboard.next();
       System.out.println("ENter The Address ");
       String Add_=keyboard.next();
       System.out.println("ENter The Phone");
       int Phone_=keyboard.nextInt();
       System.out.println("ENter The NID");
       int NID_=keyboard.nextInt();
       if(choice==1)
         {
             ACC_.add(i,new Account(ACCNumber_,Balance_));
         }
       if(choice==2)
            {
         ACC_.add(i,new SpecialAccount(ACCNumber_,Balance_));
            }
       CLI_.add(i,new Client(Name_,Add_,NID_,Phone_,ACC_.get(i)));
       i++;
       choice=-1;
      }
     if(choice==2)
      {
        System.out.println("Enter (1)to Regular Account for COmpany or (2) for Specail Account for Company");
       choice=keyboard.nextInt();
       System.out.println("ENter The Account Number ");
       int ACCNumber_=keyboard.nextInt();
       System.out.println("ENter The Balance ");
       int Balance_=keyboard.nextInt();
       System.out.println("ENter The Company NAme ");
       String Name_=keyboard.next();
       System.out.println("ENter The Address ");
       String Add_=keyboard.next();
       System.out.println("ENter The Phone");
       int Phone_=keyboard.nextInt();
       System.out.println("ENter The CID");
       int CID_=keyboard.nextInt();
       if(choice==1)
         {
             ACC_.add(i,new Account(ACCNumber_,Balance_));
         }
       if(choice==2)
            {
         ACC_.add(i,new SpecialAccount(ACCNumber_,Balance_));
            }
      CLI_.add(i,new CommercialClient(Name_,Add_,0000,Phone_,CID_,ACC_.get(i)));
       i++;
       }
       if(choice==3){
           j=0;
        while(j<i){
       System.out.println(CLI_.get(j));
       j++;
      }
     }
      if(choice==0)break;
    }
  }
}
