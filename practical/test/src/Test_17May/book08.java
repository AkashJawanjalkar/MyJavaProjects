package Test_17May;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Book{
	private int bid;
	private String 	pubname;
	private String subname;
	private int price;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getPubname() {
		return pubname;
	}
	public void setPubname(String pubname) {
		this.pubname = pubname;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}

public class book08 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		LinkedHashMap<String ,Book>map=new LinkedHashMap<String,Book>();
		
		do {
			System.out.println("\n1.Add new Book:\n2.Search Book By author\tselect Option:");
			int choice=sc.nextInt();
			
			switch(choice) {
			
			case 1:

				System.out.println("Enter Author name:");
				sc.nextLine();
				String aname=sc.nextLine();
				
				Book b=new Book();
				System.out.println("enter book id ,pub name,sub name,price :");
				b.setBid(sc.nextInt());
				sc.nextLine();
				b.setPubname(sc.nextLine());
				b.setSubname(sc.nextLine());
				b.setPrice(sc.nextInt());
				
				map.put(aname, b);
				
				break;
				
			case 2:
				
				System.out.println("Enter Author Name");
				sc.nextLine();
				aname=sc.nextLine();
				Set<Map.Entry<String, Book>> s=map.entrySet();
				int flag=1;
				for(Map.Entry<String, Book>m:s) {
					if(aname.equals(m.getKey())) {
						Book k =m.getValue();
						System.out.println("Author Present.....");
//						System.out.println(k.getBid()+"\t"+k.getPubname()+"\t"+k.getSubname()+"\t"+k.getPrice());
						flag=0;
					}
					
				}
				if(flag==1) {
					System.out.println("Author Not Present...");
				}
				
				break;
				
			default:
					System.out.println("Wrong choice...");
					break;
			}
		}while(true);
	}

}
