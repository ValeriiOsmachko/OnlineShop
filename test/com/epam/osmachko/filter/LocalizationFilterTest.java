package com.epam.osmachko.filter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.cglib.core.Local;

import com.epam.osmachko.custom_request_wrapper.CustomRequestWrapper;
import com.epam.osmachko.factory.LocalizationFactory;
import com.epam.osmachko.strategy.TypeOfPassingLocaleGenerator;
import com.epam.osmachko.strategy.impl.CookiePassingLocaleGenerator;
import com.epam.osmachko.strategy.impl.SessionPassingLocaleGenerator;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LocalizationFilterTest {
	
	private LocalizationFilter Local = new LocalizationFilter();
	
	private HttpServletRequest httpServletRequest;
	
	private HttpServletResponse httpServletResponse;
	
	private FilterConfig config;
	
	private FilterChain chain;
	
	private LocalizationFilter filter;
	
	private HttpSession session;
	
	@Before
	public void test() {
		httpServletRequest = mock(HttpServletRequest.class);
		httpServletResponse = mock(HttpServletResponse.class);
		chain = mock(FilterChain.class);
		config = mock(FilterConfig.class);
		filter = new LocalizationFilter();
		session = mock(HttpSession.class);
	}

	@Test
	public void testDoFilterSuccessCookie() throws IOException, ServletException {
		String defaultLocale = "en";
		when(config.getInitParameter(eq("DefaultLocale"))).thenReturn(defaultLocale);
		String strategy = "COOKIE";
		when(config.getInitParameter(eq("LanguageStrategy"))).thenReturn(strategy);
		String supportedlanguages = "en ru";
		when(config.getInitParameter(eq("SupportedLocales"))).thenReturn(supportedlanguages);
		LocalizationFactory factory = mock(LocalizationFactory.class);
		when(httpServletRequest.getParameter("lang")).thenReturn("en");
		TypeOfPassingLocaleGenerator generator = new CookiePassingLocaleGenerator();		
		when(factory.getGenerator(strategy)).thenReturn(generator);
		Cookie[] cookies = new Cookie[1];
		cookies[0] = new Cookie("lang", "en");
		when(httpServletRequest.getCookies()).thenReturn(cookies);
		filter.init(config);
		filter.doFilter(httpServletRequest, httpServletResponse, new FilterChain() {
			@Override
			public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
				verify(httpServletResponse).addCookie(any(Cookie.class));
				assertEquals(new Locale("en"), request.getLocale());
			}
		});		
	}
	
	
	@Test
	public void testDoFilterSuccessSession() throws IOException, ServletException {
		String defaultLocale = "en";
		when(config.getInitParameter(eq("DefaultLocale"))).thenReturn(defaultLocale);
		String strategy = "SESSION";
		when(config.getInitParameter(eq("LanguageStrategy"))).thenReturn(strategy);
		String supportedlanguages = "en ru";
		when(config.getInitParameter(eq("SupportedLocales"))).thenReturn(supportedlanguages);
		LocalizationFactory factory = mock(LocalizationFactory.class);
		when(httpServletRequest.getParameter("lang")).thenReturn("en");
		TypeOfPassingLocaleGenerator generator = new SessionPassingLocaleGenerator();		
		when(factory.getGenerator(strategy)).thenReturn(generator);
		when(httpServletRequest.getSession()).thenReturn(session);
		String lang = "en";
		when(session.getAttribute("lang")).thenReturn(lang);
		filter.init(config);
		filter.doFilter(httpServletRequest, httpServletResponse, new FilterChain() {
			@Override
			public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
				verify(httpServletRequest.getSession()).setAttribute("lang", "en");
				assertEquals("en", httpServletRequest.getSession().getAttribute("lang"));
			}
		});		
	}

}
