
public class Threads extends Thread{

	private int matrixOne[][];
	private int matrixTwo[][];
	private int matrixResult[][];
	private int  rowIndex;
	
	
	
	public Threads(int[][] matrixOne, int[][] matrixTwo,int [][]resultingMatrix,int rowIndex){
		this.matrixOne=matrixOne;
		this.matrixTwo=matrixTwo;
		this.rowIndex=rowIndex;
		this.matrixResult= resultingMatrix;
		
	}
	public void run()
	{
		 int mA = matrixOne.length;
	        int nA = matrixOne[0].length;
	        int mB = matrixTwo.length;
	        int nB = matrixTwo[0].length;
	        for (int colm = 0; colm < nB; colm++)
                for (int k = 0; k < nA; k++)
                    matrixResult[rowIndex][colm] += matrixOne[rowIndex][k] * matrixTwo[k][colm];
	}
	
}
