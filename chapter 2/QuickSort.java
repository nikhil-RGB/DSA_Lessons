public class QuickSort
{
  //partitions the array using LOMUTO partition scheme
  public static int lomutoPartition(int[] nums,int start,int end)   
    {
      int pivot=nums[end];//last element as pivot]
      int x=start-1;//x is 1 below start
      for(int i=start;i<end;++i)
      {
       if(nums[i]<pivot)
       {
           ++x;
           int temp=nums[x];
           nums[x]=nums[i];
           nums[i]=temp;   
        }  
       }
       x++;
       int temp=nums[x];
       nums[x]=nums[end];
       nums[end]=temp;    
       return x;
     }
     
    
     
     public static void quickSort(int[] nums,int start,int end)
     {
      printArray(nums);
      if(start<end)
      {
      int p=lomutoPartition(nums,start,end);
      quickSort(nums,start,p-1);
      quickSort(nums,p+1,end);   
      }
      }
      public static void main(String[] args)
      {
          //test array is from 0-10
          int[] array={9,6,3,0,1,4,8,2,7,5,10};
          quickSort(array,0,array.length-1);   
          printArray(array);
       }
       static void printArray(int[] arr)
       {
        for(int elem:arr)
        {
           System.out.print(elem+" ");    
        }   
        System.out.println();
       }         
         
 }