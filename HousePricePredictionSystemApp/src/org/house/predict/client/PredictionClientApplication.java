package org.house.predict.client;

import java.util.*;
import static java.lang.System.*;
import org.house.predict.model.AreaMasterModel;
import org.house.predict.model.CityMasterModel;
import org.house.predict.service.*;

public class PredictionClientApplication {

	public static void main(String[] args) {
		CityMasterService cms = new CityMasterService();
		Scanner sc = new Scanner(System.in);
		
		
		do {
			System.out.println("Enter choice");
			int choice;
			out.println("1:Add new City");
			out.println("2:View All Cities");
			out.println("3:Add new Bulk Cityes");
			out.println("4:Add new Area");
			out.println("5:CityWise Area count");
			System.out.println("6:CityWise Area Name");
			out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter city name");
				sc.nextLine();
				String cityName = sc.nextLine();
				CityMasterModel model = new CityMasterModel();
				model.setCityName(cityName);
				boolean b = cms.isAddCity(model);
				if (b) {
					out.println("New city added in DB table");
				} else {
					out.println("City not added");
				}
				break;
			case 2:
				List<CityMasterModel> list=cms.getAllCities();
				if(list!=null)
				{
					list.forEach((m)->System.out.println(m.getCityId()+"\t"+m.getCityName()));
				}
				else
				{
					out.println("there is no city present");
				}
				break;
			case 3:
				b= cms.isBulkAddCities();
				if(b)
				{
 					out.println("City added successfully.......");
				}
				else
				{
					out.println("Some problem is there.....");
				}
				break;
			case 4:
				 sc.nextLine();
				 out.println("Enter city name");
				 String CityName = sc.nextLine();
				 int cityId = cms.getCityId(CityName);
				 System.out.println(cityId);
				 if(cityId!=-1)
				 {
					 System.out.println("Enter area Name");
					 String areaname = sc.nextLine();
					 int areaid=cms.getAreaIdAtomatic();
					 System.out.println(areaname);
					 System.out.println(cityId+"\t"+areaname+"\t"+areaid);
					 AreaMasterModel model1 = new AreaMasterModel();
					 model1.setCityId(cityId);
					 model1.setAreaName(areaname);
					 model1.setAreaId(areaid);
					  b = cms.isAddArea(model1);
					 if(b)
					 {
						 System.out.println("Area added successfully....");
					 }
					 else
					 {
						 System.out.println("Area not added");
					 }
					 
				 }
				 else
				 {
					 System.out.println("city not present in db");
					 System.out.println("Do you want to add city in DB table");
					 String msg=sc.nextLine();
					 if(msg.equals("yes"))
					 {
						 	//cityName = sc.nextLine();
							 model = new CityMasterModel();
							model.setCityName(CityName);
							b = cms.isAddCity(model);
							if (b) {
								out.println("city added in DB table");
							} else {
								out.println("some problem is there");
							}
					 }
					 else
					 {
						 System.out.println("Thank You");
					 }
				 }
				break;
			case 5:
				LinkedHashMap<String,Integer> map = cms.getCityWiseCount();
				Set<Map.Entry<String, Integer>> s = map.entrySet();
				for(Map.Entry<String,Integer> m : s)
				{
					System.out.println(m.getKey()+"\t"+m.getValue());
				}
				break;
			case 6:
				LinkedHashMap<String, ArrayList<String>> areaNames= cms.getCiityWiseAreaName();
				Set<Map.Entry<String, ArrayList<String>>> set = areaNames.entrySet();
				for(Map.Entry<String, ArrayList<String>> m : set)
				{
					ArrayList<String>values=m.getValue();
					if(values.size()>0)
					{
					System.out.println("City Name"+ m.getKey());
					System.out.println("=======================");
					
					for(String areaName:values)
					{
						System.out.println(areaName);
					}
					System.out.println("=======================");
					}
					
				}
				break;
				
			default:
				out.println("Wrong choice");
			}
		} while (true);
	}
}