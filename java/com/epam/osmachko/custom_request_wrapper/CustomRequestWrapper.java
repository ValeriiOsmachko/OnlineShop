package com.epam.osmachko.custom_request_wrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomRequestWrapper extends HttpServletRequestWrapper {
	
	private Enumeration<Locale> localeEnumeration;
	
	private Locale locale;

	public CustomRequestWrapper(HttpServletRequest request,Locale locale) {
		super(request);
		this.locale = locale;
		List<Locale> localeList = new ArrayList<>();
		localeList.add(locale);
		localeEnumeration = Collections.enumeration(localeList);
	}

	
	@Override
	public Locale getLocale() {
		return locale;
	}

	
	@Override
	public Enumeration<Locale> getLocales() {
		return localeEnumeration;
	}
	
	
	
	

	
	
	
	
}
