package com.epam.osmachko.ValidatorUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.epam.osmachko.bean.RegistrationFormBean;

public class InputFormValidator {

	private Map<RegExpEnum, String> regExpContainer;

	private Map<RegExpEnum, String> errorMasseges;

	public InputFormValidator() {
		regExpContainer = initContainer(regExpContainer);
		errorMasseges = initMasseges(errorMasseges);
	}

	private enum RegExpEnum {
		FirstName, LastName, Login, Password, Email;

	}

	public Map<String, String> validateInputForm(Object bean) {
		Method[] methods = bean.getClass().getDeclaredMethods();
		Map<String, String> errors = new HashMap<String, String>();
		for (Method method : methods) {
			if (method.getName().startsWith("get")) {
				try {
					String field = (String) method.invoke(bean, method.getParameters());
					String pattern = executePattern(RegExpEnum.valueOf(method.getName().substring(3)));
					validateField(field, pattern, errors, method);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}

			}
		}
		return errors;
	}

	public Map<RegExpEnum, String> initContainer(Map<RegExpEnum, String> regExpContainer) {
		regExpContainer = new HashMap<RegExpEnum, String>();
		regExpContainer.put(RegExpEnum.FirstName, "^[a-zA-Z ]{2,30}$");
		regExpContainer.put(RegExpEnum.LastName, "^[a-zA-Z ]{2,30}$");
		regExpContainer.put(RegExpEnum.Login, "^[a-z0-9_-]{3,15}$");
		regExpContainer.put(RegExpEnum.Password, "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{8,})$");
		regExpContainer.put(RegExpEnum.Email,
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		return regExpContainer;
	}

	public Map<RegExpEnum, String> initMasseges(Map<RegExpEnum, String> errorMasseges) {
		errorMasseges = new HashMap<RegExpEnum, String>();
		errorMasseges.put(RegExpEnum.FirstName, "Incorrect first name");
		errorMasseges.put(RegExpEnum.LastName, "Incorrect last name");
		errorMasseges.put(RegExpEnum.Login, "Incorrect login");
		errorMasseges.put(RegExpEnum.Password, "Incorrect password");
		errorMasseges.put(RegExpEnum.Email, "Incorrect email");
		return errorMasseges;
	}

	public String executePattern(RegExpEnum value) {
		for (Entry<RegExpEnum, String> entry : regExpContainer.entrySet()) {
			if (entry.getKey().equals(value)) {
				return entry.getValue();
			}
		}
		return null;
	}

	public String executeErrorMessage(RegExpEnum value) {
		for (Entry<RegExpEnum, String> entry : errorMasseges.entrySet()) {
			if (entry.getKey().equals(value)) {
				return entry.getValue();
			}
		}
		return null;
	}

	public void validateField(String field, String pattern, Map<String, String> map, Method method) {
		if (!field.matches(pattern)) {
			String message = method.getName().substring(3).toLowerCase();
			map.put(message, executeErrorMessage(RegExpEnum.valueOf(method.getName().substring(3))));
		}
	}

}
