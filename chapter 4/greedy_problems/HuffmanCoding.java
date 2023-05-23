package greedy_problems;
import java.util.*;
public class HuffmanCoding
{
	
//static inner class node, used to represent an instance of a node in the huffman decoding tree,
//follows max heap property for sum of values(frequency)
 static class Node
 {
	 public Node right;//Node to the immediate right of the current node
	 public Node left;//Node to the left of the current node
	 public Character chr;//character held by this node
	 public int frequency;//frequency of character in this node/value of the node
	 
	 {
		 right=null;
		 left=null;
		 chr=null;
		 frequency=0;
		 
	 }
	
 }
 
 //builds a Huffman decoding tree and returns the root
 public static Node build(Map<Character,Integer> freqs) 
 {
	 int n=freqs.size();
	 PriorityQueue<Node> pq=new PriorityQueue<>(n,(node1,node2)->{return Integer.signum(node1.frequency-node2.frequency);});
	 //This loop initializes the priority queue with all the leaf nodes(which have characters)
	 for(Map.Entry<Character,Integer> entry:freqs.entrySet())
	 {
		 Node node=new Node();
		 node.chr=entry.getKey();
		 node.frequency=entry.getValue();
		 pq.add(node);
	 }
	 
	 //This loop now adds internal nodes to the priority queue
	 for(int i=0;i<n-1;++i) 
	 {
		 Node current=new Node();
		 Node left=pq.remove();
		 Node right=pq.remove();
		
		 current.left=left;
		 current.right=right;
		 current.frequency=left.frequency+right.frequency;
		 
		 pq.add(current);
	 }
	 
	 //finally, return the root of the tree
	 return pq.remove();
	 
 }
 
 //decodes a binary code into it's text equivalent
 public static String decode(String encoded,Node current,Node root,String decoded) 
 {
	 //leaf node, reached and a character has been decoded, add character and goto root
	 //node
	 if(current.chr!=null) 
	 {
		 return decode(encoded,root,root,decoded+current.chr);
	 }
	 //if the encoded string is empty, it means there is no more content to encode, return the decoded string
	 //exit case for recursion
	 if(encoded.isEmpty()) 
	 {
		 return decoded;
	 }
	 //if the encoded string has a 0 then move left, else move right
	 if(encoded.charAt(0)=='0')
	 {
		 return decode(encoded.substring(1),current.left,root,decoded);
	 }
	 else 
	 {
		 return decode(encoded.substring(1),current.right,root,decoded);
	 }
	 
 }
 
 public static void main(String[] args) 
 {
	   Map<Character, Integer> frequencies = new HashMap<>();
       frequencies.put('a', 45000);
       frequencies.put('b', 13000);
       frequencies.put('c', 12000);
       frequencies.put('d', 16000);
       frequencies.put('e', 9000);
       frequencies.put('f', 5000);
       String encoded="001011101";
       String a_to_f="010110011111011100";
       Node root=HuffmanCoding.build(frequencies);
       System.out.println("Decoded value for huffman encoded 001011101 is\n"+HuffmanCoding.decode(a_to_f, root, root,""));
	 
 }
 
 
}