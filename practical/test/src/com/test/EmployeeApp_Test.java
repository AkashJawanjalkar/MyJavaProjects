package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Employee implements Comparable
{
	private int id,sal;
	private String name;
	Employee()
	{
		
	}
	Employee(int id, String name, int sal)
	{
		this.id=id;
		this.name=name;
		this.sal=sal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(Object o) {
		Employee e = (Employee)o;
		if(this.sal>e.sal)
		{
			return 1;
		}
		else if(this.sal<e.sal)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
}
public class EmployeeApp_Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList al = new ArrayList();
		Employee e[] = new Employee[5];
		
		for(int i=0;i<5;i++)
		{
			e[i] = new Employee();
			System.out.println("Enter employee id, name and salary");
			int id = sc.nextInt();
			e[i].setId(id);
			sc.nextLine();
			String name = sc.nextLine();
			e[i].setName(name);
			int sal = sc.nextInt();
			e[i].setSal(sal);
			
			al.add(e[i]);
		}
		System.out.println("data as it is");
		for(Object obj:al)
		{
			Employee e1 = (Employee)obj;
			System.out.println(e1.getId()+"\t"+e1.getName()+"\t"+e1.getSal());
		}
		
		int ch;
		do
		{
			System.out.println("Enter choice:\n1.salary in desc Order\n2.Second Highest Sal");
			ch =sc.nextInt();
			switch(ch)
			{
			case 1:
				Collections.sort(al);
				Collections.reverse(al);
				System.out.println("data after sort");
				for(Object obj:al)
				{
					Employee e1 = (Employee)obj;
					System.out.println(e1.getId()+"\t"+e1.getName()+"\t"+e1.getSal());
				}
				break;
			case 2:
				int max=0;
				int smax=0;
				
				for(Object obj:al)
				{
					Employee e1 =(Employee)obj;
				
					int num=(int)e1.getSal();
					if(num>max)
					{
						smax=max;
						max=num;
					}
					else if(num>smax)
					{
						smax=num;
					}
				}
				
				//System.out.println("max:"+max);
				System.out.println("smax:"+smax);

				for(Object ob:al)
				{
					Employee e1 =(Employee)ob;
					int num=(int)e1.getSal();

					if(num==smax)
					{
						System.out.println(e1.getId()+"\t"+e1.getName()+"\t"+e1.getSal());
					}
				}
				break;

			default:
				System.out.println("Wrong choice");
			}
		}while(ch<3);

	}

}
