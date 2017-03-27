package com.epam.osmachko.sqlbuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Properties;

import com.epam.osmachko.constant.Constant;

public class SQLQueryBuilder {
	
	private InputStream is;

	public SQLQueryBuilder() {
		
	}
	
	public Properties getQueries() throws SQLException, IOException {
		Properties prop = new Properties();
		is = getClass().getResourceAsStream(Constant.SQL_PROPERTIES);
		Reader reader = new InputStreamReader(is, "UTF-8");
		if(is != null) {
			prop.load(reader); 
		} else {
			throw new FileNotFoundException("property file '" + Constant.SQL_PROPERTIES + "' not found in the classpath");
		}
		return prop;
	}
	
	public String getQuery(String query) throws SQLException, IOException {
		return getQueries().getProperty(query);
	}
	
}
