package Test_17May;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class file06 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		FileWriter fw=new FileWriter("C:\\demo\\demo123.txt");
		
		System.out.println("Enter String :");
		String ch=sc.nextLine();
		fw.write(ch);
		
		System.out.println("String Save successfully...");
		fw.close();
		
		
		char arr[]=new char[20];
		
		int k=0;
		FileReader fr=new FileReader("C:\\demo\\demo123.txt");
		
		int data;
		int flag2=0;
		while((data=fr.read())!=-1) {
			char ch1=(char)data;
			int flag=1;
			for(int i=0;i<k;i++) {
				if(arr[i]==ch1) {
					flag=0;
				}
			}
			
			if(flag==1) {
				arr[k]=ch1;
				k++;
			}
			else {
				System.out.println("Duplicate Character...");
				System.out.println(ch1);
				flag2=1;
			}
			
		}
		
		if(flag2==0) {
			System.out.println("No Duplicate Character....");
		}
		
		fr.close();
	}

}
