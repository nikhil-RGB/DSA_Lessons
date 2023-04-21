package examples;
import java.util.Scanner;
public class BinaryDecimal {
public static void main(String[] args) 
 {
	Scanner sc=new Scanner(System.in);
   	System.out.println("Enter a number for conversion");
   	String input=sc.next();
   	System.out.println(binaryToDecimal(input));
   	sc.close();
 }
//This function converts the binary string to decimal
public static int binaryToDecimal(String binary) 
{
	int conversion=1;
	int result=0;
	for(int i=1;i<=binary.length();++i) 
	{
		if(binary.charAt(binary.length()-i)=='1') 
		{
		  result+=conversion;
		}
	  conversion*=2;
	}
return result;
}
}