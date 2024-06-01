package Test_17May;

public class prime03 {

	public static void main(String[] args) 
	{
		
		        System.out.println("Prime numbers between 1 and 100:");

		        for (int num=2;num<=100;num++) 
		        {
		            boolean Pr = true;

		            for (int i=2;i<=num/2;i++) 
		            {
		                if (num%i==0) 
		                {
		                    Pr = false;
		                    break;
		                }
		            }
		            if (Pr) 
		            {
		                System.out.print(num+"\n");
		            }
		        }
		    }
}
