package examples;

public class MaxElementArray {

	public static void main(String[] args) {
		int[] arr= {3,4,5,6,7,11,-2};
        findMax(arr);
	}
	
 public static int findMax(int arr[]) 
	{
		int max=arr[0];//array
		for(int i=0;i<arr.length;++i)
		{
		  int element=arr[i];
		  if(element>max)
		  {
		    max=element;
		  }
		}
		System.out.println(max+" is the maximum element in the array");
		return max;
	}

}
