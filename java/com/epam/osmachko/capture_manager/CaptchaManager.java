package com.epam.osmachko.capture_manager;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface CaptchaManager {
	
	void save(HttpServletRequest request,HttpServletResponse response);
	
	boolean validate(HttpServletRequest request, HttpServletResponse response);
	
	void cleanOldCaptcha();
	
}
