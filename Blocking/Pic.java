
 

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Ahmed
 */
public class Pic 
{
    
    private int width=0;
    private int height=0;
    private ArrayList<ArrayList<Integer>>blocks;
    private int pixels[][];
    
    public Pic()
    {}
    public  void read(String Path)
    {
        File file=new File(Path);
        BufferedImage image=null;
        try
        {
            image=ImageIO.read(file);
        }
        catch (IOException e){}

          width=image.getWidth();
          height=image.getHeight();
         
          pixels=new int[height][width];

        for(int i=0;i<width;i++)
        {
            for(int j=0;j<height;j++)
            {
                pixels[j][i]=(image.getRGB(i, j) >> 16) & 0xff;
            }
        }
    }
    
    
    public  void blocks()
    {
        blocks=new ArrayList<>();
        ArrayList<Integer> block=new ArrayList<>();
        int chunkheight;
        int chunkwidth;
        if (width%chunkheight==0&&height%chunkheight==0)
        {
        
        for(int i=0;i<width;i+=chunkwidth)
        {
            for(int j=0;j<height;j+=chunkheight)
            {
               System.out.print(pixels[i][j]);
                System.out.print("  ");
               
                System.out.print(pixels[i][j+1]);
               System.out.println();
                
                System.out.print(pixels[i+1][j]);
                System.out.print("  ");
                
                System.out.print(pixels[i+1][j+1]);
                System.out.println();
                System.out.println();
                
                
            }
            
        }
    }
    }

    public static void main(String[] args) 
    {
        Pic c=new Pic();
        c.read("pic.jpg");
        c.blocks();
       
        
    }
    

} 






/*
    public  void write(String Path)
    {
        File fileout=new File(Path);
        BufferedImage image2=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB );

        for(int i=0;i<width ;i++)
        {
            for(int j=0;j<height;j++)
            {
                image2.setRGB(i,j,(pixels[j][i]<<16)|(pixels[j][i]<<8)|(pixels[j][i]));
                System.out.println((pixels[j][i]<<16)|(pixels[j][i]<<8)|(pixels[j][i]));
            }
        }
        try
        {
            ImageIO.write(image2, "jpg", fileout);
        }
        catch (IOException e)
        {
        }
    }
  */  