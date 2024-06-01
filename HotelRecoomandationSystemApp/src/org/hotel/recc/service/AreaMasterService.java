package org.hotel.recc.service;


import org.hotel.recc.model.AreaMasterModel;

public class AreaMasterService {
    AreaMasterService AreaRepo= new AreaMasterService();
    public static boolean isAddNewArea(AreaMasterService cModel) {
        // TODO Auto-generated method stub
        return AreaMasterService.isAddNewArea(cModel);
    }
    public boolean isAddNewArea(AreaMasterModel aModel)
    {
        return AreaRepo.isAddNewArea(aModel);
    }
}