package com.epam.osmachko.ValidatorUtil;

import javax.servlet.http.HttpServletRequest;

import com.epam.osmachko.bean.Captcha;
import com.epam.osmachko.constant.Constant;

public class ValidateTimeOut {

	public static boolean validateTimeOutCaptca(Captcha captcha, HttpServletRequest request) {
		if (System.currentTimeMillis() - captcha.getCreationTime() <= Double
				.parseDouble(request.getServletContext().getInitParameter("TimeOutOfCapthca")) * Constant.MILLISECONDS) {
			return true;
		}
		return false;
	}
	
}
