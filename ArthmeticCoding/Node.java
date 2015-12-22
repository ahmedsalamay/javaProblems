  public class Node 
{
    public String Symbol;
    public double prob;
    //public int weight;
    public double low;
    /**
     *
     */
    public double high;
    
    public Node(String sy,double prob)
    {
        Symbol=sy;
        this.prob=prob;
    }
}
