package src.LZ77;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.io.*;
public class LZ77Fun {

    public LZ77Fun(){
    }
    public static List<LZ77Tupel> compress(String text) {

        List<LZ77Tupel> list = new ArrayList<LZ77Tupel>();
        String windowBuffer = "";
        String input = text;

        String lookAheadBuffer;
        int indexFound2 = 0;
        int indexFound;
        int searchLen;

        while (input.length() > 0) {
            searchLen = 1;
            lookAheadBuffer = input.substring(0, searchLen);
            if (windowBuffer.indexOf(lookAheadBuffer) == -1) {
                list.add(new LZ77Tupel(0,0,lookAheadBuffer));
                windowBuffer += lookAheadBuffer;
                input = input.substring(searchLen);
                continue;
            }
               do {
                lookAheadBuffer = input.substring(0, searchLen);
                indexFound = windowBuffer.indexOf(lookAheadBuffer);
                if (indexFound != -1)
                    indexFound2 = indexFound;
                searchLen++;
               } while (indexFound != -1&&input.length() >= searchLen);
               windowBuffer += lookAheadBuffer.substring(0, lookAheadBuffer.length());
               input = input.substring(lookAheadBuffer.length());
                list.add(new LZ77Tupel(indexFound2, lookAheadBuffer.length() - 1, lookAheadBuffer .substring(lookAheadBuffer.length() - 1)));
        }
        return list;
    }

    public String decompress(List<LZ77Tupel> list) {
        String out = "";
        
        for (LZ77Tupel t : list) {
            if (t.getIndex() == 0 && t.getLength() == 0)
                out += t.getString();
            else
                out += out.substring(t.getIndex(), t.getIndex()+t.getLength()) + t.getString();
        }
        return out;
    }
}
	