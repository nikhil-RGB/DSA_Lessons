package examples;
import java.util.Scanner;
public class OctalInt {
	public static void main(String[] args) 
	 {
		Scanner sc=new Scanner(System.in);
	   	System.out.println("Enter a number for conversion");
	   	String input=sc.next();
	   	System.out.println(octalToDecimal(input));
	   	sc.close();
	 }
	//This function converts the binary string to decimal
	public static int octalToDecimal(String octal) 
	{
		int conversion=1;
		int result=0;
		for(int i=1;i<=octal.length();++i) 
		{
			
	      result+=conversion*Integer.parseInt(octal.charAt(octal.length()-i)+"");
			
		  conversion*=8;
		}
	return result;
	}

}
