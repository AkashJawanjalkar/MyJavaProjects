package Test_17May;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class dup_witout_map05 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HashMap<Integer,Integer> m=new HashMap<>();
		System.out.println("Enter the size");
		int n=sc.nextInt();
		System.out.println("Enter the key and value");
		for(int i=0;i<n;i++)
		{
			int k=sc.nextInt();
			int val=sc.nextInt();
			m.put(k,val);
		}
		
		Set<Integer>dp=new HashSet<>();
		System.out.println("Duplicate elemenrts in map");
		for(Map.Entry<Integer, Integer> entry:m.entrySet())
		{
			int val1=entry.getValue();
			if(!dp.add(val1))
			{
				System.out.println(val1);
			}
		}
	}
}