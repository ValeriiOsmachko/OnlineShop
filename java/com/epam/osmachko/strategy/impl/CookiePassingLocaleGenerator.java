package com.epam.osmachko.strategy.impl;

import java.util.Locale;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.osmachko.strategy.TypeOfPassingLocaleGenerator;

public class CookiePassingLocaleGenerator implements TypeOfPassingLocaleGenerator{

	@Override
	public Locale getLocale(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null)   {
			for(Cookie element : cookies) {
				if(element.getName().equals("lang")) {
					System.out.println("LANGUAGE = " + element.getValue());
					return new Locale(element.getValue());
				}
			}
		}
		return null;
	}


	@Override
	public void saveLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		Cookie cookie = new Cookie("lang", locale.getLanguage());
		cookie.setMaxAge(3600);
		response.addCookie(cookie);
	}

}
