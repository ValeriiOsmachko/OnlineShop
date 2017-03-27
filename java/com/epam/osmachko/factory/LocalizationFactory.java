package com.epam.osmachko.factory;

import com.epam.osmachko.strategy.TypeOfPassingLocaleGenerator;
import com.epam.osmachko.strategy.impl.CookiePassingLocaleGenerator;
import com.epam.osmachko.strategy.impl.SessionPassingLocaleGenerator;

public class LocalizationFactory {

	public LocalizationFactory() {
		
	}
	
	public TypeOfPassingLocaleGenerator getGenerator(String string) {
		TypeOfPassingLocaleGenerator generator = null;
		switch (string) {
		case "COOKIE":
			generator =  new CookiePassingLocaleGenerator();
			break;
		case "SESSION":
			generator = new SessionPassingLocaleGenerator();
			break;
		default:
			throw new IllegalArgumentException();
		}
		return generator;
	}
	
}
