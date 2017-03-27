package com.epam.osmachko.strategy;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface TypeOfPassingLocaleGenerator {

	Locale getLocale(HttpServletRequest request);
	
	void saveLocale(HttpServletRequest request,HttpServletResponse response,Locale locale);
	
	
	
}
