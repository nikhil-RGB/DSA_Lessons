package data_structures;

import java.util.Optional;

public class LinkedListNode<V> {
	private V value;
	private LinkedListNode<V> next;
	public LinkedListNode(V value,LinkedListNode<V> next) 
	{
		
	}
	public Optional<LinkedListNode> getNext()
	{
		return Optional.ofNullable(this.next);
	}
	public V getValue()
	{
		return this.value;
	}
	public void setValue(V value) 
	{
	this.value=value;
	}
 
}

