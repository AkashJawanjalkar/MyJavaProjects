package org.house.predict.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class PathHelper {
	public static FileInputStream fin=null;
	public static File f=new File(".");
	public static String path=(f.getAbsolutePath().substring(0, f.getAbsolutePath().length()-1))+"src\\";
	static{
		 
		String path1 = path+"db.properties";
		try 
		{
			 fin = new FileInputStream(path1);
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}