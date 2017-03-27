package com.epam.osmachko.filter;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.epam.osmachko.custom_request_wrapper.CustomRequestWrapper;
import com.epam.osmachko.factory.LocalizationFactory;
import com.epam.osmachko.strategy.TypeOfPassingLocaleGenerator;

public class LocalizationFilter implements Filter {

	private FilterConfig config;

	private String languagesInFilterInitParam;

	private List<Locale> supportedLanguages;

	private TypeOfPassingLocaleGenerator generator;

	private String strategyTypeFormFilterInitParam;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		languagesInFilterInitParam = config.getInitParameter("SupportedLocales");
		supportedLanguages = parseStringInitParametersIntoList(languagesInFilterInitParam);
		strategyTypeFormFilterInitParam = config.getInitParameter("LanguageStrategy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		LocalizationFactory localizationFactory = new LocalizationFactory();
		generator = localizationFactory.getGenerator(strategyTypeFormFilterInitParam);
		Locale locale = checkRequestLang(httpRequest);
		if (locale == null) {
			locale = generator.getLocale(httpRequest);
		}
		if (locale == null) {
			locale = detectLocale(httpRequest);
			if (locale == null) {
				locale = setDefaultLocale(config);
			}
		}
		generator.saveLocale(httpRequest, httpResponse, locale);
		CustomRequestWrapper wrapper = new CustomRequestWrapper(httpRequest, locale);
		chain.doFilter(wrapper, httpResponse);
	}

	@Override
	public void destroy() {

	}

	private List<Locale> parseStringInitParametersIntoList(String string) {
		List<Locale> list = new ArrayList<>();
		for (String element : string.split(" ")) {
			list.add(new Locale(element));
		}
		return list;
	}

	private Locale setDefaultLocale(FilterConfig filterConfig) {
		String defaultLocale = filterConfig.getInitParameter("DefaultLocale");
		Locale locale = new Locale(defaultLocale);
		return locale;
	}

	private Locale detectLocale(HttpServletRequest request) {
		Locale requestLocale = null;
		Enumeration<Locale> locales = request.getLocales();
		while (locales.hasMoreElements()) {
			Locale locale = (Locale) locales.nextElement();
			if (supportedLanguages.contains(locale)) {
				requestLocale = locale;
				break;
			}
		}
		return requestLocale;
	}

	private Locale checkRequestLang(HttpServletRequest request) {
		String language = request.getParameter("lang");
		Locale locale = null;
		if (language != null) {
			locale = new Locale(language);
			if (supportedLanguages.contains(locale)) {
				return locale;
			}
		}
		return null;
	}

}
