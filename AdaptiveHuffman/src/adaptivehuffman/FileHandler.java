package src.adaptivehuffman;

import java.io.*;
import java.util.*;
public class FileHandler {

    private FileHandler(){} 
    
    

public static String readFile(String path){
		String result = "";
		try {
			FileReader fileWrite= new FileReader(path);
			BufferedReader bufferWrite  = new BufferedReader(fileWrite);
			String temp = null;
			
			
				while ( ( temp=bufferWrite .readLine() ) !=null ){
					result += (temp+"\n");
			
			} 
		
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return result;
	} 


   public static void writeFile(String filename, String text){
		try {
			FileWriter fileWrite = new FileWriter(filename);
			BufferedWriter bufferWrite = new BufferedWriter(fileWrite);
			char[] str = text.toCharArray();
			
			for ( int i=0; i<str.length; i++ ) {
			
				bufferWrite.append(str[i]);
			}
			bufferWrite.close();
			fileWrite.close();
			
			System.out.println("Done");
		} catch (IOException e) {

			e.printStackTrace();
		}
	} 

   
 
    
}
