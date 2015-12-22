package src.adaptivehuffman;
public class Node {
        public String letter;
        public int frequency; 
        public Node left;
	public Node right;
	public Node parent;
        
      
	Node(String letter, int frequency){
		this.frequency = frequency;
		this.letter = letter;
	}
}
