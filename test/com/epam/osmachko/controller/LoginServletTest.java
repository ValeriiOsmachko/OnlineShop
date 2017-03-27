package com.epam.osmachko.controller;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import com.epam.osmachko.ValidatorUtil.InputFormValidator;
import com.epam.osmachko.bean.Captcha;
import com.epam.osmachko.capture_manager.CaptchaManager;
import com.epam.osmachko.entity.User;
import com.epam.osmachko.service.UserService;

import static org.mockito.Mockito.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import junit.framework.TestCase;

public class LoginServletTest extends TestCase {
	
	
	ServletContext servletContext;
	LoginServlet servlet;
	UserService service;
	HttpServletRequest request;
	HttpServletResponse response;
	CaptchaManager manager;
	private  String VALID_FIRST_NAME = "Valerii";
	private  String VALID_SECOND_NAME = "Osmachko";
	private  String VALID_EMAIL = "v_osa@mail.ru";
	private  String VALID_PASSWORD = "Vasdwgfgsedgsertg34fsdg";
	private  String VALID_LOGIN = "valek1544";
	private  String VALID_CAPTCHA = "463734";
	private Captcha captcha;
	private HttpSession session;
	
	
	@Before
	public void setUp() {
		servletContext = mock(ServletContext.class);
		session = mock(HttpSession.class);
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		servlet = new LoginServlet();
		service = new UserService();
		Map<String,Captcha> map = new ConcurrentHashMap<String, Captcha>();
		manager = mock(CaptchaManager.class);
		captcha = new Captcha();
		captcha.setCreationTime(12413534252l);
		captcha.setValue("236433");
	}
	
	@Test
	public void testServletDoPostSuccess() throws Exception {
		InputFormValidator validator = new InputFormValidator();
		when(request.getParameter("firstName")).thenReturn(VALID_FIRST_NAME);
		when(request.getParameter("lastName")).thenReturn(VALID_SECOND_NAME);
		when(request.getParameter("email")).thenReturn(VALID_EMAIL);
		when(request.getParameter("password")).thenReturn(VALID_PASSWORD);
		when(request.getParameter("login")).thenReturn(VALID_LOGIN);
		when(request.getParameter("captcha")).thenReturn(VALID_CAPTCHA);
		when(manager.validate(request, response)).thenReturn(true);		
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute("captchaAnswer")).thenReturn(captcha);
		servlet.doPost(request, response);
		service.create((User)anyObject());;
		verify(response, times(1)).sendRedirect(("listItems.html"));	
	}
	

	
}
