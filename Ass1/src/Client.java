
/**
 * Write a description of class Client here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Client
{
    // instance variables - replace the example below with your own
    private String Name;
    private int NID;
    private String Address;
    
    private int Phone;
    /**
     * Constructor for objects of class Client
     */
    public Client()
    {   
        // initialise instance variables
        Name = null;
        NID=0;
        Address=null;
        Phone=0;
        
    }
     /**
     * Constructor for objects of class Client
     */
    public Client(String name,String add,int nid,int phone)
    {   
        // initialise instance variables
        Name = name;
        NID=nid;
        Address=add;
        Phone=phone;
       
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setName(String name)
    {
        // put your code here
        
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setNID(int nid)
    {
        // put your code here
        
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setAdd(String add)
    {
        // put your code here
        
    }
    public void setPhone(int ph)
    {
        // put your code here
        Phone=ph;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getName()
    {
        // put your code here
        return Name;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getAdd()
    {
        // put your code here
        return Address;
    }
     public int getPhone()
    {
        // put your code here
        return Phone;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getNID()
    {
        // put your code here
        return NID;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    public String toString()
    {
        return "Name: "+Name+"\n Address "+Address+"\n Phone: "+Phone+"\n NID : "+NID+"\n Account Balance: "
    ;}
    public static void main(String[] args)
    {
    	Client acc=new Client("Ahmed","Safaga",12,123);
    	acc.toString();
    	
    }
}
