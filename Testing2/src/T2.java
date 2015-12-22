	import java.util.ArrayList;
	import java.util.Scanner;
	public class T2 {
		public static void main(String[] args) {
			
			String str;
			String str2="";
			int count =0;
			Scanner cin=new Scanner(System.in);
			str=cin.nextLine();
			int x=0;
			x=cin.nextInt();
			str2=str;
			ArrayList<String> s=new ArrayList();
			for(int i=0;i<x;i++)
			{
				s.add(cin.next());
			}
			for(int i=0;i<s.size();i++)
			{String s2=s.get(i);
			str=str2;
		         	count =0;
					int y=str.indexOf(s2);
					while(y!=-1){
						count++;
					if(y!=0){
					str=str.substring(0,y )+str.substring(y+s2.length(),str.length());
					System.out.println(str);
					}if(y==0){
						str=str.substring(y+s2.length(),str.length() );
						System.out.println(str);}
					if(y==str.length()-s2.length())
					{
						str=str.substring(0,y+1);
						System.out.println(str);
					}
				 
					y=str.indexOf(s2);
					}
					System.out.println(s2+" Count "+count);
			}
	
		}
	
	}
