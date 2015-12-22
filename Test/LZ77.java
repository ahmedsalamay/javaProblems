import java.util.ArrayList;
import java.util.List;

public class LZ77 {

    public List<LZ77Tupel> compress(String text) {

        List<LZ77Tupel> list = new ArrayList<LZ77Tupel>();
        String search = "";
        String input = text;

        String next;
        int indexGood = 0;
        int indexFound;
        int searchLen;

        while (input.length() > 0) {
            searchLen = 1;
            next = input.substring(0, searchLen);
            if (search.indexOf(next) == -1) {
                list.add(new LZ77Tupel(next));
                search += next;
                input = input.substring(searchLen);
                continue;
            }
            do {
                next = input.substring(0, searchLen);
                indexFound = search.indexOf(next);
                if (indexFound != -1)
                    indexGood = indexFound;
                searchLen++;
            } while (indexFound != -1);
            search += next.substring(0, next.length());
            input = input.substring(next.length());
            list.add(new LZ77Tupel(indexGood, next.length() - 1, next
                    .substring(next.length() - 1)));

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