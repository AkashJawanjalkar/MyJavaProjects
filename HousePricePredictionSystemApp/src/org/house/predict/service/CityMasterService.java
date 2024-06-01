package org.house.predict.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.house.predict.model.AreaMasterModel;
import org.house.predict.model.CityMasterModel;
import org.house.predict.respository.CityMasterRepository;


public class CityMasterService {

	CityMasterRepository citymasterRepo = new CityMasterRepository();
	
	public boolean isAddCity(CityMasterModel model)
	{
		boolean b = citymasterRepo.isAddnewCity(model);
		return b;
	}
	public List<CityMasterModel> getAllCities()
	{
//		List<CityMasterModel> list= cityRepo.getAllCities();
//		return list;
		return citymasterRepo.getAllCities();
	}
	public boolean isBulkAddCities()
	{
		return  citymasterRepo.isAddBulkCities();
	}
	public int getCityId(String CityName)
	{
		return citymasterRepo.getCity(CityName);
	}
	public int getAreaIdAtomatic()
	{
		return citymasterRepo.getAreaIdAtomatic();
	}
	public boolean isAddArea(AreaMasterModel model)
	{
		return citymasterRepo.isAddArea(model); 
	}
	public LinkedHashMap<String, Integer> getCityWiseCount() {
		return this.citymasterRepo.getCityWiseCount();
	}
	public LinkedHashMap<String, ArrayList<String>> getCiityWiseAreaName() {
		return this.citymasterRepo.getCiityWiseAreaName();
	}
}
