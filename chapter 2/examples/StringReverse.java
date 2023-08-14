package examples;
import data_structures.*;
import java.util.Optional;
public class StringReverse {

	public static void main(String[] args) 
	{
		System.out.println("Hello World");	
		System.out.println(reverse("Hello World"));
//		System.out.println(reverse("").isEmpty()?"Empty":"Unexpected");
	}
	//This method is used to reverse the String
	public static String reverse(String str) 
	{
		StringBuilder result=new StringBuilder();
		Stack<Character> stck=new Stack<>();
		for(char c:str.toCharArray()) 
		{
			stck.push(c);
		}
		Optional<Character> chr=stck.pop();
		while(chr.isPresent()) 
		{
			result.append(chr.get());
			chr=stck.pop();
		}
		return result.toString();
		
	}
	
}
