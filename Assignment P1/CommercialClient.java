
/**
 * Write a description of class CommercialClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommercialClient extends Client
{
    // instance variables - Commerical ID 
     private int commercialID ;
    /***
     * Constructo 
     */
          public CommercialClient(String name,String add,int nid,int phone,int CID,Account acc_)
    {
        super(name,add,nid,phone,acc_);
        commercialID=CID;
    }
    /**setter for commerecail ID
     * @param commerical ID 
     * @return NONe(void)
     */
    public void set_commercialID (int CID)
    {
        commercialID=CID;
    }
    /**getter for commerecail ID
     * @param commerical ID 
     * @return NONe(void)
     */
    
    public int get_commercialID()
    {
        return  commercialID ;
    }
    /**
     * toString Function
     * 
     * @param No parameter for a method
     * @return     String of information about Comapny
     * @@Override the to string method in the String class
     */
    
    public String toString ()
    {
        String inform;
        inform = "Client INFO...  \n"+"Name :"+getName()+"\nCommercialID :"+commercialID+"\nAddress :"
           +getAdd()+"\nPhone :"+getPhone()+"\n"+getAcc().toString();
        return inform;
    }
}
