package src;


/**
 * @author Ahmed
 *
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.text.*;

public class Command {
    
    public Command ()
    {}
   


    public String pwd (){
        String output = System.getProperty("user.dir");
        System.out.println(output);
        return output;
    }
    
    public String[] ls()
    {
        File ls=new File(System.getProperty("user.dir"));
        String []list=ls.list();
        for(String file :list)
        {
            System.out.print(file+" ");
        }
        return list;
    }
    
     public void mkdir(String path)
     {
         File directory=new File(path);
         if(!directory.exists())
         {
             directory.mkdir();
             System.out.println("Direcotry have been Created");
            }
            else
            {
                System.out.println("Directory Already Exist");
            }
        }
        
          public void rm(String delete)
        {
            File dFile=new File(delete);
            File d=dFile;
            File [] listFiles=dFile.listFiles();
            if(dFile.isDirectory())
            {
             for(File sub : listFiles)   
              {
                  rm(sub.getAbsolutePath());
               }
            }
            
            else
            {
                dFile.delete();
            }
            d.delete();
            
        }
        
     public void rmdir(String delete)
        {    
            File dFile=new File(delete);
            if(dFile.delete())
            {
                System.out.println("Directory has been deleted successfully ");
                
            }
            else
                System.out.println("Directory isn't Empty try the -rm- command");
        }
        
     public ArrayList<String> cat(String f1)
        {
            String line;
            ArrayList<String>ret = new ArrayList<String>();
             try {
                FileReader fileReader = new FileReader(f1);
                BufferedReader in = new BufferedReader(fileReader);
                
                
                while((line = in.readLine())!= null){
                    System.out.println(line);
                    ret.add(new String(line));
                    
                }
                
            } catch (FileNotFoundException ex) {
                System.out.println("test.txt"+", file not found.");
            }
            catch (IOException ex) {
                System.out.println("test.txt"+", input/output error.");
            }
             /*try {
                FileReader fileReader = new FileReader(f2);
                BufferedReader in = new BufferedReader(fileReader);
                
                while((line = in.readLine())!= null){
                    System.out.println(line);
                }
            } catch (FileNotFoundException ex) {
                System.out.println("test.txt"+", file not found.");
            }
            catch (IOException ex) {
                System.out.println("test.txt"+", input/output error.");
            }*/
             return ret;
            
            
             /*
   
            String s="";
            while(f1.hasNext())
            {
                s+=f1.next();
            }
            System.out.print(s);*/
        }
        
     public String date()
        {
            Date dat = new Date();
            SimpleDateFormat format = new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm:ss a");
            System.out.println(format.format(dat));
            String ret=format.format(dat);
            return ret;
        }
        
     public void cd(String path)
     {
         if(path.equals("..."))
         {
             String p=System.getProperty("user.dir");
             String ch="\\";
             ch=ch.substring(0,1);
             String []links=p.split("\\\\");
             p="C:";
             for(int i=0;i<links.length-2;i++)
             {
                 p+=ch+links[i+1];
             }
             System.setProperty("user.dir", p);
         }
         else
         {
         File directory=new File(path);
         if(directory.isDirectory())
         {System.setProperty("user.dir",directory.getAbsolutePath());
            }
            else
            {System.out.print(path+" Not Found");}
         }
        }
        
    public void clear()
    {
        for(int i=0;i<30;i++)
        System.out.print("\n");
    }
    
   /* public void cp(String originalDir,String copyDir) throws IOException
    {
        File original=new File(originalDir);
        FileReader Or=new FileReader(original);
        
        File copy = new File(copyDir);
        FileWriter Co=new FileWriter(copy);
        
        int ch;
        while( (ch=Or.read()) != -1 )
        {
            Co.write(ch);
        }
            
        Co.close();
        Or.close();
        
    }
     */
     public static void cp(String srcDir, String dstDir)
    {

        try {
            File src = new File(srcDir);
            String ds=new File(dstDir,src.getName()).toString();
            File dst = new File(ds);

            if (src.isDirectory()) {
                if (!dst.exists()) {
                    dst.mkdir();
                }

                String files[] = src.list();
                int filesLength = files.length;
                for (int i = 0; i < filesLength; i++) {
                    String src1 = (new File(src, files[i]).toString());
                    String dst1 = dst.toString();
                    cp(src1, dst1);

                }
            } else {
                fileWriter(src, dst);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public static void fileWriter(File srcDir, File dstDir) throws IOException
{
        try {
            if (!srcDir.exists()) {
                System.out.println(srcDir + " doesnot exist");
                throw new IOException(srcDir + " doesnot exist");
            } else {
                InputStream in = new FileInputStream(srcDir);
                OutputStream out = new FileOutputStream(dstDir);
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();

            }
        } catch (Exception e) {

        }
    }
    
    
    public void mv(String originalDir,String copyDir) throws IOException
    {
        cp(originalDir,copyDir);
        File del=new File(originalDir);
        rm(originalDir);
        if(del.exists())
        {
            System.out.println("File cannot be moved !");
        }
    }
    public String open(String next,String op,String path) throws IOException
    {
        File f=new File(path);
        if(op==">")
        {
            f.delete();
            File fnew=new File(path);
            FileWriter f2 = new FileWriter(fnew, false);
            f2.write(next);
            f2.close();
            return null;
            
        }
        else if(op==">>")
        {
            File fnew=new File(path);
            FileWriter f2 = new FileWriter(fnew, true);
            f2.write(next);
            f2.close();
            return null;
        }
        else if(op=="<")
        {
             FileReader fileReader = new FileReader(f);
             BufferedReader in = new BufferedReader(fileReader);
             String ret= in.readLine();
            return ret;
        }
        return null;
    }
    public void more(String s )throws IOException
    {
         FileReader reader = new FileReader(s);
        BufferedReader buff = new BufferedReader(reader);
        String readLine;
        int lineCount = 0;
        while ((readLine = buff.readLine()) != null)
        {
           System.out.println(readLine);
            lineCount++;
            if (lineCount > 7)
            { 
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();
            }
        }
    }
    public void args(String s) {
                System.out.println("Command                         Arg              ");
        switch (s){

        case("date"):
        System.out.println("   date                          ----               ");
        break;
        case("clea"):
        System.out.println("   clear                          ----              ");
        break;
        case("cat"):
         System.out.println("   cat                          (file name)            ");
         break;
         case("pwd"):
        System.out.println("   pwd                            ----               ");
        break;
        case("cd"):
        System.out.println("    cd                        (directory name)        ");
        break;
        case("ls"):
        System.out.println("    ls                            ----              ");
        break;
        case("mkdir"):
         System.out.println("   mkdir                         (Folder name)         ");
         break;case("rmdir"):
        System.out.println("   rmdir                         (folder name)         ");
        break;
        case("cp"):
        System.out.println("    cp                      (file name,The directory) ");
        break;
        case("mv"):
        System.out.println("    mv                      (file name,The directory) ");
        break;
        case("rm"):
        System.out.println("    rm                           (file name)          ");
       break;
       case("more"):
        System.out.println("   more                          (file name)           ");
        break;
        case("less"):
        System.out.println("   less                          (file name)              ");
       break;
       case("args"):
        System.out.println("   args                           ----    ");
        break;
        case("help"):
        System.out.println("   help                           ---- ");
        break;
    }
    }
    public String[] help()
    {
        String[] Help={
                "-----------------Help Menu-----------------"
                ,"ls                   :  List Files in directory"
                ,"cd    dir            : Changes Current Directory to dir"
                ,"cd    ...            : Change Current Directory to one step back"
                ,"pwd                  : Showes current Directory "
                ,"mkdir dir            : Creates a Directory dir inside Current Directory"
                ,"rm    file           : Deletes file or Directory with files inside it " 
                ,"cp    f1 f2          : Copies f1 to f2" 
                ,"mv    f1 f2          : Moves f1 to Directory f2"
                ,"cat   f1             : Showes content of f1 to Terminal"
                ,"more  f1             :output the content of f1"
                ,"less  f1             :output the content of f1"
                ,"comm >file.txt       :Redirect the output to be written to file.txt"
                ,"comm >>file.txt      :Redirect the output to be appended to file.txt"
                ,"comm <file.txt       :Redirect the input to be taken from file.txt"
                ,"comm ; comm          :Redirect the output of the previous command as input of next command"
                    };
        
        for(String p : Help)
        {
            System.out.println(p);
        }
        return Help;
    }
 
    public String runNormal(String input) throws IOException
    {
        String ret="";
        
        if(input.equals("clear"))
        {
            clear();
            return null;
        }
        else if(input.equals("exit"))
        {
            System.exit(0);
            return null;
        }
        else if(input.equals("pwd"))
        {
            ret=pwd();
            return ret;
        }
        else if(input.equals("ls"))
        {
            String[] r=ls();
            for(String i : r)
            {
                ret=ret+"\n"+i;
            }
            return ret;
        }
        else if(input.equals("date"))
        {
            ret=date();
            return ret;
        }
        else if(input.contains("cd"))
        {
            
            String [] comm=input.split(" ");
            if(comm.length<2)
            {
                System.out.println("Erorr Wrong FOrmat");
                return null;
             }
             else
            cd(comm[1]);
            
        }
        else if(input.contains("more"))
        {
            String [] comm=input.split(" ");
            more(comm[1]);
            
        }
        else if(input.equals("help"))
        {
            String[] r=help();
            for(String i : r)
            {
                ret=ret+"\n"+i;
            }
            return ret;
        }
        else if(input.contains("cat"))
        {
            ArrayList<String> c=new ArrayList<String>();
            String [] comm=input.split(" ");
            int i=0;
            c=cat("tf.txt");
            for(String r:c)
            {
                ret=ret+"\n"+r;
                i++;
            }
            if(comm.length>2)
            {
            if(comm[2]!=null)
            {
            c=cat(comm[2]);
            for(String r:c)
            {
                ret=ret+"\n"+r;
            }}}
            return ret;
            
        }
        else if(input.contains("mkdir"))
        {
            
            String [] comm=input.split(" ");
            if(comm.length<2)
            {
                System.out.println("Erorr Wrong FOrmat");
                return null;
             }
            mkdir(comm[1]);
            return null;
        }
        else if(input.contains("args"))
        {
             String [] comm=input.split(" ");
            if(comm.length<2)
            {
                System.out.println("Erorr Wrong FOrmat");
                return null;
             }
             else
            args(comm[1]);
            return null;
        }
        else if(input.contains("rmdir"))
        {
            String [] comm=input.split(" ");
            if(comm.length<2)
            {
                System.out.println("Erorr Wrong FOrmat");
                return null;
             }
             else
              rmdir(comm[1]);
            

           
            return null;
        }
        else if(input.contains("rm"))
        {
            String [] comm=input.split(" ");
            if(comm.length<2)
            {
                System.out.println("Erorr Wrong FOrmat");
                return null;
             }
             else
            rm(comm[1]);
            return null;
        }
        else if(input.contains("cp"))
        {
            String [] comm=input.split(" ");
            cp(comm[1], comm[2]);
            return null;
        }
        else if(input.contains("mv"))
        {
            String [] comm=input.split(" ");
            if(comm.length<2)
            {
                System.out.println("Erorr Wrong FOrmat");
                return null;
             }
             else
            mv(comm[1],comm[2]);
            return null;
        }
        else 
            System.out.println("Command not Found try the -help- command ");
            return null;
    }

    }


