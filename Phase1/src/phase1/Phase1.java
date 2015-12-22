package src.phase1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Phase1 {

    public static void main(String[] args) 
    {
        Scanner cin=new Scanner(System.in);
        //System.out.println("Enter Size Block");
        System.out.print("Enter hight of block: ");
        int Block_hight=cin.nextInt();
        System.out.print("Enter the wight of block: ");
        int Block_wight=cin.nextInt();
        //System.out.println("Enter the path of emage : ");
        String path="C:\\Users\\Ahmed\\Desktop\\Blocking\\pic.jpg";
        int largmatrix1[][]=readImage(path);
        
        File file=new File(path);
        BufferedImage image=null;
        try {
            image=ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width1=image.getWidth();
        int height1=image.getHeight();
        
        
        int height=0;
                height+=height1%Block_hight;
                height+=height1;
        int width=0;
                width+=width1%Block_wight;
                width+=width1;
                
        int largmatrix[][]=new int [height][width];
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<width;j++)
            {
                largmatrix[i][j]=0;
            }
        }
        
        for(int i=0;i<height1;i++)
        {
            for(int j=0;j<width1;j++)
            {
                largmatrix[i][j]=largmatrix1[i][j];
            }
        }
        
        
        System.out.println("Image numbers : ");
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<height;j++)
            {
                System.out.print(largmatrix[i][j]+" ");
            }
            System.out.print("\n");
        }
        int result=width*height;
        int resultBlock=Block_hight*Block_wight;
      
           int sizearrBlocks=result/resultBlock;
           int arr[][][]=new int[sizearrBlocks][Block_hight][Block_wight];
           int countMatrix=0;
           for(int i=0;i<height;i+=Block_hight)
           {
               for(int j=0;j<width;j+=Block_wight)
               {
                   System.out.println("Matrix number ("+(countMatrix+1)+") :-");
                   for(int i2=0;i2<Block_hight;i2++)
                   {
                       for(int j2=0;j2<Block_wight;j2++)
                       {
                           arr[countMatrix][i2][j2]=largmatrix[i+i2][j+j2];
                           System.out.print(arr[countMatrix][i2][j2]+" ");
                       }
                       System.out.print("\n");
                   }
                   countMatrix++;
               }
           }
    }
    
    
    
    public static int[][] readImage(String filePath) {
        File file=new File(filePath);
        
        BufferedImage image=null;
        
        try {
            image=ImageIO.read(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int width=image.getWidth();
        int height=image.getHeight();
        int[][] pixels=new int[height][width];
        for(int i=0;i<width;i++)
        {
            for(int j=0;j<height;j++)
            {
                pixels[j][i]=(image.getRGB(i, j) >> 16) & 0xff;
            }
        }
        return pixels;
    }
}
