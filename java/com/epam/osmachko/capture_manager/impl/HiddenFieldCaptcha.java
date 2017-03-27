package com.epam.osmachko.capture_manager.impl;

import java.util.Map;


import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.osmachko.ValidatorUtil.ValidateTimeOut;
import com.epam.osmachko.bean.Captcha;
import com.epam.osmachko.capture_manager.CaptchaManager;
import com.epam.osmachko.constant.Constant;

public class HiddenFieldCaptcha implements CaptchaManager {

	private Map<String, Captcha> map;

	private Double timeOut;

	public HiddenFieldCaptcha(Map<String, Captcha> concurrentMap, Double timeOut) {
		this.map = concurrentMap;
		this.timeOut = timeOut;

	}

	public void save(HttpServletRequest request, HttpServletResponse response) {
		Captcha captcha = (Captcha) request.getAttribute("Capthca");
		captcha.setCreationTime(System.currentTimeMillis());
		String uuid = (String) request.getSession().getAttribute("uuid");
		map.put(uuid, captcha);
		request.setAttribute("idCaptcha", uuid);
	}

	public boolean validate(HttpServletRequest request, HttpServletResponse response) {
		String value = request.getParameter("captcha");
		String uuid = request.getParameter("idCaptcha");
		for (Map.Entry<String, Captcha> entry : map.entrySet()) {
			if (uuid.equals(entry.getKey())) {
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
