package examples;

public class PairsInArray {

	public static void main(String[] args) {
	 
		int[] arr=new int[] {2,3,4};
		for(int i=0;i<arr.length;++i) 
		{
			int x=arr[i];
			for(int j=0;j<arr.length;++j) 
			{
				int y=arr[j];
				System.out.println(x+" "+y+ " is a Pair ");
				
			}
		}
	}

}
