package com.epam.osmachko.property;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.epam.osmachko.constant.Constant;

public class PropertyPathHandler {

	private InputStream stream;
	
	private static final Logger LOGGER = Logger.getLogger(PropertyPathHandler.class);
	
	public String getAvatarPath() throws IOException {
		String pathToAvatarDir = null;
		try {
		Properties prop = new Properties();
		String propFileName = Constant.AVATAR_PATH;
		stream = getClass().getResourceAsStream(propFileName);
		Reader reader = new InputStreamReader(stream, "UTF-8");
		if(stream != null) {
			prop.load(reader);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		 pathToAvatarDir = prop.getProperty("avatarPath");
		return pathToAvatarDir;
	} catch (Exception e) {
		System.out.println("Exception: " + e);
	} finally {
		stream.close();
	}
		return pathToAvatarDir;
	}
	
	
	public String getCarPicturePath() throws IOException {
		String pathToAvatarDir = null;
		try {
		Properties prop = new Properties();
		String propFileName = Constant.ITEM_PICTURE;
		stream = getClass().getResourceAsStream(propFileName);
		Reader reader = new InputStreamReader(stream, "UTF-8");
		if(stream != null) {
			prop.load(reader);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		 pathToAvatarDir = prop.getProperty("picturePath");
		return pathToAvatarDir;
	} catch (Exception e) {
		System.out.println("Exception: " + e);
	} finally {
		stream.close();
	}
		return pathToAvatarDir;
	}
}
