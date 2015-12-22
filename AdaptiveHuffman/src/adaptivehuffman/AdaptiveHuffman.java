package src.adaptivehuffman;
import java.util.*;
import java.io.*;
public class AdaptiveHuffman {
 
     private Node root;
    private Node nytNode; 
     private ArrayList<String>shortCode;
      private  ArrayList<Character> alpha;
    private char[] codeStr; 
    private ArrayList<Character> alreadyExist; 
    private String resulting;
    ArrayList<Node> nodeList;
    private String tempCode = ""; 
    
    public AdaptiveHuffman(char[] codeStr){  
        this.codeStr = codeStr;
        alreadyExist = new ArrayList<Character>();
        nodeList = new ArrayList<Node>();
       shortCode=new ArrayList<String>();
        alpha=new ArrayList<Character>();
        resulting="";
        nytNode = new Node("NEW", 0);
        nytNode.parent = null;
        root = nytNode;
        nodeList.add(nytNode); 
    }
    
    public void init()
    { this.codeStr = codeStr;
        alreadyExist = new ArrayList<Character>();
        nodeList = new ArrayList<Node>();
        nytNode = new Node("NEW", 0);
        nytNode.parent = null;
        root = nytNode;
        nodeList.add(nytNode);    
    }
    
    public  double log2(int n)
   {
    return (Math.log(n) / Math.log(2));
   }
   
    private void swapNode(Node n1, Node n2) {
       
        int i1 = nodeList.indexOf(n1);
        int i2 = nodeList.indexOf(n2);
        nodeList.remove(n1);
        nodeList.remove(n2);
        nodeList.add( i1, n2);
        nodeList.add( i2, n1);
        Node p1 = n1.parent;
        Node p2 = n2.parent;
        
        if ( p1!=p2 ) {
            if ( p1.left==n1 ) {
                p1.left = n2;
            } else {
                p1.right = n2;
            }

            if ( p2.left==n2 ) {
                p2.left = n1;
            } else {
                p2.right = n1;
            }
        } else { 
            p1.left = n2;
            p1.right = n1;
        }
        n1.parent = p2;
        n2.parent = p1;
    
    }
    
    
    private void setTreeCode(Node node, String letter, String code) {
        
        if ( node.left==null && node.right==null ) {
            if ( node.letter!=null && node.letter.equals(letter) )
                tempCode = code;
       
        } else {
            if ( node.left!=null ) {
                setTreeCode(node.left, letter, code + "0");
            }
            if ( node.right!=null ) {
                setTreeCode(node.right, letter, code + "1");
            }
        }  
    }
    private int count=0;
  
    public  String toShortcode(int decimal){
        String result = "";
         double x=log2(alpha.size());
         
         if(x%2!=0)
         {x=(int)x;
         x++;}
        
        for ( int i=0; i<2; i++ ) {
            if ( decimal%2==0 )
                result = "0" + result;
            else 
                result = "1" + result;
            decimal /= 2;
        }
        shortCode.add(count,result);
        
        count++;
        return result;
    }
    
   
     private String getCode(char c){
        tempCode = "";
        
        setTreeCode(root, String.valueOf(c), "");
        String result = tempCode;
        if ( result=="" ) {
           setTreeCode(root, "NEW", "");
            result = tempCode;
            result += toShortcode( alpha.indexOf(c) );
        }
        System.out.println("Letter: "+c+"   code is :" +result);
        return result;
    }
    
     
    private Node findNode(char c) {
        String temp = String.valueOf(c);  
        Node tempNode = null;
        for ( int i=0; i<nodeList.size(); i++ ) {
            tempNode = nodeList.get(i);
            if ( tempNode.letter!=null && tempNode.letter.equals(temp) )
                return tempNode;
        }
        return null;
    }
      
       
    private String getChar(int index) {
     return String.valueOf(alpha.get(index));
    }
  
     private String getSymbol(Node p) {
        if ( p.letter==null ){
            return null;
        } 
        return p.letter;
    }
        
    
     private boolean isAlreadyExist(char temp) {
        for ( int i=0; i<alreadyExist.size(); i++ ) {
            if ( temp==alreadyExist.get(i) )
                return true;
        }
        return false;
    }
     
     
  
     private Node checkFreqSwap(int frequency) {
        Node temp = null;
        for ( int i=nodeList.size()-1; i>=0; i--) {
            temp = nodeList.get(i);
            if ( temp.frequency==frequency )
                break;
        }
        return temp;
    }
     
     private void updateTree(char c){
        Node toBeAdd = null;
        if ( !isAlreadyExist(c) ){
            Node innerNode = new Node(null, 1);
            Node newNode = new Node(String.valueOf(c), 1);
            
            innerNode.left = nytNode;
            innerNode.right = newNode;
            innerNode.parent = nytNode.parent;
            if ( nytNode.parent!=null )
                nytNode.parent.left = innerNode;
            else {
                root = innerNode;
            }
            nytNode.parent = innerNode;
            newNode.parent = innerNode;

            nodeList.add(1, innerNode);
            nodeList.add(1, newNode);
            alreadyExist.add(c);
            toBeAdd = innerNode.parent;
        } else {
            toBeAdd = findNode(c);
        }
        
        while ( toBeAdd!=null ) {
            Node bigNode = checkFreqSwap(toBeAdd.frequency);
            if ( toBeAdd!=bigNode && toBeAdd.parent!=bigNode && bigNode.parent!=toBeAdd)
                swapNode(toBeAdd, bigNode );
            toBeAdd.frequency++;
            toBeAdd = toBeAdd.parent;
        }
        
    }
     
    
     public ArrayList<String> compress(){
        ArrayList<String> result = new ArrayList<String>();
        char temp = 0;
        int j=0;
        String c="";
               for ( int i=0; i<codeStr.length-1; i++ ) 
        {
            temp = codeStr[i];
           if(alpha.indexOf(temp)==-1)
           {
               alpha.add(j,temp);
               j++;
            }
        }
        for ( int i=0; i<codeStr.length-1; i++ ) {
            temp = codeStr[i];
            if(i+1!=codeStr.length)
            c=getCode(temp);
             System.out.println("char :"+temp);
              System.out.println("code :"+c);
            result.add(c);
            resulting+=c;
            updateTree(temp);
        }
        
        return result;
    }
     int count2=0;
     
      public String decompress(){
         init();
		String result = "";
		String symbol = null;
		char temp = 0;
		Node p = root;

		
		symbol = getChar(0);
		
		result += symbol;
		updateTree( symbol.charAt(0) );
		p = root;
		char []codestr=resulting.toCharArray();
		 System.out.println(codestr);
		double x=log2(alpha.size());
         count2++;
         if(x%2!=0)
         {x=(int)x;
         x++;}
		int y=(int)x;
		for ( int i=2; i<codestr.length; i++ ) {
			temp = codestr[i];
			
			//System.out.println("temp"+temp);
			if ( temp=='0' ){
				p = p.left;
			}
			else 
				p = p.right;
			
			symbol = getSymbol(p);
			//System.out.println("Symbol= "+symbol);
			
			if ( symbol!=null ){
				if ( symbol=="NEW" ){
					symbol = getChar(count2);
					//System.out.println("Ascci "+getChar(count2));
					i+=2;
					count2++;
				}
				result+=symbol;
				updateTree( symbol.charAt(0) );
				p = root;
			}
		}
		
		return result;
	}
       
      
      private static String castStr(ArrayList<String> l) {
        String result = "";
        for ( String s: l ){
            result += s;
        }
        return result;
    } 
       
    public static void main(String[] args) {
    
        String text = FileHandler.readFile("data.txt");
       
        
        System.out.println(text);    
        AdaptiveHuffman huffman = new AdaptiveHuffman( text.toCharArray() );
        ArrayList<String> code = huffman.compress();
        FileHandler.writeFile("output.txt", castStr(code));
        
        
        
        System.out.println(castStr(code));
        String decomp = FileHandler.readFile("output.txt");
        
        String result = huffman.decompress();
        System.out.println("DeCode "+result);
        FileHandler.writeFile("decompressed_file.txt", result);
        
        
    }
}
