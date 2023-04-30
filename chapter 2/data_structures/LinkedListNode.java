package data_structures;

import java.util.Optional;

public class LinkedListNode<V> {
	private V value;
	private LinkedListNode<V> next;
	public LinkedListNode(V value,LinkedListNode<V> next) 
	{
		this.value=value;
		this.next=next;
	}
	public Optional<LinkedListNode<V>> getNext()
	{
		return Optional.ofNullable(this.next);
	}
	public V getValue()
	{
		return this.value;
	}
	public LinkedListNode<V> setValue(V value) 
	{
	this.value=value;
	return this;
	}
    public LinkedListNode<V> setNext(LinkedListNode<V> node)
    {
    	this.next=node;
    	return this;
    }
}

