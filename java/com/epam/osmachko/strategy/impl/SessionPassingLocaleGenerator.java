package com.epam.osmachko.strategy.impl;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.osmachko.strategy.TypeOfPassingLocaleGenerator;

public class SessionPassingLocaleGenerator implements TypeOfPassingLocaleGenerator {

	@Override
	public Locale getLocale(HttpServletRequest request) {
		String lang = (String) request.getSession().getAttribute("lang");
		if(lang != null) {
			return new Locale(lang);
		}
		return null;
	}

	

	@Override
	public void saveLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		request.getSession().setAttribute("lang", locale.getLanguage());
		
	}

}
