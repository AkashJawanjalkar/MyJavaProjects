package Test_17May;

import java.util.Scanner;

public class String09 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
        System.out.println("Enter a string:"); 
        String str = sc.nextLine(); 
        String[] words = str.split(" "); 
        String reversed = "";
        for (String word : words) 
        {
            String rw = "";
            for (int i=word.length()-1;i>=0;i--) 
            {
                rw = rw+word.charAt(i);
            }
            reversed = reversed+rw + " ";
        }         
        System.out.println("Reversed words:");
        System.out.println(reversed); 
}
}
