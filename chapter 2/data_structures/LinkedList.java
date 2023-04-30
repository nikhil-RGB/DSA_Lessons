package data_structures;
import java.util.Optional;
public class LinkedList<V> {
LinkedListNode<V> head;
//Initializes a linked list with a null head pointer
public LinkedList()
{
 this.head=null;	
}
//adds an element to the front of the linked list by setting head to the new node, and setting next pointer for the 
//new node to the original head. 
public LinkedListNode<V> addFront(V data)
{
LinkedListNode<V> node=new LinkedListNode<V>(data,this.head);
 this.head=node;
 return node;
}
//deletes the front-most element by setting the head pointer to the original heads' next node, and deleting the original head's next pointer(making it null)
public void deleteFront() 
{
Optional<LinkedListNode<V>> initial_node=Optional.ofNullable(this.head);
this.head=initial_node.flatMap(LinkedListNode::getNext).orElse(null);
initial_node.ifPresent(n->n.setNext(null));
}
//finds an element in the linked list via linear traversal.
//returns the node wrapped in an optional if found, or an empty optional if not found.
public Optional<LinkedListNode<V>>  find(V value)
{
Optional<LinkedListNode<V>> node=Optional.ofNullable(this.head);
while(node.filter((n)->{return !n.getValue().equals(value);}).isPresent()) 
{
 node=node.flatMap(LinkedListNode::getNext);	
}
return node;
}
//this functions adds a linked list node after a particular node in the list
public void addAfter(LinkedListNode<V> anode,V item) 
{
 anode.setNext(new LinkedListNode<V>(item,anode.getNext().orElse(null)));	
}

//This function appends all the linked list elements into a string, seperated by a space
public String toString() 
{
 String s="";
 Optional<LinkedListNode<V>> node=Optional.ofNullable(this.head);
 while(node.isPresent()) 
 {
	 s+=node.get().getValue().toString()+" ";
	 node=node.get().getNext();
 }
 return s;
}

public static void main(String[] args) 
{
LinkedList<String>	 arr= new LinkedList<>();
arr.addFront("friend");
LinkedListNode node=arr.addFront("good");
arr.addFront("my");
arr.addFront("hi");
arr.addAfter(node, "69");
System.out.println(arr.toString());
}



}
