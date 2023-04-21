public class BinarySearch {
	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,6,7};
		System.out.println(binarySearchLooping(arr,7)); 
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
}