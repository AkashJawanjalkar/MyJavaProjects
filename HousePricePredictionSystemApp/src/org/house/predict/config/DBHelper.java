package org.house.predict.config;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHelper {
	protected DBConfig db = DBConfig.getDBInstance();
	protected Connection conn = DBConfig.getConnection();
	protected PreparedStatement stmt = DBConfig.getStatement();
	protected ResultSet rs = DBConfig.getResultSet();
}
