package data_structures;

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
public void dequeue() 
{
 	

}
}
