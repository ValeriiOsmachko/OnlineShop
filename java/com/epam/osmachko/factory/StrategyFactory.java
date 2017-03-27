package com.epam.osmachko.factory;

import java.util.Map;

import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;

import com.epam.osmachko.bean.Captcha;
import com.epam.osmachko.capture_manager.CaptchaManager;
import com.epam.osmachko.capture_manager.impl.CookieCaptcha;
import com.epam.osmachko.capture_manager.impl.HiddenFieldCaptcha;
import com.epam.osmachko.capture_manager.impl.SessionCaptcha;

public class StrategyFactory {

	private enum StrategyType {
		HiddenFieldStrategy, SessionStrategy, CookieStrategy;
	}

	public static CaptchaManager strategyCreator(ServletContext ctx) {
		Map<String,Captcha> concurrentMap = new ConcurrentHashMap<String, Captcha>();
		StrategyType type = StrategyType.valueOf(ctx.getInitParameter("Strategy"));
		Double timeOut = Double.parseDouble(ctx.getInitParameter("TimeOutOfCapthca"));
		CaptchaManager manager = null;
		if (type.equals(StrategyType.HiddenFieldStrategy)) {
			return manager = new HiddenFieldCaptcha(concurrentMap,timeOut);
		}
		if (type.equals(StrategyType.SessionStrategy)) {
			return manager = new SessionCaptcha(concurrentMap,timeOut);
		}
		if (type.equals(StrategyType.CookieStrategy)) {
			return manager = new CookieCaptcha(concurrentMap,timeOut);
		}
		return null;
	}
}
