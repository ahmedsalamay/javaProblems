import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.io.*;
public class LZ77 {

    public LZ77(){
    }
    public List<LZ77Tupel> compress(String text) {

        List<LZ77Tupel> list = new ArrayList<LZ77Tupel>();
        String windowBuffer = "";
        String input = text;

        String lookAheadBuffer;
        int indexFound2 = 0;
        int indexFound;
        int searchLen;
        int pointer=0;

        while (input.length() > 0) {
            searchLen = 1;
            lookAheadBuffer = input.substring(0, searchLen);
            if (windowBuffer.lastIndexOf(lookAheadBuffer) == -1) {
                list.add(new LZ77Tupel(0,0,lookAheadBuffer));
                windowBuffer += lookAheadBuffer;
                input = input.substring(searchLen);
                pointer++;
                continue;
               
            }
               do {
                lookAheadBuffer = input.substring(0, searchLen);
                indexFound = windowBuffer.lastIndexOf(lookAheadBuffer);
                  
                if (indexFound != -1)
                   { indexFound2 = indexFound;
                       if(input.length() == searchLen)
                       pointer--;
                      pointer++;
                    }
                searchLen++;
               /* if(input.length() == searchLen)
                pointer--;*/
                 
               } while (indexFound != -1&&input.length() >= searchLen);
               windowBuffer += lookAheadBuffer.substring(0, lookAheadBuffer.length());
               input = input.substring(lookAheadBuffer.length());
                 pointer++;
                list.add(new LZ77Tupel(pointer-indexFound2-searchLen+1, lookAheadBuffer.length() - 1, lookAheadBuffer .substring(lookAheadBuffer.length() - 1)));
              
        }
        return list;
    }

    public String decompress(List<LZ77Tupel> list) {
        String out = "";
        
        for (LZ77Tupel t : list) {
            if (t.getIndex() == 0 && t.getLength() == 0)
                out += t.getString();
            else
                out += out.substring(out.length()-t.getIndex(), out.length()-t.getIndex()+t.getIndex()) + t.getString();
        }
        return out;
    }
}