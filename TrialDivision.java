import java.util.*;
public class TrialDivision {
	public static void main(String[] args) 
	{
		int number=50;//2*5*5
		ArrayList<Long> arrs=primeFactors(number);
		for(long num:arrs)
		{
		  System.out.println(num);    
		}
	}
	public static ArrayList<Long> primeFactors(int number)
	{
	  ArrayList<Long> factors=new ArrayList<>(0);
	  long factor=2;
	  while(number>1)
	  {
	   if((number%factor)==0)
	   {
	     number/=factor;
	     factors.add(factor);    
	   }
	   else
	   {
	   ++factor;
	   }   
	  }
	  return factors;
	}
}