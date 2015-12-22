
public class Thered extends Thread {
 private String name;
 int [][]m1=new int [3][3];
int [][]m2=new int [3][3];
int m3[][]=new int[3][3];
 public Thered (String Name)
 {
	name=Name; 
 }
 
	public void run()
	{
		System.out.print("Thread Running "+name);
		
		m3[i][j]=m1[i][j]+m2[i][j];
	}
	public void main(String [] args)
	{
		int [][]m1=new int [3][3];
		int [][]m2=new int [3][3];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				m1[i][j]=j;
				System.out.println(m1[i][j]);
			}
		}
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				m2[i][j]=j;
				System.out.println(m2[i][j]);
			}
		}
		
	}
}
