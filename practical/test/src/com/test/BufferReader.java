package com.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BufferReader {

	public static void main(String[] args) 
	{
		String str="abc mno pqr abc mno stv anc xyz";
		//BufferReader bf = new BufferReader();
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character,Integer>();
		
		for(int i=0;i<str.length();i++)
		{
			Integer count=map.get(str.charAt(i));
			if(count==null)
			{
				count=0;
			}
			++count;
			map.put(str.charAt(i), count);
		}
		
		Set<Map.Entry<Character,Integer>> set = map.entrySet();
		
		for(Map.Entry<Character, Integer> m : set)
		{
			System.out.println(m.getKey()+"\t"+m.getValue());
		}
	}
}