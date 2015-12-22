    import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args){

        String out="";
       List<LZ77Tupel> list = new ArrayList<LZ77Tupel>();
        LZ77 z=new LZ77();
        list=z.compress("ABCABC");
        for (LZ77Tupel t : list) {
            
                out +="<"+t.getIndex()+" "+t.getLength()+" "+ t.getString()+">\n";
            
        }
        
        System.out.print(out);
        System.out.print(z.decompress(list));
        //
        
    }

}


























/*



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Test {

    /**
     * @param args
     * @throws IOException
     *//*
    public static void main(String[] args) throws IOException {

        
        //Get file
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("te.txt")));
        StringBuffer content = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null)
            content.append(line);
        String message1 = content.toString();
        
        
        
        System.out.println("Message1: " + message1.length() + " characters.");
//      System.out.println("Message2: " + message2.length() + " characters.");
        
        
        LZ77 lz77 = new LZ77();
        
        List<LZ77Tupel> list1 = lz77.compress(message1);
//      List<LZ77Tupel> list2 = lz77.compress(message2);

        System.out.println("Compressed1: " + list1.size() + " tupels.");
//      System.out.println("Compressed2: " + list2.size() + " tupels.");
        
        System.out.println(lz77.decompress(list1));
//      System.out.println(lz77.decompress(list2));
        
    }

}
*/