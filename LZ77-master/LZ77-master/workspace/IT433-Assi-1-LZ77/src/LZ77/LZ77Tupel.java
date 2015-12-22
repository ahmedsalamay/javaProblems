package src.LZ77;

public class LZ77Tupel {
    int index;
    int length;
    String s;
    
    public LZ77Tupel(int index, int length, String s) {
        this.index = index;
        this.length = length;
        this.s = s;
    }
   
    public int getIndex() {
        return index;
    }

    public int getLength() {
        return length;
    }

    public String getString() {
        return s;
    }
    
    
}