package Test_17May;

public class pattern02 {

	public static void main(String[] args) 
	{
		int i,j,n=1;
		int count = 0;
		char ch = 'A';
		
		for(i=1;i<=9;i++)
		{  
		 ch = 'A';
		 n = 1;
			for(j=1;j<=5;j++)
			{ 
				if(j<=i && j<=10-i)
				{		
					if(count==0) 
					{
						System.out.printf(" *");
					}
					else if(count == 1) 
					{
						System.out.printf(" %d",n++);
					}
					else if(count == 2) 
					{
						System.out.printf(" %c",ch++);
					}					
				}
				else
				{
					System.out.printf(" #");
				}
			}
			if(count == 0) 
			{
				count = 1;
			}else if(count == 1) 
			{
				count = 2;
			}else if(count == 2) 
			{
				count = 0;
			}
			System.out.printf("\n");
		}
	}
}