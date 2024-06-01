package Test_17May;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Map04 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter the element Of array");
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		HashMap<Integer,Integer> m=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			if(m.containsKey(arr[i]))
			{
				m.put(arr[i], m.get(arr[i])+1);
			}
			else
			{
				m.put(arr[i],1);
			}
		}
		System.out.println("Duplicate Element are");
		for(Map.Entry<Integer, Integer>entry:m.entrySet())
		{
			if(entry.getValue()>1)
			{
				System.out.println(entry.getKey());
			}
		}
		}
}
