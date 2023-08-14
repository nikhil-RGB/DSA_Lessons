package data_structures;

import java.util.Optional;

public class StackArray<V> {
	int head=0;//Pointer for first stck element position
	V[] arr;
	//Main method for testing
	public static void main(String[] args) 
	{
		StackArray<String> strs=new StackArray<>(10);
		strs.push(" Hello ");
		strs.push(" World");
		strs.push(" !! ");
		String res="";
		res+=strs.pop().orElse("EMPTY");
		res+=strs.pop().orElse("EMPTY");
		res+=strs.pop().orElse("EMPTY");
		res+=strs.pop().orElse("EMPTY");
	    System.out.println(res);
	}
	
	//Constructor for default capacity of 0
	@SuppressWarnings("unchecked")
	public StackArray() 
	{
		arr=(V[])(new Object[0]);
		
	}
	//Constructor which allows you to specify size
	@SuppressWarnings("unchecked")
	public StackArray(int capacity)
	{
		arr=(V[])(new Object[capacity]);
	}
	//This method pushes an element into the stack
	public void push(V item) 
	{
		arr[head++]=item;
	}
	//This method is for removing an element from the top of the stack
	public Optional<V> pop() 
	{
		if(head>0) {
			return Optional.of(arr[--head]);
		}
		else 
		{
			return Optional.empty();
		}
	}

}
