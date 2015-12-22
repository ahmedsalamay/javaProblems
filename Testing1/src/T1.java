
public class T1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String c="cat";
       String d="car";
       String result="";
       if(c.length()>=d.length())
       {
    	   for(int i=0;i<d.length();i++)
    		   {char c1=c.charAt(i);
    		   char d1=d.charAt(i);
    		   if(c1==d1)
    		   { result+=c.substring(i, i+1);}
    	          else if(c1!=d1)
    	          {System.out.println(c1+" to "+d1);
    	        	  result+=d.substring(i, i+1);
    	          }
       }
    	   }
       
       
       
       int q=c.length()-d.length();
       System.out.println("delete last "+q);
       System.out.print(result);

	}

}
