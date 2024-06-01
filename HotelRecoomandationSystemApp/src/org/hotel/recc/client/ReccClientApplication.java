package org.hotel.recc.client;
import java.util.*;
import java.io.*;

import org.hotel.recc.model.AreaMasterModel;
import org.hotel.recc.model.CityMasterModel;
import org.hotel.recc.service.CityMasterService;
import static java.lang.System.*;

public class ReccClientApplication {
	
	public static void main(String args[])
	{
		CityMasterModel cModel = new CityMasterModel();
		CityMasterService cms = new CityMasterService();
		AreaMasterModel aModel = new AreaMasterModel();
		Scanner sc = new Scanner(System.in);
		
		do
		{
			System.out.println("Enter choice");
			int ch;
			System.out.println("1:login for Admin");
			System.out.println("2:login for User");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Enter id and Password for login");
				String uid = sc.next();
				String upw = sc.next();
				
				if( ("AJ".equalsIgnoreCase(uid)) && ("RB".equalsIgnoreCase(upw)))
				{
				do
				{
					System.out.println("Enter choice");
					System.out.println("1:Add new City");
					System.out.println("2:Add Area Name");
					System.out.println("3:Add new Hotel");
					System.out.println("4:show Bookings");
					
					int choice = sc.nextInt();
					switch(choice)
					{
					case 1:
						System.out.println("Enter city name");
						String CityName = sc.next();
						cModel.setCityName(CityName);
						boolean b = cms.isAddNewCity(cModel);
						if(b)
						{
							System.out.println("city added successfully.....");
						}
						else
						{
							System.out.println("City not added");
						}
						break;
				
					case 2:
						System.out.println("enter area name");
						String AreaName = sc.next();
						aModel.setAreaName(AreaName);
						b = cms.isAddNewArea(aModel);
						if(b)
						{
							System.out.println("Area added successfully......");
						}
						else
						{
							System.out.println("Area not addded");
						}
						
						break;
						
					default:
						System.out.println("Wrong choice");
					}
				}
				while(true);
				}
				else
				{
					System.out.println("Enter correct UserNAme And Password");
				}
			break;
			
			case 2:
				do
				{
					System.out.println("Enter choice");
					System.out.println("1:Register");
					System.out.println("2:view All Cities");
					System.out.println("3:view All Hotels");
					System.out.println("4:View Hotles by ratings");
					System.out.println("5:View Hotels by Price");
					System.out.println("6:Book hotel");
					
					int choice = sc.nextInt();
					switch(choice)
					{
					case 1:
						System.out.println("Enter name, MoNo, Email");
						String name = sc.next();
						String MoNo = sc.next();
						String Email = sc.next();
						
					case 2:
						System.out.println("View All Cities");
						
						break;
						
					default:
						System.out.println("Wrong choice");
					}
				}
				while(true);
			default:
				System.out.println("Wrong choice");
			}
		}
		while(true);
	}
}