package Test_17May;

public class pattern01 {

	public static void main(String[] args) {
		            
		            int n=5;
		            int  count=0;
		            
		             for(int i=1;i<=n;i++) 
		             {
		            	 char ch =(i %2==0)?'a':'A';
		                 for (int j = 1; j <= i; j++) 
		                 {

		                     System.out.print(ch + " ");
		                     ch++;
		                 }
		                 System.out.println();
		             }
		             
		    }
}