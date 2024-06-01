package org.house.predict.respository;

import java.io.*;
import java.util.*;
import java.sql.*;
import org.house.predict.config.*;
import org.house.predict.model.*;

public class CityMasterRepository extends DBHelper {
	private List<CityMasterModel> list = new ArrayList<CityMasterModel>();
	private List<Object[]> cityWiseAreaCountList;
	private LinkedHashMap<String,ArrayList<String>> cityWiseNameAreaMap;
	private LinkedHashMap<String, Integer> map;
	private int areaid = 0;
	// this method can add city in db table name as city master and get database
	// from city master model class
	public boolean isAddnewCity(CityMasterModel model) {
		try {
			stmt = conn.prepareStatement("insert into citymaster values('0',?)");

			stmt.setString(1, model.getCityName());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}

	public List<CityMasterModel> getAllCities() {
		try {
			stmt = conn.prepareStatement("select * from citymaster");
			rs = stmt.executeQuery();
			while (rs.next()) {
				CityMasterModel model = new CityMasterModel();
				model.setCityId(rs.getInt(1));
				model.setCityName(rs.getString(2));
				list.add(model);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}

	public boolean isAddBulkCities() {
		try {
			FileReader fr = new FileReader(PathHelper.path + "city.csv");
			BufferedReader br = new BufferedReader(fr);
			int value = 0;
			String line = null;
			while ((line = br.readLine()) != null) {
				String data[] = line.split(",");
				stmt = conn.prepareStatement("insert into citymaster values('0',?)");
				stmt.setString(1, data[1]);
				value = stmt.executeUpdate();
			}
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}

	}

	public int getCity(String name) {
		try {
			stmt = conn.prepareStatement("select cityid from citymaster where cityname=?");
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;// indicatetes city not present in database
			}
		} catch (Exception ex) {
			System.out.println("Error is ");
			return -1;
		}
	}

	public int getAreaIdAtomatic() {
		try {
			stmt = conn.prepareStatement("select max(aid) from areamaster");
			rs = stmt.executeQuery();
			if (rs.next()) {
				this.areaid = rs.getInt(1);
			}
			++areaid;
			return areaid;
		} catch (Exception ex) {
			return 0;
		}

	}

	public boolean isAddArea(AreaMasterModel model) {
		try {
//			stmt = conn.prepareStatement("insert into areamaster values(?,?)");
//			pstmt.setInt(1, model.getAreaId());
//			pstmt.setString(2, model.getAreaName());
//			int value = stmt.executeUpdate();
//			if(value>0)
//			{
//				pstmt = conn.prepareStatement("insert into cityareajoin value(?,?)");
//				
//			}
			CallableStatement cstmt = conn.prepareCall("call savearea1(?,?,?)");
			cstmt.setInt(1, model.getAreaId());
			cstmt.setString(2, model.getAreaName());
			cstmt.setInt(3, model.getCityId());
			boolean b = cstmt.execute();
			return !b;
		} catch (Exception ex) {
			System.out.println("Erro is " + ex);
			return false;
		}
	}

	public LinkedHashMap<String, Integer> getCityWiseCount() {
		{
			try {
				map = new LinkedHashMap<String, Integer>();
				this.cityWiseAreaCountList = new ArrayList<Object[]>();

				stmt = conn.prepareStatement(
						"select cm.cityname, count(crj.cityid) from citymaster cm inner join cityareajoin crj on cm.cityid=crj.cityid inner join areamaster am on am.aid=crj.aid group by cm.cityid");
				rs = stmt.executeQuery();
				while (rs.next()) {
					map.put(rs.getString(1), rs.getInt(2));
				}
				return map;
			} catch (Exception ex) {
				System.out.println("Error is " + ex);
				return null;
			}
		}
	}

	public LinkedHashMap<String, ArrayList<String>> getCiityWiseAreaName() {
		try {
			this.cityWiseNameAreaMap = new LinkedHashMap<String, ArrayList<String>>();
			stmt = conn.prepareStatement("select cityname from citymaster");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				String cityName=rs.getString(1);
				PreparedStatement stmt1=conn.prepareStatement("select am.areanem from areamaster am inner join cityareajoin caj on am.aid=caj.aid inner join citymaster cm on caj.cityid=cm"
						+ ".cityid where cm.cityname=?");
				stmt1.setString(1,cityName );
				ResultSet rs1 = stmt1.executeQuery();
				ArrayList <String> areaName = new ArrayList<String>();
				while(rs1.next())
				{
					areaName.add(rs1.getString(1));
				}
				this.cityWiseNameAreaMap.put(cityName, areaName);
			}
			return this.cityWiseNameAreaMap;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null; 
		}
		
	}
}
