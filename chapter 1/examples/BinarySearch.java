package examples;
public class BinarySearch {
	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,6,7};
		System.out.println(binarySearchRecursive(arr,0, arr.length-1, 3)); 
	}
	public static int binarySearchLooping(int[] array,int element)
	{
	   int start=0;
	   int end=array.length-1;
	    while(start<=end)
	    {
	     int mid=(end-start)/2+start;
	    int current=array[mid];
	    if(current==element)
	    {
	     return mid;
	     }       
	     else if(current>element)
	     {
	         end=mid-1;
	        
	     }
	         else{
	             start=mid+1;
	             }
	    
	    }
	    return -1;
	}
	
	public static int binarySearchRecursive(int[] array, int start,int end,int required) 
	{
	 
	  if(start<=end) 
	  {
		  int mid=(end-start)/2+start;
		  int element=array[mid];
		  if(element==required) 
		  {
			  return mid;
		  }
		  else if(element>required)
		  {
			 end=mid-1; 
			 return binarySearchRecursive(array,start,end,required);
		  }
		  else
		  {
			  start=mid+1;
			  return binarySearchRecursive(array,start,end,required);
		  }
	  }
	  return -1;
		
	}
}