package com.epam.osmachko.thread;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;

import com.epam.osmachko.bean.Captcha;
import com.epam.osmachko.capture_manager.CaptchaManager;
import com.epam.osmachko.constant.Constant;

public class CaptchaCleaner implements Runnable {

	private CaptchaManager manager;

	public CaptchaCleaner(CaptchaManager manager) {
		this.manager = manager;
	}

	public void run() {
		while (true) {
			manager.cleanOldCaptcha();
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
