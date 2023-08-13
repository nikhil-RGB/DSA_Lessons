package data_structures;
import java.util.Optional;
public class Stack<V> {
	private LinkedListNode<V> head;
	public Stack() 
	{
		super();
	}
	public void push(V item) 
	{
		head=new LinkedListNode<V>(item,head);
	}
	public Optional<V> pop()
	{
		Optional<LinkedListNode<V>> node= Optional.ofNullable(head);
		head=node.flatMap(LinkedListNode::getNext).orElse(null);
		return node.map(LinkedListNode::getValue);
	}

}
