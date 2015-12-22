
/**
 * Write a description of class AdaptiveHuffman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AdaptiveHuffman
{
    
        private Node nytNode;
        private Node root;
        private char[] codeStr;
        private ArrayList<Character> alreadyExist;
         ArrayList<Node> nodeList;
         private String tempCode = "";
         public AdaptiveHuffman(char[] codeStr){
                this.codeStr = codeStr;
                alreadyExist = new ArrayList<Character>();
                nodeList = new ArrayList<Node>();
                
                //Initialize the nyt Node.
                nytNode = new Node("NEW", 0);
                nytNode.parent = null;
                root = nytNode;
                nodeList.add(nytNode);
        }
         

    /**
     * Constructor for objects of class AdaptiveHuffman
     */
    public AdaptiveHuffman()
    {
        
    }

    
}
