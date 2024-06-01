package org.hotel.recc.service;

import org.hotel.recc.model.AreaMasterModel;
import org.hotel.recc.model.CityMasterModel;
import org.hotel.recc.repository.CityMasterRepository;

public class CityMasterService {
	CityMasterRepository cityMasterRepo = new CityMasterRepository();
	
	public boolean isAddNewCity(CityMasterModel cModel) {
		// TODO Auto-generated method stub
		return cityMasterRepo.isAddNewCity(cModel);
	}
	
	public boolean isAddNewArea(AreaMasterModel aModel)
	{
		return cityMasterRepo.isAddNewArea(aModel);
	}
}