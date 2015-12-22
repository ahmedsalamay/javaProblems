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

////////////////////////////////////////////
package javaapplication_stopwatch;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed
 */
public class Arithimetic 
{
    
    String comp;
    String small;
    double value;
    ArrayList<String>symbols;
    ArrayList<Integer>weight;
    ArrayList<Node>nodes;

    public Arithimetic(String text)
    {
        comp=text;
        symbols=new ArrayList<>();
        weight=new ArrayList<>();
        nodes=new ArrayList<>();
        value=0;
       // System.out.println(comp);
        
    }
    
    public void set_weight()
    {
        int index;
        for(int i=0;i<comp.length();i++)
        {
            if(symbols.indexOf(comp.substring(i, i+1))==-1)
            {
                symbols.add(comp.substring(i, i+1));
                weight.add(1);
            }
            else
            {
                index=symbols.indexOf(comp.substring(i, i+1));
                weight.set(index, weight.get(index)+1);
            }
        }
    }
    

    public int search(String small)
    {
        int index=-1;
        for(int i=0;i<nodes.size();i++)
        {
            if(nodes.get(i).Symbol.equals(small))
            {
                index=i;
                break;
            }
        }
        return index;
    }
    
    public void Comp() throws IOException
    {
        ArrayList<Double>proba=new ArrayList<>();
        double prob;
        Map<String ,Double>ma = new  HashMap();
        for(int i=0;i<symbols.size();i++)
        {
            prob=(double)weight.get(i)/comp.length();
            System.out.println(symbols.get(i)+prob);
            nodes.add(new Node(symbols.get(i),prob));
            //proba.add(prob);
            ma.put(symbols.get(i), prob) ;
        }
        
      
        Writer  w  = new  FileWriter("Dictionary.txt");
        BufferedWriter br  = new  BufferedWriter(w);
        String str = symbols.toString() +proba.toString() ;
        br.write(ma.toString());
        br.close();
        
        
        double total=0;
        for(int i=0;i<nodes.size();i++)
        {
            
            if(i==0)
            {
                nodes.get(i).low=0;
                nodes.get(i).high=nodes.get(i).prob;
            }
            else
            {
                nodes.get(i).low=nodes.get(i-1).high;
                nodes.get(i).high=nodes.get(i).low+nodes.get(i).prob;
            }
            //total+=nodes.get(i).prob;
            //System.out.println(nodes.get(i).Symbol+" low :"+nodes.get(i).low+" hight :"+nodes.get(i).high);
        }
        
        //Scanner cin =new Scanner(System.in);
        //small=cin.next();
        small=comp;
        double lower=0;
        double upper=0;
        double range=0;
        double low=0;
        
        for(int i=0;i<small.length();i++)
        {
            if(i==0)
            {
                
                lower=nodes.get(search(small.substring(i, i+1))).low;
                upper=nodes.get(search(small.substring(i, i+1))).high;
            }
            else
            {
                range=upper-lower;
                low=lower;
                //System.out.println("pre lower "+nodes.get(search(small.substring(i, i+1))).low+"pre upper "+nodes.get(search(small.substring(i, i+1))).high);
                lower=lower+range*(double)nodes.get(search(small.substring(i, i+1))).low;
                upper=low+range*(double)nodes.get(search(small.substring(i, i+1))).high;
            }
            //System.out.println(" lower "+lower+" upper "+upper);
        }
        value=(lower+upper)/2;
        
        String text=String.valueOf(value);
        File out=new File("f1.txt");
        try (FileWriter fw = new FileWriter(out))
        {
            fw.write(text);
            //fw.write("/n");
             fw.close();
       
        //System.out.println("lower"+lower+"upper"+upper);
        }
    }
    
    public int serarch(double val)
    {
        int index=0;
        for(int i=0;i<nodes.size();i++)
        {
            if(val<nodes.get(i).high)
            {
                index=i;
                break;
            }
        }
        return index;
    }
    
    public void decomp() throws IOException
    {
        String data = "";
            try {
            try (BufferedReader in = new BufferedReader(new FileReader("f1.txt"))) {
                String s="";
                while ((s = in.readLine()) != null) {
                    data += s;
                }
            }
            } 
            catch (IOException e1) 
            {
            }
            
            Reader r  = new FileReader("Dictionary.txt");
            BufferedReader b = new  BufferedReader(r);
            String  st  =b.readLine() ;
            System.out.println(st);
            
            ArrayList<String>ls  = new ArrayList();
            ArrayList<Double>ld  = new  ArrayList();
            for(int  i=0 ;i<st.length() ;i++){
                if(Character.isAlphabetic(st.charAt(i))){
                    String  str="";
                    str+=st.charAt(i);
                    ls.add(str);
                    i+=2;
                    str="";
                    Character ch =st.charAt(i)  ;
                     str ="";
                    while(ch!=','&&ch!='}'){
                        str+=ch;
                        ch = st.charAt(i++);
                    }
                    ld.add(Double.parseDouble(str));
                    
                }
            }
            
           nodes.clear();
          System.out.println(ls+"     "+ld+"\n");
          for(int i=symbols.size()-1;i>=0;i--)
          {
            nodes.add(new Node(ls.get(i),ld.get(i)));
          }
          
          
          for(int i=0;i<nodes.size();i++)
          {
            
            if(i==0)
            {
                nodes.get(i).low=0;
                nodes.get(i).high=nodes.get(i).prob;
            }
            else
            {
                nodes.get(i).low=nodes.get(i-1).high;
                nodes.get(i).high=nodes.get(i).low+nodes.get(i).prob;
            }
            
          }
          
        double lower=0;
        double upper=0;
        double val=Double.valueOf(data);
        System.out.println(val);
        double range=0;
        String text="";
        for(int i=0;i<small.length();i++)
        {
            
            if(i==0)
            { 
                text+=nodes.get(serarch(val)).Symbol;
                lower=nodes.get(serarch(val)).low;
                upper=nodes.get(serarch(val)).high;
            }
            else
            {
                range=upper-lower;
                val=(Double.valueOf(data)-lower)/range;
                text+=nodes.get(serarch(val)).Symbol;
                upper=lower+range*nodes.get(serarch(val)).high;
                lower=lower+range*nodes.get(serarch(val)).low;      
            }
            System.out.println(val);
        }
        System.out.println(text);
    }
    
    
}