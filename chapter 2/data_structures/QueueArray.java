package data_structures;

import java.util.Optional;

public class QueueArray<V> {

	private V[] array;
	private int headPtr=0;
	private int tailPtr=0;
	//main method for testing.
	public static void main(String[] args) {
		 QueueArray<String> q = new QueueArray<>(5);
		    q.enqueue("1");
		    q.enqueue("2");
		    q.enqueue("3");
		    q.enqueue("4");  
		    q.examine();
		    
		    System.out.println(q.dequeue().orElse(null));
		    System.out.println(q.dequeue().orElse(null));
		    System.out.println(q.dequeue().orElse(null));
		    System.out.println(q.dequeue().orElse(null));

		    q.enqueue("0");
		    q.examine();

		    System.out.println(q.dequeue().orElse(null));
		    System.out.println(q.dequeue().orElse(null));

	}
    
	private void examine() {
		
		for(V element:array) {
		System.out.print(element+" ");
		}
		System.out.println();
	}

	//Standard numeric capacity constructor
	public QueueArray(int capacity) 
	{
	        array = (V[]) new Object[capacity];
	}
	//Use this function to enqueue an element into the array
	public void enqueue(V item) 
	{
		array[tailPtr]=item;
		tailPtr=(tailPtr+1)%array.length;
	}
	//Use this function to dequeue an element
	public Optional<V> dequeue()
	{
		if(headPtr!=tailPtr) 
		{
			Optional<V> itm=Optional.ofNullable(array[headPtr]);
			headPtr=(headPtr+1)%array.length;
			return itm;
		}
		else 
		{
			return Optional.empty();
		}
	}
	
}
