package com.epam.osmachko.capture_manager.impl;

import java.util.Map;


import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.osmachko.ValidatorUtil.ValidateTimeOut;
import com.epam.osmachko.bean.Captcha;
import com.epam.osmachko.capture_manager.CaptchaManager;
import com.epam.osmachko.constant.Constant;

public class SessionCaptcha implements CaptchaManager {

	public static final String REG_EXP_INTEGER = "(?<=\\s|^)\\d+(?=\\s|$)";

	private Map<String,Captcha> map;
	
	private Double timeOut;
	
	public SessionCaptcha(Map<String, Captcha> concurrentMap, Double timeOut) {
		this.map = concurrentMap;
		this.timeOut = timeOut;
	}

	public void save(HttpServletRequest request, HttpServletResponse response) {
		Captcha captcha = (Captcha) request.getAttribute("Capthca");
		captcha.setCreationTime(System.currentTimeMillis());
		Random random = new Random();
		Integer idSession = random.nextInt(10000);
		map.put(idSession.toString(), captcha);
		request.getServletContext().setAttribute("CapthcaCont", map);
		HttpSession session = request.getSession();
		session.setAttribute("captchaAnswer", captcha);
	}

	public boolean validate(HttpServletRequest request, HttpServletResponse response) {
		String value = request.getParameter("captcha");
		Captcha captcha = (Captcha) request.getSession().getAttribute("captchaAnswer");
		if (value.matches(REG_EXP_INTEGER)) {
			if (captcha.getValue().equals(value) && ValidateTimeOut.validateTimeOutCaptca(captcha, request)) {
				return true;
			}
		}

		return false;
	}

	public void cleanOldCaptcha() {
		for (Map.Entry<String, Captcha> entry : map.entrySet()) {
			if (System.currentTimeMillis() - entry.getValue().getCreationTime() > timeOut * Constant.MILLISECONDS) {
				map.remove(entry.getKey());
			}
		}
	}

	



}
