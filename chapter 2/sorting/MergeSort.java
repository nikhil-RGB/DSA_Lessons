package sorting;
public class MergeSort
{
  public static void main(String[] args) 
  {
	int array[]= {1,2,0,9,6,-1,-2,11,10,8};
	mergeSort(array);
	for(int elem:array) 
	{
		System.out.print(elem+ " ");
	}
  }
  //Splits the array into halves recursively, and then uses the merge method to recombine them after sorting.
  public static void mergeSort(int array[]) 
  {
	  int length=array.length;
	  if(length==1) 
	  {
		  return;
	  }
	  int middle=length/2;
	  int[] left=new int[middle];
	  int[] right=new int[length-middle];
	  int r=0,l=0;
	  for(int i=0;i<array.length;++i) 
	  {
		  if(l<middle) 
		  {
			  left[l]=array[i];
			  ++l;
		  }
		  else 
		  {
			  right[r]=array[i];
			  ++r;
		  }
	  }
	  mergeSort(left);
	  mergeSort(right);
	  merge(left,right,array);
  }
  //standard merge for two sorted sub-arrays.
  private static void merge(int[] leftArray,int[] rightArray,int[] array) 
  {
	int leftSize=leftArray.length;
	int rightSize=rightArray.length;
	int l=0,r=0;
	int i=0;
	for(;(l<leftSize)&&(r<rightSize);++i) 
	{
		if(leftArray[l]<rightArray[r]) 
		{
		array[i]=leftArray[l];
		++l;
		}
		else 
		{
			array[i]=rightArray[r];
			++r;
		}
	}
	
	while(l<leftSize) 
	{
		array[i]=leftArray[l];
		++l;
		++i;
	}
	while(r<rightSize) 
	{
		array[i]=rightArray[r];
		++r;
		++i;
	}
  }
}