package data_structures;

import java.util.ArrayList;
import java.util.Optional;

public class Queue<V> {
DblLinkedListNode<V> head;
DblLinkedListNode<V> tail;
public Queue() {
	head=null;
	tail=null;
}
//This is used to put an item into the queue(FIFO)
public void enqueue(V item) 
{
DblLinkedListNode<V> node=new DblLinkedListNode<>(item,null,tail);	
Optional.ofNullable(tail).ifPresent((val)->{tail.setNext(node);});
tail=node;
if(head==null) 
{
head=node;	
}
}

//This function is used to dequeue an item from a queue
public Optional<V> dequeue() 
{
 	Optional<DblLinkedListNode> node=Optional.ofNullable(head);
 	  head = (DblLinkedListNode<V>) node.flatMap(DblLinkedListNode::getNext).orElse(null);
 	  Optional.ofNullable(head).ifPresent((val)->{
 		  val.setPrevious(null);
 	  });
 	 if (head == null) tail = null;
 	  return (Optional<V>) node.map(DblLinkedListNode::getValue);
}

//stuffs all the items from the queue into a good old array list
public ArrayList<V> list()
{
ArrayList<V> result=new ArrayList<>(0);
Optional<DblLinkedListNode> node=Optional.ofNullable(head);
while(node.isPresent()) 
{
   V item=(V) node.get().getValue();
   result.add(item);
   node=node.get().getNext();
}
return result;
}

//examine the list
public void examine() 
{
    System.out.println("Elements are:");
    for(V b:this.list()) 
    {
    	System.out.print(b+ " ");
    }
    System.out.println();
}
//for testing
public static void main(String[] args) {
    Queue<String> q = new Queue<>();
    q.enqueue("1");
    q.enqueue("2");
    q.enqueue("3");
      
    q.examine();
    
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());

    q.enqueue("0");
    q.examine();

    System.out.println(q.dequeue());
    System.out.println(q.dequeue());

}

}
