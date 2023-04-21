package sorting;
public class SelectionSort {
	public static void main(String[] args) {
		int[] arr={5,6,9,-2,-9,0};
		selectionSort(arr);
		for(int elem:arr)
		{
		    
		 System.out.print(elem+" ");    
		}
	}
	
	//Standard selection sort
	public static void selectionSort(int[] arr)
	{
	 for(int i=0;i<arr.length-1;++i)
	 {
	   int mindex=i;
	   for(int j=i;j<arr.length;++j)
	   {
	    int current=arr[j];
	    if(arr[mindex]>current)
	    {
	      mindex=j;    
	    }      
	   }
	  int temp=arr[mindex];
	  arr[mindex]=arr[i];
	  arr[i]=temp;      
	 }   
	}
}