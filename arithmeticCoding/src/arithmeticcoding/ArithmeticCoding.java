package src.arithmeticcoding;
import java.awt.geom.Point2D;
import java.io.*;
import java.util.*;
public class ArithmeticCoding {
    public static void main(String[] args) throws FileNotFoundException ,IOException {       
      HashMap <Character, Point2D.Double> hashmap = new HashMap<Character, Point2D.Double>();
      char c='a';
      String line;
      File input = new File("input.txt");
      Scanner cin = new Scanner(input);
      ArrayList<Character>chr = new ArrayList<Character>();
      ArrayList<Character>computed = new ArrayList<Character>();
     while(cin.hasNext()){
            line=cin.nextLine();
 
         for(int i=0 ; i<line.length() ; i++)      
             chr.add(line.charAt(i));
     }        
        System.out.println("char:= "+chr);
        FileWriter fileWriter =new FileWriter("prob.txt");
        BufferedWriter bufferWrite=new BufferedWriter(fileWriter);
        for(int i=0 ; i<chr.size() ; i++){
               if(!computed.contains(chr.get(i))){
                    int count=0;
        for(int k=0 ; k<chr.size() ; k++)  
               if(chr.get(k)==chr.get(i))
                   count+=1;
        ///////////////////////////////////////////////////////////////////////////////
        System.out.println("Char Now :::"+chr.get(i));
        /////////////////////////////////////////////////////////////////////////////
        Double prob = (double)count/(double)chr.size();
        ///////////////////////////////////////////////////////////////////////////////
        System.out.println("Prob:= "+prob);
        if(hashmap.size()>0) 
        {
           hashmap.put(chr.get(i), new Point2D.Double(hashmap.get(c).y  , hashmap.get(c).y + prob) );
           //Write on file
           //////////////////////////////////////////////////////////////////////////////
            System.out.println("HashMap"+hashmap);
            bufferWrite.write(chr.get(i));
            bufferWrite.write(",");
            bufferWrite.write(prob.toString());
            bufferWrite.write(",");
            bufferWrite.write((hashmap.get(c).y)+"");
            bufferWrite.write(",");
            bufferWrite.write( (hashmap.get(c).y + prob)+"");
            bufferWrite.append(System.lineSeparator());
            bufferWrite.flush();
         ///////////////////////////////////////////////////////////////////////////
         
          System.out.println("D1 Hash: "+chr.get(i));
          System.out.println("D2 Hash: "+hashmap.get(chr.get(i)));
          System.out.println("D12dx: "+hashmap.get(c).x);
          System.out.println("D12dy: "+hashmap.get(c).y);
        }  else{
              hashmap.put(chr.get(i), new Point2D.Double(0.0  , prob ));  
              //Write on file
              //////////////////////////////////////////////////////////////////////////////////////////////////
              System.out.println("HashMap"+hashmap);
              bufferWrite.write(chr.get(i));
              bufferWrite.write(",");
              bufferWrite.write(prob.toString());
              bufferWrite.write(",");
              double x=0.0;
              bufferWrite.write(x+"");
              bufferWrite.write(",");
              bufferWrite.write( prob+"");
              bufferWrite.append(System.lineSeparator());
              bufferWrite.flush();
              System.out.println("D1 Hash: "+chr.get(i));
              System.out.println("D2 Hash: "+hashmap.get(chr.get(i)));
              //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    }
    computed.add(chr.get(i)); 
     c=chr.get(i);
  }}

  
  
  

   //////////////////////////////// ////////////////////////////////////
   Scanner input2=new Scanner(input);
   Double Low=0.0 , High=1.0 , Range=0.0;    
   while(input2.hasNext()){
    line=input2.nextLine();
      for(int i=0 ; i<line.length() ; i++){
          char ch=line.charAt(i);
           Range=High-Low;
           High = Low + Range * hashmap.get(ch).y;
           Low  = Low + Range * hashmap.get(ch).x;
    }}
   input2.close();
   Double compress_code = (Low+High)/2.0;
   System.out.println("compression code = "+ compress_code);
        
        //////////////////////////////////////// //////////////////////////
   FileInputStream f= new FileInputStream("prob.txt");
   BufferedReader br = new BufferedReader(new InputStreamReader(f));
   String strline;
   StringBuffer sb = new StringBuffer();
   String Character , Proba , LOWER , UPPER;
   int k=0;
     ////////////////////////////////////////////////////////////////
    Character x='m';
    double LOW=0.0;
    double P=0.0;
    double UP=1.0;
    HashMap <Character, Point2D.Double> hashmap2= new HashMap<Character, Point2D.Double>();
     while ((strline = br.readLine()) != null)
      {
        String[] arraylist=strline.split(",");
    
          if(arraylist.length == 4){
        
            Character=arraylist[0];
            Proba=arraylist[1];
            LOWER=arraylist[2];
            UPPER=arraylist[3];
            x=Character.charAt(0);
            LOW=Double.parseDouble(LOWER);
            UP=Double.parseDouble(UPPER);
            P=Double.parseDouble(Proba);

              }
        
         hashmap2.put(x, new Point2D.Double( LOW  , UP) );
        }
        
        System.out.print("HM@ : "+hashmap2);
        ////////////////////////////////////////////////////////////////////

       Scanner in=new Scanner(input);
   
       String ans="";
       Double value = compress_code;
       while(in.hasNext()){
        line=in.nextLine();
        System.out.println("in :"+line);
         for(int i=0 ; i<line.length() ; i++){
         
          Iterator it = hashmap2.entrySet().iterator();
          System.out.println("entrySet :"+hashmap2.entrySet());
          System.out.println("entrySet.iterator :"+ hashmap2.entrySet().iterator());
          System.out.println("it :"+it);
          Character ch = null;
          while(it.hasNext())
           {
            Map.Entry entry =(Map.Entry)it.next();
            System.out.println("Map.Entry :"+entry);
            ch=(Character)entry.getKey();
            if(value>=hashmap2.get(ch).x && value<=hashmap2.get(ch).y )
                break;
       }
     
        value-= hashmap2.get(ch).x;
        value/= ( hashmap2.get(ch).y - hashmap2.get(ch).x );
        System.out.println("encoding value = "+value);
        ans+=ch;
    }}
        System.out.println(ans);
        FileWriter fileWriter2 =new FileWriter("out.txt");
        BufferedWriter bufferWrite2=new BufferedWriter(fileWriter2);
        bufferWrite2.flush();
        bufferWrite2.write(ans+"");
        bufferWrite2.flush();
        
    }
}

