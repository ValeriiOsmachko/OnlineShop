package com.epam.osmachko.capture_manager.impl;

import java.util.Map;

import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.osmachko.ValidatorUtil.ValidateTimeOut;
import com.epam.osmachko.bean.Captcha;
import com.epam.osmachko.capture_manager.CaptchaManager;
import com.epam.osmachko.constant.Constant;

public class CookieCaptcha implements CaptchaManager {

	public static final Logger LOGGER = Logger.getLogger(CookieCaptcha.class);

	private Map<String, Captcha> map;

	private Double timeOut;

	public CookieCaptcha(Map<String, Captcha> concurrentMap, Double timeOut) {
		this.map = concurrentMap;
		this.timeOut = timeOut;
	}

	public void save(HttpServletRequest request, HttpServletResponse response) {
		Captcha captcha = (Captcha) request.getAttribute("Capthca");
		Random random = new Random();
		Integer id = random.nextInt(10000);
		Cookie cookie = new Cookie("Captcha", id.toString());
		captcha.setCreationTime(System.currentTimeMillis());
		map.put(id.toString(), captcha);
		response.addCookie(cookie);
	}

	public boolean validate(HttpServletRequest request, HttpServletResponse response) {
		String value = request.getParameter("captcha");
		String idCookie = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie element : cookies) {
			if (element != null) {
				if (element.getName().equals("Captcha")) {
					idCookie = element.getValue();
				}
			}
		}

		for (Map.Entry<String, Captcha> entry : map.entrySet()) {
			if (entry.getKey().equals(idCookie)) {
				if (value.equals(entry.getValue().getValue())
						&& ValidateTimeOut.validateTimeOutCaptca(entry.getValue(), request)) {
					return true;
				}
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
