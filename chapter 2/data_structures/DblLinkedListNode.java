package data_structures;
import java.util.*;
//an object of this class represents a Doubly-linked list node
public class DblLinkedListNode<V>
{
  private V value;
  private DblLinkedListNode<V> next;
  private DblLinkedListNode<V> previous;
  public DblLinkedListNode(V value,DblLinkedListNode previous,DblLinkedListNode next)
  {
	  this.next=next;
	  this.previous=previous;
	  this.value=value;
  }
  //Returns value of current node
  public V getValue()
  {
   return this.value;    
  }
  //setter for value of current node
  public void setValue(V val)
  {
  this.value=val;    
  } 
  public Optional<DblLinkedListNode<V>> getNext()
  {
   return Optional.ofNullable(this.next);   
  }
  public void setNext(DblLinkedListNode<V> value)
  {
   this.next=value;    
  }
  public Optional<DblLinkedListNode<V>> getPrev()
  {
   return Optional.ofNullable(this.previous);    
  }
  
  
  
}
