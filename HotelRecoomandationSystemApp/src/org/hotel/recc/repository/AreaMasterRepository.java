package org.hotel.recc.repository;

import org.hotel.recc.config.DBHelper;
import org.hotel.recc.model.AreaMasterModel;

public class AreaMasterRepository extends DBHelper{
	
		public boolean isAddNewArea(AreaMasterModel aModel)
		{
			try
			{
				pstmt = conn.prepareStatement("inser into areamaster values('0',?)");
				pstmt.setString(1, aModel.getAreaName());
				int value = pstmt.executeUpdate();
				return value>0?true:false;
			}
			catch(Exception ex)
			{
				System.out.println("Error is "+ex);
				return false;
			}
		}
}
