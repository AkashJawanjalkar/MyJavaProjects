package org.hotel.recc.repository;
import org.hotel.recc.config.DBHelper;
import org.hotel.recc.model.AreaMasterModel;
import org.hotel.recc.model.CityMasterModel;

public class CityMasterRepository extends DBHelper {

	public boolean isAddNewCity(CityMasterModel cModel)
	{
		try
		{
			pstmt = conn.prepareStatement("Insert into citymaster values('0',?)");
			pstmt.setString(1, cModel.getCityName());
			int value = pstmt.executeUpdate();
			return value>0?true:false;
		}
		catch(Exception ex)
		{
			System.out.println("Error is "+ex);
			return false;
		}
	}

	public boolean isAddNewArea(AreaMasterModel aModel) {
		// TODO Auto-generated method stub
		return false;
	}
}