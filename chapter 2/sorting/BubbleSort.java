package sorting;
public class BubbleSort {
	public static void main(String[] args) 
	{
		int[] arr={5,7,8,1,10,-2,9,11,0};
		sortImprovement2(arr);
		for(int elem:arr)
		{
		System.out.print(elem+" ");    
		}
	}
	public static void standardBubbleSort(int[] array)
	{
	 for(int i=0;i<array.length;++i)
	 {
	   for(int j=0;j<array.length-1;++j)
	   {
	    int current=array[j];
	    int next=array[j+1];
	    if(current>next)
	    {
	    array[j]=array[j+1];
	    array[j+1]=current;    
	    }     
	   }    
	 }   
	}
	
	static void improvement1(int[] array)
	{
	    for(int i=0;i<array.length;++i)
	 {
	   for(int j=0;j<array.length-i-1;++j)
	   {
	    int current=array[j];
	    int next=array[j+1];
	    if(current>next)
	    {
	    array[j]=array[j+1];
	    array[j+1]=current;    
	    }     
	   }    
	 } 
	}
	//checking if during one pass, no swapping has occured, and if so- stop the sort
	static void sortImprovement2(int[] arr)
	{
	    int i=0;
	    boolean swapOccured=true;
	    while(swapOccured)
	    {
	    swapOccured=false;
	    for(int j=0;j<arr.length-i-1;++j)
	    {
	     if(arr[j]>arr[j+1])
	     {
	       int temp=arr[j];
	       arr[j]=arr[j+1];
	       arr[j+1]=temp;
	       swapOccured=true;    
	     }     
	    }
	    ++i;    
	    }
	    
	}
}