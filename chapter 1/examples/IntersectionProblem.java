package examples;

import java.util.ArrayList;
import java.util.Arrays;
public class IntersectionProblem {
	public static void main(String[] args)
	{
	  int[] arr1={2,3,4,5,-1,0};
	  int[] arr2={2,5,-1,0};
	  ArrayList<Integer> ls=fastIntersection(arr2,arr1);  	
		for(Integer number:ls)
		{
		    System.out.println(number);
		    }
	}
	
	//Time coplexity is o(n squared)
	public static ArrayList<Integer> slowIntersection(int[] arr1,int[] arr2)
	{
	   ArrayList<Integer> arrs=new ArrayList<>(0);
	   for(int i=0;i<arr1.length;++i)
	   {
	     int current_element1=arr1[i];
	     for(int j=0;j<arr2.length;++j)
	     {
	       int current_element2=arr2[j];
	       if(current_element1==current_element2)
	       {
	          arrs.add(current_element1);    
	       }
	       
	     }    
	   }  
	   return arrs;
	    
    }
    //o(nlogn) against standard quadratic time complexity of o(n //squared)
   static ArrayList<Integer> fastIntersection(int[] arr1,int[] arr2)
    {
     ArrayList<Integer> result=new ArrayList<>(0);
     Arrays.sort(arr1);
     Arrays.sort(arr2);
     int p1=0;
     int p2=0;
     
     while(p1<arr1.length&&p2<arr2.length)
     {
      int elem1=arr1[p1];
      int elem2=arr2[p2];
      if(elem1>elem2)
      {
       p2++;
      }
      else if(elem2>elem1)
      {
      p1++;
      }
      else
      {
          result.add(elem1);
          p1++;
          p2++;
          }    
     }    
   
     
     
     return result;  
    }
	
}