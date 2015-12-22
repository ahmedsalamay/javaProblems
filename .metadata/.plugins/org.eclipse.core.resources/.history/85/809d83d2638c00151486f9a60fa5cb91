import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Matrix {
	 
//maltiply without threads
	public static int[][] multiply(int[][] matrixOne, int[][] matrixTwo) {
	        int mA = matrixOne.length;
	        int nA = matrixOne[0].length;
	        int mB = matrixTwo.length;
	        int nB = matrixTwo[0].length;
	        if (nA != mB) throw new RuntimeException("Illegal matrix dimensions.");
	        int[][] C = new int[mA][nB];
	        for (int row = 0; row < mA; row++)
	            for (int colm = 0; colm < nB; colm++)
	                for (int k = 0; k < nA; k++)
	                    C[row][colm] += matrixOne[row][k] * matrixTwo[k][colm];
	        return C;
	    }
	
	
	
	
//main
public static void main(String [] args){
	
	
	
	//initializing
	int matrixOne[][] = { {1,2,3}, {5,5,5},{4,1,2}};
	int matrixTwo[][] = { {6,9,1}, {1,3,2},{1,1,1}};
	int resultingMatrix [][] = new int [3][3];
	int resultingMatrix2 [][] = new int [3][3];
	 int mA = matrixOne.length;
     int nA = matrixOne[0].length;
     int mB = matrixTwo.length;
     int nB = matrixTwo[0].length;
		     
	     
     Threads []T1=new Threads[3];	
     
     
     
     
     //printing matrix without threads
     System.out.println("Without Threads ");
 	resultingMatrix2=multiply(matrixOne,matrixTwo);
 	for (int k = 0; k < mA; k++){
		 for (int j = 0; j < nB; j++){
		 System.out.print(resultingMatrix2[k][j] + " ");
		 }
		 System.out.println();
		 }
     
     
     
     //multiply with threads
     for (int row = 0; row < mA; row++)
     {
    	 T1[row]=new Threads( matrixOne, matrixTwo,resultingMatrix,row);
    	 T1[row].start();
     }
     
     
     //check if the thread is alive or not
     
     boolean threadDie=false;
     int i=0;
     while(!threadDie)
     {
    	 threadDie=true;
    	 for(int j=0;j<mA;j++)
    	 if (T1[j].isAlive())
    	 threadDie=false;
     }
     
     
     
     
     
     
     //if(!threadDie)
     //{
    	 System.out.println("With Threads");
    	 for (int k = 0; k < mA; k++){
    		 for (int j = 0; j < nB; j++){
    		 System.out.print(resultingMatrix[k][j] + " ");
    		 }
    		 System.out.println();
    		 }
   //  }
     
     
     
     
     
     
     
    
     
	/*int mA = 3;
    int nA = 3;
    int mB = 3;
    int nB = 3;
    */
    
    
    
     

	/*Thread  t1=new Thread(new Runnable(){
	   public void run(){
		   
	   }
	   
   });*/
	
	
	
  /*
   * Scanner scanner = new Scanner(System.in);
	System.out.print("Enter Row Matrix 1");
	int mA=scanner.nextInt();
	System.out.print("Enter Colm Matrix 1");
	int nA=scanner.nextInt();
	System.out.print("Enter Row Matrix 2");
	int mB=scanner.nextInt();
	System.out.print("Enter Colm Matrix 2");
	int nB=scanner.nextInt();
	int matrixOne[][] =new int[mA][nA];
	int matrixTwo[][]=new int[mB][nB] ;
	int resultingMatrix [][] = new int[mA][nB] ;
	int resultingMatrix2 [][]= new int [mA][nB];
	System.out.print("Enter M1");
	    for(int i=0;i<mA;i++)
	    {
	    	for(int j=0;j<nA;j++)
	    		matrixOne[i]=new int[j];
	    }
	    
	     for(int i=0;i<mA;i++)
	     for(int j=0;j<nA;j++)
	     {
	     int c=scanner.nextInt();
	     matrixOne[i][j]=c;
	     } 


	     System.out.print("Enter M2");
	     for(int i=0;i<mB;i++)
		    {
		    	for(int j=0;j<nB;j++)
		    		matrixTwo[i]=new int[j];
		    }
		    
		     for(int i=0;i<mB;i++)
		     for(int j=0;j<nB;j++)
		     {
		     int c=scanner.nextInt();
		     matrixTwo[i][j]=c;
		     } 
	     

   * */
}
}
