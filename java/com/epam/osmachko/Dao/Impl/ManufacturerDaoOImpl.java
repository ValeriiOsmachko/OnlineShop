package com.epam.osmachko.Dao.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.epam.osmachko.DBConnection.JdbcConnectionHolder;
import com.epam.osmachko.constant.Constant;
import com.epam.osmachko.entity.Manufacturer;
import com.epam.osmachko.exception.DataBaseException;
import com.epam.osmachko.query.Query;

public class ManufacturerDaoOImpl {

	public static final Logger LOGGER = Logger.getLogger(ManufacturerDaoOImpl.class);
	
	public List<Manufacturer> getAllManufacturers() {
		Connection connection = JdbcConnectionHolder.getConnection();
		List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
		try(java.sql.Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(Query.SELECT_ALL_MANUFACTURERS)) {
			while(rs.next()) {
				manufacturers.add(mapper(rs));
			}
		} catch (SQLException e) {
			DataBaseException e1 = new DataBaseException(Constant.ERROR_MESSAGE, e);
			LOGGER.error(Constant.ERROR_MESSAGE, e1);
			throw e1;
		}
		return manufacturers;
	}
	
	
	private Manufacturer mapper(ResultSet set) throws SQLException {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setId(set.getInt("idManufacturer"));
		manufacturer.setManufacturer(set.getString("manufacturer"));
		return manufacturer;
	}
	
}
